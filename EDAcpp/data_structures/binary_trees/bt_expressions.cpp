#include "bt_expressions.hpp"
#include <atomic>
#include <string>

double ExpTree::eval() {
    return 0.0;
}
std::string ExpTree::preorder(ExpTree root) {
    std::string ordered_tree;
    return ordered_tree;
}

std::string ExpTree::inorder(ExpTree root) {
    if () {}
}

std::string ExpTree::postorder() {}

// hasta que armen los testeos
int main() {
    try {
        std::unique_ptr<ExpressionService> myExp = std::make_unique<ExpTree>();
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << '\n';
        return 1;
    }
    return 0;
}

