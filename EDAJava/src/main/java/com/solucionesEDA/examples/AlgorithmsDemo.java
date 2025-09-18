package com.solucionesEDA.examples;

import com.solucionesEDA.algorithms.*;
import com.solucionesEDA.datastructures.*;
import com.solucionesEDA.utils.MyTimer;

public class AlgorithmsDemo {

    public static void main(String[] args) {
        System.out.println("=== DEMO DE ALGORITMOS EDA ===\n");

        demoSearchAlgorithms();
        demoSortingAlgorithms();
        demoStringAlgorithms();
        demoDataStructures();
        demoExpressionProcessing();
        demoHashTables();
        demoPerformanceMeasurement();
    }

    private static void demoSearchAlgorithms() {
        System.out.println("1. ALGORITMOS DE BÚSQUEDA");
        System.out.println("-".repeat(40));

        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println("Array ordenado: " + java.util.Arrays.toString(sortedArray));

        int target = 7;
        int result = BinarySearch.binarySearchIterative(sortedArray, target);
        System.out.println("Búsqueda binaria iterativa de " + target + ": índice " + result);

        result = BinarySearch.binarySearchRecursive(sortedArray, target);
        System.out.println("Búsqueda binaria recursiva de " + target + ": índice " + result);

        String text = "ABRACADABRA";
        String pattern = "ABRA";
        result = KMP.search(text, pattern);
        System.out.println("KMP búsqueda de '" + pattern + "' en '" + text + "': índice " + result);

        int[] allOccurrences = KMP.findAllOccurrences(text, pattern);
        System.out.println("Todas las ocurrencias: " + java.util.Arrays.toString(allOccurrences));
        System.out.println();
    }

    private static void demoSortingAlgorithms() {
        System.out.println("2. ALGORITMOS DE ORDENAMIENTO");
        System.out.println("-".repeat(40));

        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + java.util.Arrays.toString(array1));

        int[] quickSortArray = array1.clone();
        QuickSort.quickSortFirstPivot(quickSortArray);
        System.out.println("QuickSort (primer pivote): " + java.util.Arrays.toString(quickSortArray));

        int[] mergeSortArray = array1.clone();
        MergeSort.mergeSort(mergeSortArray);
        System.out.println("MergeSort: " + java.util.Arrays.toString(mergeSortArray));

        int[] insertionSortArray = array1.clone();
        InsertionSort.insertionSort(insertionSortArray);
        System.out.println("InsertionSort: " + java.util.Arrays.toString(insertionSortArray));
        System.out.println();
    }

    private static void demoStringAlgorithms() {
        System.out.println("3. ALGORITMOS DE TEXTO");
        System.out.println("-".repeat(40));

        String word1 = "Smith";
        String word2 = "Smyth";
        System.out.println("Soundex de '" + word1 + "': " + Soundex.encode(word1));
        System.out.println("Soundex de '" + word2 + "': " + Soundex.encode(word2));
        System.out.println("Son similares (Soundex): " + Soundex.areSimilar(word1, word2));

        String text1 = "kitten";
        String text2 = "sitting";
        int distance = LevenshteinDistance.distance(text1, text2);
        System.out.println("Distancia Levenshtein entre '" + text1 + "' y '" + text2 + "': " + distance);

        double similarity = QGrams.jaccardSimilarity(text1, text2, 2);
        System.out.printf("Similitud Jaccard (2-gramas): %.3f%n", similarity);
        System.out.println();
    }

    private static void demoDataStructures() {
        System.out.println("4. ESTRUCTURAS DE DATOS");
        System.out.println("-".repeat(40));

        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack después de push 1,2,3: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack después de pop: " + stack);

        UnboundedQueue<String> queue = new UnboundedQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue después de enqueue A,B,C: " + queue);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Queue después de dequeue: " + queue);
        System.out.println();
    }

    private static void demoExpressionProcessing() {
        System.out.println("5. PROCESAMIENTO DE EXPRESIONES");
        System.out.println("-".repeat(40));

        String infixExpression = "3 + 4 * 2 - 1";
        String postfixExpression = InfixToPostfix.convert(infixExpression);
        System.out.println("Expresión infija: " + infixExpression);
        System.out.println("Expresión postfija: " + postfixExpression);

        double result = PostfixEvaluator.evaluate(postfixExpression);
        System.out.println("Resultado de la evaluación: " + result);
        System.out.println();
    }

    private static void demoHashTables() {
        System.out.println("6. TABLAS HASH");
        System.out.println("-".repeat(40));

        ChainingHashTable<String, Integer> chainingTable = new ChainingHashTable<>();
        chainingTable.put("apple", 5);
        chainingTable.put("banana", 3);
        chainingTable.put("cherry", 8);
        System.out.println("Chaining Hash Table: " + chainingTable);
        System.out.println("Factor de carga: " + chainingTable.getLoadFactor());

        OpenAddressingHashTable<String, Integer> openTable = new OpenAddressingHashTable<>();
        openTable.put("red", 1);
        openTable.put("green", 2);
        openTable.put("blue", 3);
        System.out.println("Open Addressing Hash Table: " + openTable);
        System.out.println("Factor de carga: " + openTable.getLoadFactor());
        System.out.println();
    }

    private static void demoPerformanceMeasurement() {
        System.out.println("7. MEDICIÓN DE RENDIMIENTO");
        System.out.println("-".repeat(40));

        int[] testArray = generateRandomArray(10000);

        MyTimer timer = new MyTimer();
        timer.start();
        QuickSort.quickSortFirstPivot(testArray.clone());
        timer.stop();
        System.out.println("QuickSort (10,000 elementos): " + timer);

        timer.restart();
        MergeSort.mergeSort(testArray.clone());
        timer.stop();
        System.out.println("MergeSort (10,000 elementos): " + timer);

        long timeNanos = MyTimer.measureNanos(() -> {
            InsertionSort.insertionSort(testArray.clone());
        });
        System.out.println("InsertionSort (10,000 elementos): " + MyTimer.formatTime(timeNanos));
        System.out.println();

        System.out.println("¡Demo completado exitosamente!");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }
}