# Guia de Estudio EDA - Estructura de Datos y Algoritmos

---

## Contenidos

1. [Analisis de Algoritmos](#1-analisis-de-algoritmos)
2. [Algoritmos de Texto](#2-algoritmos-de-texto)
3. [Motores de Busqueda y Lucene](#3-motores-de-busqueda-y-lucene)
4. [Busqueda en Estructuras Ordenadas](#4-busqueda-en-estructuras-ordenadas)
5. [Algoritmos de Ordenamiento](#5-algoritmos-de-ordenamiento)
6. [Estructuras de Datos Lineales](#6-estructuras-de-datos-lineales)
7. [Procesamiento de Expresiones](#7-procesamiento-de-expresiones)
8. [Tipos Genericos en Java](#8-tipos-genericos-en-java)
9. [Lista Completa de Algoritmos](#9-lista-completa-de-algoritmos)
10. [Tabla de Complejidades](#10-tabla-de-complejidades)

---

## 1. Analisis de Algoritmos

### Conceptos Fundamentales
- **Complejidad Temporal**: Metrica para medir el tiempo de ejecucion
- **Complejidad Espacial**: Metrica para medir el uso de memoria
- **Analisis Empirico vs Teorico**: Medicion practica vs analisis matematico

### Herramientas de Analisis
- **Teorema Maestro**: Para recurrencias de la forma T(n) = aT(n/b) + f(n)
- **Expansion Recursiva**: Tecnica alternativa para calcular complejidades
- **Notacion Big O**: Clasificacion de algoritmos por orden de crecimiento

### Casos de Uso
- Comparar eficiencia entre algoritmos
- Predecir escalabilidad
- Tomar decisiones de diseno arquitectonico

---

## 2. Algoritmos de Texto

### Algoritmos de Busqueda Exacta

#### **KMP (Knuth-Morris-Pratt)**
- **Proposito**: Busqueda eficiente de patrones en texto
- **Complejidad**: O(n + m) donde n = longitud texto, m = longitud patron
- **Ventaja**: Evita retrocesos innecesarios usando tabla de prefijos
- **Uso**: Busqueda de cadenas, deteccion de plagios

### Algoritmos de Busqueda Aproximada

#### **Soundex**
- **Proposito**: Codificacion fonetica para palabras que suenan similar
- **Algoritmo**:
  1. Mantener primera letra
  2. Convertir consonantes a codigos numericos (1-6)
  3. Eliminar vocales y letras similares foneticamente
  4. Completar con ceros hasta 4 caracteres
- **Complejidad**: O(n) donde n = longitud de la palabra
- **Similitud**: Proporcion de caracteres coincidentes entre codigos
- **Valores posibles**: 0, 0.25, 0.5, 0.75, 1.0
- **Uso**: Correccion ortografica, busqueda tolerante a errores

#### **Q-Grams (N-Grams)**
- **Proposito**: Medir similitud entre strings basado en fragmentos comunes
- **Algoritmo**:
  1. Generar todos los substrings de longitud Q
  2. Agregar simbolos especiales al inicio y final
  3. Contar fragmentos en comun
  4. Calcular similitud: (|A| + |B| - |A ∪ B|) / (|A| + |B|)
- **Complejidad**: O(n) para generar Q-grams, O(m + n) para comparar
- **Casos de Uso**:
  - Mejor que Levenshtein para frases con palabras reordenadas
  - Deteccion de textos similares
  - Analisis de documentos

#### **Levenshtein Distance**
- **Proposito**: Medir distancia de edicion entre strings
- **Operaciones**: Insercion, eliminacion, sustitucion
- **Complejidad**: O(n × m) programacion dinamica
- **Uso**: Correccion automatica, spell checking

---

## 3. Motores de Busqueda y Lucene

### Conceptos de Indexacion

#### **Archivo Invertido (Inverted Index)**
- **Estructura**: Mapeo de termino → lista de documentos
- **Ventaja**: Busqueda rapida O(1) por termino
- **Elementos**:
  - Termino (token)
  - Frecuencia en documentos
  - Posiciones dentro de documentos
  - Offsets (opcional)

### Lucene - Biblioteca de Busqueda

#### **Componentes Principales**
- **Documento**: Secuencia de campos (fields)
- **Campo**: Par nombre-valor con configuracion de indexacion
- **Termino**: Secuencia de bytes asociada a un campo

#### **Configuracion de Campos**
- **setStored(true/false)**: Almacenar fuera del indice invertido
- **IndexOptions**:
  - NONE: No indexar
  - DOCS: Solo IDs de documentos
  - DOCS_AND_FREQS: IDs + frecuencias
  - DOCS_AND_FREQS_AND_POSITIONS: + posiciones
  - DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS: + offsets

#### **Tipos de Queries**
1. **TermQuery**: Busqueda de termino exacto
2. **PrefixQuery**: Busqueda por prefijo
3. **TermRangeQuery**: Busqueda por rangos
4. **PhraseQuery**: Busqueda de secuencias
5. **WildcardQuery**: Busqueda con * y ?
6. **FuzzyQuery**: Busqueda aproximada (Levenshtein ≤ 2)
7. **BooleanQuery**: Combinacion con AND, OR, NOT

#### **Analizadores (Analyzers)**
- **SimpleAnalyzer**: Separacion basica por espacios
- **StandardAnalyzer**: Separacion + minusculas + puntuacion
- **WhitespaceAnalyzer**: Solo por espacios
- **StopAnalyzer**: Elimina palabras comunes
- **SpanishAnalyzer**: Stemming para espanol
- **CustomAnalyzer**: Configuracion personalizada

---

## 4. Busqueda en Estructuras Ordenadas

### Busqueda Binaria
- **Algoritmo**: Divide y venceras en arreglo ordenado
- **Complejidad Temporal**: O(log n)
- **Complejidad Espacial**:
  - Iterativa: O(1)
  - Recursiva: O(log n)
- **Casos de Uso**: Índices, diccionarios, bases de datos

### Índices y Estructuras de Datos

#### **Arreglos Ordenados**
- **Busqueda**: O(log n) - busqueda binaria
- **Insercion**: O(n) - desplazamiento de elementos
- **Eliminacion**: O(n) - desplazamiento de elementos
- **Ventajas**: Acceso directo, busqueda eficiente
- **Desventajas**: Modificaciones costosas, memoria contigua

#### **Listas Enlazadas Ordenadas**
- **Busqueda**: O(n) - traversal lineal
- **Insercion**: O(n) para encontrar posicion + O(1) para insertar
- **Eliminacion**: O(n) para encontrar + O(1) para eliminar
- **Ventajas**: Insercion/eliminacion eficiente una vez localizado
- **Desventajas**: No permite busqueda binaria

---

## 5. Algoritmos de Ordenamiento

### Quicksort
- **Tipo**: Divide y venceras, in-place
- **Algoritmo**:
  1. Elegir pivote
  2. Particionar: elementos ≤ pivote a la izquierda, > pivote a la derecha
  3. Aplicar recursivamente a sub-arreglos
- **Complejidad Temporal**:
  - Mejor caso: O(n log n) - pivote divide en mitades iguales
  - Caso promedio: O(n log n)
  - Peor caso: O(n²) - arreglo ya ordenado con mal pivote
- **Complejidad Espacial**:
  - Mejor caso: O(log n) - stack de recursion
  - Peor caso: O(n) - maxima profundidad de recursion
- **Mejoras**: Pivote aleatorio, mediana de tres, hibrido con insertion sort
- **Casos de Uso**: Ordenamiento general, cuando memoria es limitada

### Mergesort
- **Tipo**: Divide y venceras, no in-place
- **Complejidad**: O(n log n) garantizado
- **Ventaja**: Estable, predecible
- **Desventaja**: Requiere O(n) memoria adicional

---

## 6. Estructuras de Datos Lineales

### Stack (Pila - LIFO)

#### **Operaciones Principales**
- **push(item)**: Agregar elemento al tope - O(1)
- **pop()**: Remover elemento del tope - O(1)
- **peek()/top()**: Ver elemento del tope sin remover - O(1)
- **isEmpty()**: Verificar si esta vacia - O(1)

#### **Implementaciones**
- **Array-based**: Crecimiento en chunks, sin movimiento de datos
- **Linked list**: Sin problemas de navegacion, acceso solo por el tope

#### **Casos de Uso**
- **Undo operations**: Editores de texto, IDEs
- **Runtime execution**: Llamadas a metodos, manejo de recursion
- **Syntax checking**: Verificacion de parentesis balanceados
- **Expression evaluation**: Evaluacion de expresiones postfijas
- **Algorithm conversion**: Recursivo a iterativo

### Queue (Cola - FIFO)

#### **Operaciones Principales**
- **enqueue(item)**: Agregar al final - O(1)
- **dequeue()**: Remover del frente - O(1)
- **peek()**: Ver elemento del frente - O(1)
- **isEmpty()**: Verificar si esta vacia - O(1)
- **size()**: Obtener numero de elementos - O(1)

#### **Implementaciones**
- **Unbounded**: Lista enlazada superior (sin limite de tamano)
- **Bounded**: Arreglo circular funciona bien

#### **Casos de Uso**
- **Shared resources**: Colas de impresion
- **Resource management**: Manejo de multiples recursos
- **Graph algorithms**: BFS (Breadth-First Search)
- **Inter-process communication**: Pipes, buffers

### Listas Enlazadas

#### **Lista Enlazada Simple Ordenada**
- **Estructura**: Nodos con dato + referencia al siguiente
- **Orden**: Mantiene elementos ordenados
- **Complejidad**:
  - Busqueda: O(n)
  - Insercion: O(n) - encontrar posicion
  - Eliminacion: O(n) - encontrar elemento
- **Ventaja**: No requiere memoria contigua

#### **Lista Enlazada con Header**
- **Mejora**: Nodo header con informacion global
- **Informacion**: Tamano, referencias a min/max
- **Operaciones mejoradas**:
  - getMin(): O(1)
  - getMax(): O(1)
  - size(): O(1)

#### **Lista Doblemente Enlazada**
- **Estructura**: Referencias a anterior y siguiente
- **Ventajas**:
  - Traversal bidireccional
  - Implementacion de iterador con remove
  - Iteracion ascendente/descendente eficiente
- **Java**: LinkedList.java usa estructura doblemente enlazada

---

## 7. Procesamiento de Expresiones

### Evaluacion de Expresiones Postfijas (RPN)

#### **Algoritmo**
1. Usar stack para operandos
2. Para cada token:
   - Si es operando: push al stack
   - Si es operador: pop dos operandos, aplicar operacion, push resultado
3. Resultado final: ultimo elemento en stack

#### **Ventajas**
- Sin parentesis necesarios
- Sin ambiguedad en orden de evaluacion
- Evaluacion en tiempo lineal O(n)

### Conversion Infijo a Postfijo

#### **Operator Precedence Parser**
- **Proposito**: Eliminar ambiguedad en expresiones infijas
- **Precedencia**: ^ > *, / > +, - (mayor a menor)
- **Asociatividad**:
  - +, -, *, /: Izquierda a derecha
  - ^: Derecha a izquierda
- **Algoritmo**: Stack + tabla de precedencias
- **Manejo de parentesis**: Operadores especiales en tabla

---

## 8. Tipos Genericos en Java

### Implementacion de Generics

#### **Type Erasure**
- **Tecnica**: Java implementa genericos por borrado de tipos
- **Problema**: No se pueden crear arreglos genericos directamente
- **Soluciones**:
  1. Usar Object[] y hacer cast
  2. Usar reflexion con Class<T>
  3. Suprimir warnings con @SuppressWarnings("unchecked")

#### **Bounded Generics**
- **Restriccion**: Limitar tipos con extends
- **Ejemplo**: `T extends Comparable<T>`
- **Beneficio**: Type safety en tiempo de compilacion

---

## 9. Lista Completa de Algoritmos

### Algoritmos de Busqueda
1. **Busqueda Lineal**: O(n)
2. **Busqueda Binaria**: O(log n)
3. **KMP (String Matching)**: O(n + m)

### Algoritmos de Busqueda Aproximada
4. **Soundex**: O(n) - codificacion fonetica
5. **Q-Grams**: O(n) - similitud por fragmentos
6. **Levenshtein Distance**: O(n × m) - distancia de edicion
7. **Fuzzy Search (Lucene)**: Levenshtein con maximo 2 ediciones

### Algoritmos de Ordenamiento
8. **Quicksort**: O(n log n) promedio, O(n²) peor caso
9. **Mergesort**: O(n log n) garantizado
10. **Insertion Sort**: O(n²) - para arrays pequenos

### Algoritmos de Analisis
11. **Teorema Maestro**: Analisis de recurrencias
12. **Expansion Recursiva**: Calculo de complejidad paso a paso

### Algoritmos de Procesamiento de Expresiones
13. **Postfix Evaluation**: O(n) - evaluacion con stack
14. **Infix to Postfix**: O(n) - conversion con precedencia
15. **Operator Precedence Parser**: Manejo de precedencia y asociatividad

---

## 10. Tabla de Complejidades

### Estructuras de Datos - Complejidades Temporales

| Estructura | Busqueda | Insercion | Eliminacion | Acceso | Espacio |
|------------|----------|-----------|-------------|--------|---------|
| **Array (no ordenado)** | O(n) | O(1) al final | O(n) | O(1) | O(n) |
| **Array Ordenado** | O(log n) | O(n) | O(n) | O(1) | O(n) |
| **Lista Enlazada Simple** | O(n) | O(n) | O(n) | O(n) | O(n) |
| **Lista Doblemente Enlazada** | O(n) | O(n) | O(n) | O(n) | O(n) |
| **Stack** | - | O(1) | O(1) | O(1) tope | O(n) |
| **Queue** | - | O(1) | O(1) | O(1) frente | O(n) |
| **Hash Table** | O(1) prom | O(1) prom | O(1) prom | O(1) prom | O(n) |

### Algoritmos - Complejidades

| Algoritmo | Tiempo Mejor | Tiempo Promedio | Tiempo Peor | Espacio |
|-----------|--------------|-----------------|-------------|---------|
| **Busqueda Binaria** | O(1) | O(log n) | O(log n) | O(1) iter, O(log n) rec |
| **Quicksort** | O(n log n) | O(n log n) | O(n²) | O(log n) - O(n) |
| **Mergesort** | O(n log n) | O(n log n) | O(n log n) | O(n) |
| **KMP** | O(n + m) | O(n + m) | O(n + m) | O(m) |
| **Soundex** | O(n) | O(n) | O(n) | O(1) |
| **Q-Grams** | O(n) | O(n) | O(n) | O(n) |
| **Levenshtein** | O(n × m) | O(n × m) | O(n × m) | O(n × m) |

### Casos de Uso Especificos por Algoritmo

#### Algoritmos de Busqueda
- **Busqueda Binaria**: Diccionarios, bases de datos indexadas, bibliotecas ordenadas
- **KMP**: Editores de texto, detectores de plagio, analisis de ADN
- **Busqueda Lineal**: Listas no ordenadas, busqueda con condiciones complejas

#### Algoritmos de Busqueda Aproximada
- **Soundex**: Bases de datos de nombres, busqueda fonetica, sistemas de genealogia
- **Q-Grams**: Deteccion de documentos duplicados, analisis de similitud de texto
- **Levenshtein**: Correctores ortograficos, sugerencias de busqueda, fuzzy matching

#### Algoritmos de Ordenamiento
- **Quicksort**: Ordenamiento general, cuando memoria es limitada, sistemas embebidos
- **Mergesort**: Cuando se requiere estabilidad, ordenamiento de listas enlazadas, external sorting

#### Estructuras de Datos
- **Stack**: Parsing, undo/redo, navegacion de paginas web, evaluacion de expresiones
- **Queue**: Sistemas de colas, BFS, simulaciones, schedulers de procesos
- **Arrays**: Acceso aleatorio rapido, implementacion de otras estructuras
- **Listas Enlazadas**: Insercion/eliminacion frecuente, tamano variable, implementacion de stacks/queues

#### Motores de Busqueda
- **Lucene**: Busqueda de texto completo, sistemas de documentacion, e-commerce search
- **Índices Invertidos**: Bases de datos de texto, sistemas de recuperacion de informacion

---

## Recomendaciones de Estudio

1. **Practicar implementaciones**: Implementar cada algoritmo desde cero
2. **Analizar complejidades**: Calcular Big O para cada implementacion
3. **Casos de uso**: Entender cuando usar cada algoritmo/estructura
4. **Trade-offs**: Memoria vs tiempo, simplicidad vs eficiencia
5. **Testing**: Probar con casos edge, datasets grandes y pequenos
6. **Optimizaciones**: Conocer variantes y mejoras de algoritmos basicos

---

*Esta guia cubre todo el material de las presentaciones EDA 2025-Q2. Para cada algoritmo, asegurate de poder implementarlo, calcular su complejidad y explicar sus casos de uso.*
