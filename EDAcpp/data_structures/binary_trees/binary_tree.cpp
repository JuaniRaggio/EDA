#include "binary_tree.hpp"

// Node class implementation
BinaryTree::Node* BinaryTree::Node::setLeftTree(std::unique_ptr<Node> aNode) {
    left = std::move(aNode);
    return left.get();
}

BinaryTree::Node* BinaryTree::Node::setRightTree(std::unique_ptr<Node> aNode) {
    right = std::move(aNode);
    return right.get();
}

bool BinaryTree::Node::isLeaf() const {
    return left == nullptr && right == nullptr;
}

// NodeHelper class implementation
BinaryTree::NodeHelper::NodeHelper(Node* node, std::function<void(Node*)> action)
    : aNode(node), action(action) {}

BinaryTree::Node* BinaryTree::NodeHelper::getNode() const {
    return aNode;
}

std::function<void(Node*)> BinaryTree::NodeHelper::getAction() const {
    return action;
}

// BinaryTree class implementation
BinaryTree::BinaryTree(const std::string& fileName) {
    std::ifstream inputStream(fileName);
    if (!inputStream.is_open()) {
        throw std::runtime_error("File not found: " + fileName);
    }

    buildTree(inputStream);
    inputStream.close();
}

void BinaryTree::buildTree(std::ifstream& inputStream) {
    std::queue<NodeHelper> pendingOps;
    std::string token;

    root = std::make_unique<Node>();
    pendingOps.emplace(root.get(), [](Node*) {});

    while (inputStream >> token) {
        if (pendingOps.empty()) {
            break;
        }

        NodeHelper aPendingOp = pendingOps.front();
        pendingOps.pop();

        Node* currentNode = aPendingOp.getNode();

        if (token == "?") {
            // No need to set null, already null by default
            // Reserve space in queue even though NULL has no children for pairing
            pendingOps.emplace(nullptr, [](Node*) {}); // as if there was left
            pendingOps.emplace(nullptr, [](Node*) {}); // as if there was right
        } else {
            aPendingOp.getAction()(currentNode);

            // Set up node info for left, right or root
            currentNode->data = token;

            // Children are postponed
            pendingOps.emplace(currentNode, [](Node* n) {
                if (n) {
                    n->setLeftTree(std::make_unique<Node>());
                }
            });
            pendingOps.emplace(currentNode, [](Node* n) {
                if (n) {
                    n->setRightTree(std::make_unique<Node>());
                }
            });
        }
    }

    if (root && root->data.empty()) {
        // Never entered the loop
        root = nullptr;
    }
}

void BinaryTree::preorder() {
    preorderRecursive(root.get());
    std::cout << std::endl;
}

void BinaryTree::preorderRecursive(Node* node) const {
    if (node == nullptr) {
        return;
    }

    std::cout << node->data << " ";
    preorderRecursive(node->left.get());
    preorderRecursive(node->right.get());
}

void BinaryTree::postorder() {
    postorderRecursive(root.get());
    std::cout << std::endl;
}

void BinaryTree::postorderRecursive(Node* node) const {
    if (node == nullptr) {
        return;
    }

    postorderRecursive(node->left.get());
    postorderRecursive(node->right.get());
    std::cout << node->data << " ";
}

void BinaryTree::toFile(const std::string& fileName) const {
    std::ofstream writer(fileName);
    if (!writer.is_open()) {
        throw std::runtime_error("Could not create file: " + fileName);
    }

    // TODO: Implement file output logic
    // This would typically write the tree in some format

    writer.close();
    std::cout << "File created successfully!" << std::endl;
}

bool BinaryTree::equals(const BinaryTree& other) const {
    return equalsRecursive(root.get(), other.root.get());
}

bool BinaryTree::equalsRecursive(Node* node1, Node* node2) const {
    if (node1 == nullptr && node2 == nullptr) {
        return true;
    }

    if (node1 == nullptr || node2 == nullptr) {
        return false;
    }

    return node1->data == node2->data &&
           equalsRecursive(node1->left.get(), node2->left.get()) &&
           equalsRecursive(node1->right.get(), node2->right.get());
}

bool BinaryTree::operator==(const BinaryTree& other) const {
    return equals(other);
}

int BinaryTree::getHeight() const {
    return getHeightRecursive(root.get());
}

int BinaryTree::getHeightRecursive(Node* node) const {
    if (node == nullptr) {
        return 0;
    }

    int leftHeight = getHeightRecursive(node->left.get());
    int rightHeight = getHeightRecursive(node->right.get());

    return 1 + std::max(leftHeight, rightHeight);
}

int main() {
    try {
        std::unique_ptr<BinaryTreeService> binaryTree =
            std::make_unique<BinaryTree>("data0_1");

        binaryTree->preorder();
        binaryTree->postorder();
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }

    return 0;
}
