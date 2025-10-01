#pragma once

#include <iostream>
#include <fstream>
#include <memory>
#include <string>
#include <queue>
#include <functional>
#include <stdexcept>
#include <sstream>

class BinaryTreeService {
public:
    virtual ~BinaryTreeService() = default;
    virtual void preorder() = 0;
    virtual void postorder() = 0;
};

class BinaryTree : public BinaryTreeService {
private:
    class Node {
    public:
        std::string data;
        std::unique_ptr<Node> left;
        std::unique_ptr<Node> right;

        Node() = default;

        Node* setLeftTree(std::unique_ptr<Node> aNode);
        Node* setRightTree(std::unique_ptr<Node> aNode);
        bool isLeaf() const;
    };

    class NodeHelper {
    private:
        Node* aNode;
        std::function<void(Node*)> action;

    public:
        NodeHelper(Node* node, std::function<void(Node*)> action);
        Node* getNode() const;
        std::function<void(Node*)> getAction() const;
    };

    std::unique_ptr<Node> root;

    void buildTree(std::ifstream& inputStream);
    void preorderRecursive(Node* node) const;
    void postorderRecursive(Node* node) const;
    bool equalsRecursive(Node* node1, Node* node2) const;
    int getHeightRecursive(Node* node) const;

public:
    explicit BinaryTree(const std::string& fileName);

    void toFile(const std::string& fileName) const;
    bool equals(const BinaryTree& other) const;
    int getHeight() const;

    // BinaryTreeService interface implementation
    void preorder() override;
    void postorder() override;

    // Operator overloads
    bool operator==(const BinaryTree& other) const;
};
