import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeSum {

    private Node root;

    private Scanner inputScanner;

    private int numNodes;

    public TreeSum(int numNodes, String treeStr)  {
        this.numNodes = numNodes;

        inputScanner = new Scanner(treeStr);
        inputScanner.useDelimiter("\\s+");

        buildTree();

        inputScanner.close();
    }

    private void buildTree() {
        Queue<NodeHelper> pendingOps= new LinkedList<>();
        String token;

        root= new Node(numNodes);
        pendingOps.add(new NodeHelper(root, -1));

        while(inputScanner.hasNext()) {

            token= inputScanner.next();

            NodeHelper aPendingOp = pendingOps.remove();
            Node currentNode = aPendingOp.getNode();
            int childIndex = aPendingOp.getChildIndex();

            if ( token.equals("?") ) {
                for (int i = 0; i < numNodes; i++) {
                    pendingOps.add( new NodeHelper(null, -1) );
                }
            } else {
                if (childIndex >= 0) {
                    currentNode = currentNode.setChild(childIndex, new Node(numNodes));
                }
                currentNode.data= Integer.parseInt(token);
                for (int i = 0; i < numNodes; i++) {
                    pendingOps.add(new NodeHelper(currentNode, i));
                }
            }
        }

        if (root.data == null)
            root= null;
    }

    public void printHierarchy(){
        printHierarchy("", root);
    }

    public void printHierarchy(String initial,  Node current) {
        if ( current == null) {
            return ;
        }
        System.out.println(initial + "|_______ " + current.data);
        if (current.children != null) {
            for (Node child : current.children) {
                printHierarchy( initial + "          ", child );
            }
        }
    }

    class Node {
        private Integer data;
        private Node[] children;

        public Node(int numChildren) {
            this.children = new Node[numChildren];
        }

        public Node setChild(int index, Node aNode) {
            if (index >= 0 && index < children.length) {
                children[index] = aNode;
                return children[index];
            }
            return null;
        }

        private boolean isLeaf() {
            if (children == null) return true;
            for (Node child : children) {
                if (child != null) return false;
            }
            return true;
        }

    }

    static class NodeHelper {

        private Node aNode;
        private int childIndex;

        public NodeHelper(Node aNode, int childIndex) {
            this.aNode= aNode;
            this.childIndex= childIndex;
        }
        public Node getNode() {
            return aNode;
        }
        public int getChildIndex() {
            return childIndex;
        }
    }
    LinkedList<String> sumLessPaths( int sum ){
        LinkedList<String> result = new LinkedList<>();
        if (root != null) {
            sumLessPathsHelper(root, 0, new LinkedList<>(), sum, result);
        }
        return result;
    }

    private void sumLessPathsHelper(Node current, int currentSum, LinkedList<Integer> path, int sum, LinkedList<String> result) {
        if (current == null) {
            return;
        }

        currentSum += current.data;
        path.add(current.data);

        if (current.isLeaf()) {
            if (currentSum < sum) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    sb.append(path.get(i));
                    if (i < path.size() - 1) {
                        sb.append(", ");
                    }
                }
                result.add(sb.toString());
            }
        } else {
            if (current.children != null) {
                for (Node child : current.children) {
                    if (child != null) {
                        sumLessPathsHelper(child, currentSum, path, sum, result);
                    }
                }
            }
        }

        path.removeLast();
    }

    public static void main1(String[] args){
        TreeSum rta = new TreeSum(3,"3 1 2 3 4 8 ? ? ? ? 3 1 30 1");
        rta.printHierarchy();
        LinkedList<String> res = rta.sumLessPaths(10);
        for ( String s: res )
            System.out.println(s);
    }

    public static void main2(String[] args){
        TreeSum rta = new TreeSum(2,"3 1 3 4 8 3 1 ? ? 2 ? 1 ? 0");
        rta.printHierarchy();
        LinkedList<String> res = rta.sumLessPaths(8);
        for ( String s: res )
            System.out.println(s);
    }

    public static void main3(String[] args){
        TreeSum rta = new TreeSum(4,"2 1 2 3 3 4 6 ? ? 3 1 30 ? 3 ? 1 ? ? ? 4");
        rta.printHierarchy();
        LinkedList<String> res = rta.sumLessPaths(8);
        for ( String s: res )
            System.out.println(s);
    }

    public static void main4(String[] args){
        TreeSum rta = new TreeSum(5,"1");
        rta.printHierarchy();
        LinkedList<String> res = rta.sumLessPaths(3);
        for ( String s: res )
            System.out.println(s);
    }

    public static void main5(String[] args){
        TreeSum rta = new TreeSum(2,"1 2 3 4 ? 5 6 ? ? ? ? 7 8");
        rta.printHierarchy();
        LinkedList<String> res = rta.sumLessPaths(100);
        for ( String s: res )
            System.out.println(s);
    }

    public static void main(String[] args){
        // Los 3 ejemplos del pdf ok
        // 3, 1, 4, 1
        // 3, 2
        // 3, 3, 3
        // 3, 3, 1
        System.out.println("Ejemplo 1");
        main1(args);

        // 3, 3, 1, 0
        System.out.println("Ejemplo 2");
        main2(args);

        // 2, 1, 4
        // 2, 2, 3
        // 2, 2, 1
        // 2, 3,1
        System.out.println("Ejemplo 3");
        main3(args);

        // ok
        // 1
        System.out.println("Ejemplo 4");
        main4(args);

        // ok
        // 1, 2, 4
        // 1, 3, 5, 7
        // 1, 3, 5, 8
        // 1, 3, 6
        System.out.println("Ejemplo 5");
        main5(args);
    }


}
