#include <iostream>
#include <memory>
#include <sstream>
#include <stdexcept>
#include <string>

struct ExpressionService {
  virtual ~ExpressionService() = default;
};

class ExpTree : public ExpressionService {
private:
  class Node {
  public:
    std::string data;
    std::unique_ptr<Node> left, right;

    explicit Node(std::istringstream &theLineStream)
        : lineStream(&theLineStream) {
      // Construye el árbol desde el stream
      std::unique_ptr<Node> auxi = buildExpression();
      if (!auxi) {
        throw std::runtime_error("COMPLETAR buildExpression()");
      }

      // Copiamos el resultado del nodo auxiliar a este nodo "raíz"
      data = std::move(auxi->data);
      left = std::move(auxi->left);
      right = std::move(auxi->right);

      // Si quedan tokens, la expresión es inválida
      std::string extra;
      if ((*lineStream) >> extra) {
        throw std::runtime_error("Bad expression");
      }
    }

    Node() = default;

  private:
    std::istringstream *lineStream{nullptr};

    bool valid_operand(const std::string &op) const {
      return op == "*" || op == "+" || op == "-" || op == "/";
    }

    std::unique_ptr<Node> buildExpression() {
      std::string token;

      if (!(*lineStream >> token) || token == ")") {
        throw std::runtime_error("Unexpected end of expression");
      }
      std::unique_ptr<Node> node;

      if (token == "(") {
        std::unique_ptr<Node> left = buildExpression();

        node = std::make_unique<Node>();

        std::string op;
        if (!(*lineStream >> op) || !valid_operand(op)) {
          throw std::runtime_error(
              "Unexpected end of expression or invalid operand");
        }

        std::unique_ptr<Node> right = buildExpression();

        std::string close;
        if (!(*lineStream >> close) || close != ")") {
          throw std::runtime_error("Expected )");
        }

        node->left = std::move(left);
        node->data = op;
        node->right = std::move(right);
        return node;
      } else {
        node = std::make_unique<Node>();
        node->data = token;
        return node;
      }

      return nullptr;
    }
  };

  std::unique_ptr<Node> root;

public:
  ExpTree() {
    std::cout << "Introduzca la expresión en notación infija con todos los "
                 "paréntesis y blancos: ";

    std::string line;
    std::getline(std::cin, line);

    buildTree(line);
  }

  double eval();
  void preorder();
  void inorder();
  void postorder();

private:
  void buildTree(const std::string &line) {
    std::istringstream lineStream(line);
    root = std::make_unique<Node>(lineStream);
  }
};
