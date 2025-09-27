#include "bt_expressions.hpp"

double ExpTree::eval() {
    return 0.0;
}
void ExpTree::preorder() {}

void ExpTree::inorder() {}

void ExpTree::postorder() {}

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

