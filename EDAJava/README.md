# Algoritmos y Estructuras de Datos - Java Implementation

Este proyecto contiene implementaciones completas en Java de todos los algoritmos fundamentales estudiados en el curso de Estructuras de Datos y Algoritmos (EDA).

## Tabla de Contenidos

- [Algoritmos Implementados](#algoritmos-implementados)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Análisis de Complejidad](#análisis-de-complejidad)
- [Tests](#tests)
- [Ejemplos de Uso](#ejemplos-de-uso)

## Algoritmos Implementados

### 1. Algoritmos de Búsqueda
- **Binary Search** (`BinarySearch.java`)
  - Implementación iterativa y recursiva
  - Búsqueda de primera y última ocurrencia
  - Versión genérica para tipos `Comparable`
  - Complejidad: O(log n)

- **Knuth-Morris-Pratt (KMP)** (`KMP.java`)
  - Búsqueda de patrones en texto
  - Construcción de tabla Next/Failure
  - Búsqueda de todas las ocurrencias
  - Complejidad: O(n + m)

### 2. Algoritmos de Ordenamiento
- **QuickSort** (`QuickSort.java`)
  - Múltiples estrategias de selección de pivote:
    - Primer elemento
    - Elemento aleatorio
    - Mediana de tres
    - Particionado de Hoare
  - Versión genérica
  - Complejidad: O(n log n) promedio, O(n²) peor caso

- **MergeSort** (`MergeSort.java`)
  - Implementación recursiva y bottom-up
  - Versión genérica
  - Conteo de inversiones
  - Fusión de arreglos ordenados
  - Complejidad: O(n log n) garantizado

- **Insertion Sort** (`InsertionSort.java`)
  - Implementación básica y optimizada con búsqueda binaria
  - Shell Sort como extensión
  - Ordenamiento por rangos
  - Complejidad: O(n²)

### 3. Algoritmos de Texto y Matching
- **Soundex** (`Soundex.java`)
  - Codificación fonética de palabras
  - Algoritmo de 4 caracteres (letra + 3 dígitos)
  - Cálculo de similitud
  - Complejidad: O(n)

- **Q-Grams/N-Grams** (`QGrams.java`)
  - Generación de n-gramas
  - Múltiples métricas de similitud:
    - Jaccard
    - Dice
    - Coseno
    - Coeficiente de superposición
  - Búsqueda de strings similares
  - Complejidad: O(n)

- **Levenshtein Distance** (`LevenshteinDistance.java`)
  - Distancia de edición con programación dinámica
  - Versión optimizada en espacio
  - Distancia normalizada y similitud
  - Distancia restringida con umbral
  - Complejidad: O(n × m)

### 4. Estructuras de Datos Lineales
- **Stack** (Pila)
  - `ArrayStack.java`: Implementación con arreglo dinámico
  - `LinkedStack.java`: Implementación con lista enlazada
  - Operaciones: push, pop, peek, isEmpty, size
  - Crecimiento automático del arreglo

- **Queue** (Cola)
  - `BoundedQueue.java`: Cola circular con capacidad fija
  - `UnboundedQueue.java`: Cola con lista enlazada
  - Operaciones: enqueue, dequeue, peek, isEmpty, size
  - Manejo de overflow en cola acotada

### 5. Procesamiento de Expresiones
- **Postfix Evaluator** (`PostfixEvaluator.java`)
  - Evaluación de expresiones en notación postfija
  - Soporte para operadores: +, -, *, /, %, ^
  - Versiones para enteros y decimales
  - Validación de expresiones
  - Complejidad: O(n)

- **Infix to Postfix** (`InfixToPostfix.java`)
  - Conversión de notación infija a postfija
  - Manejo de precedencia y asociatividad
  - Soporte para paréntesis
  - Validación de expresiones balanceadas
  - Complejidad: O(n)

### 6. Tablas Hash
- **Open Addressing** (`OpenAddressingHashTable.java`)
  - Resolución de colisiones por sondeo lineal
  - Borrado lógico de elementos
  - Redimensionamiento automático
  - Capacidades con números primos

- **Chaining** (`ChainingHashTable.java`)
  - Resolución de colisiones por encadenamiento
  - Listas enlazadas en cada bucket
  - Estadísticas de distribución
  - Factor de carga configurable

### 7. Utilidades de Rendimiento
- **MyTimer** (`MyTimer.java`)
  - Medición precisa de tiempo de ejecución
  - Múltiples unidades (nanosegundos, microsegundos, milisegundos, segundos)
  - Timer por intervalos
  - Profiler de rendimiento
  - Herramientas de benchmarking

### Ejecutar Tests
```bash
mvn test
```

## Análisis de Complejidad

| Algoritmo | Tiempo Promedio | Tiempo Peor Caso | Espacio |
|-----------|----------------|------------------|---------|
| Binary Search | O(log n) | O(log n) | O(1) / O(log n) |
| KMP | O(n + m) | O(n + m) | O(m) |
| QuickSort | O(n log n) | O(n²) | O(log n) |
| MergeSort | O(n log n) | O(n log n) | O(n) |
| Insertion Sort | O(n²) | O(n²) | O(1) |
| Levenshtein | O(n × m) | O(n × m) | O(min(n,m)) |
| Hash Table (avg) | O(1) | O(n) | O(n) |
| Stack/Queue Ops | O(1) | O(1) | O(1) |

## Tests

El proyecto incluye tests unitarios completos para todos los algoritmos:

- `BinarySearchTest.java`: 9 tests
- `QuickSortTest.java`: 10 tests
- `KMPTest.java`: 7 tests
- `LevenshteinDistanceTest.java`: 10 tests

Para ejecutar todos los tests:
```bash
mvn test
```

## Ejemplos de Uso

### Búsqueda Binaria
```java
int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};
int index = BinarySearch.binarySearchIterative(sortedArray, 7);
// Resultado: 3
```

### Algoritmo KMP
```java
String text = "ABRACADABRA";
String pattern = "ABRA";
int position = KMP.search(text, pattern);
int[] allOccurrences = KMP.findAllOccurrences(text, pattern);
// position: 0, allOccurrences: [0, 7]
```

### Ordenamiento
```java
int[] array = {64, 34, 25, 12, 22, 11, 90};
QuickSort.quickSortFirstPivot(array);
// Resultado: [11, 12, 22, 25, 34, 64, 90]
```

### Distancia de Levenshtein
```java
int distance = LevenshteinDistance.distance("kitten", "sitting");
double similarity = LevenshteinDistance.similarity("kitten", "sitting");
// distance: 3, similarity: 0.571
```

### Evaluación de Expresiones
```java
String infix = "3 + 4 * 2 - 1";
String postfix = InfixToPostfix.convert(infix);
double result = PostfixEvaluator.evaluate(postfix);
// postfix: "3 4 2 * + 1 -", result: 10.0
```

### Estructuras de Datos
```java
ArrayStack<Integer> stack = new ArrayStack<>();
stack.push(42);
Integer value = stack.pop(); // 42

UnboundedQueue<String> queue = new UnboundedQueue<>();
queue.enqueue("Hello");
String msg = queue.dequeue(); // "Hello"
```

### Medición de Rendimiento
```java
MyTimer timer = new MyTimer();
timer.start();
// ... código a medir ...
timer.stop();
System.out.println("Tiempo: " + timer.getElapsedTimeMillis() + " ms");
```

## Características Destacadas

- **Genéricos**: Soporte completo para tipos genéricos donde aplica
- **Robustez**: Validación exhaustiva de parámetros y manejo de casos edge
- **Eficiencia**: Implementaciones optimizadas con análisis de complejidad
- **Testing**: Cobertura completa de tests unitarios
- **Documentación**: Código bien documentado y ejemplos prácticos
- **Performance**: Herramientas integradas para medición de rendimiento

## Basado en Teoría EDA

Todas las implementaciones están basadas en la teoría vista en clase, incluyendo:

- Análisis de complejidad temporal y espacial
- Técnicas de programación dinámica
- Algoritmos de divide y vencerás
- Estructuras de datos fundamentales
- Algoritmos de string matching avanzados
- Técnicas de hashing y resolución de colisiones

