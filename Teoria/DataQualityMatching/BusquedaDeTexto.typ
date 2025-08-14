#align(center)[= Levenshtein]

- Calcula la *minima cantidad de operaciones* necesarias para transformar un string a otro

- Las operaciones validas van a ser: _insertar_, _borrar_ o _sustituir un caracter_

*Notemos que* si no tuviesemos sustitucion, pasarian a ser 2 operaciones en vez de una

- Strings iguales $->$ distancia 0

#underline[#text[Ejemplo]]

```java
Levenshtein('big data', 'bigdata'); // = 1
```

La minima cantidad de operaciones es 1 pero hay infinitas formas de pasar de un string a otro

#align(center)[== Programacion dinamica]
Es una tecnica que consiste en reusar *valores previamente calculados* para no tener que recalcularlos repetidamente.

De esta forma los valores calculados deben *almacenarse en una estructura de datos*

Lo que estamos haciendo es *sacrificar espacio a expensas de tiempo*

#align(center)[=== Uso de programacion dinamica en recursividad]

La idea es guardarse los valores ya calculados en vez de volver a computar funciones que ya calculamos

#underline[Ejemplo - Fibonacci Dinamico]

```c

#include <stdio.h>

#define MAX 100
#define UNDEFINED 0

static long long memo[MAX];

long long fibonacci(int n) {
    if (n <= 1) return n;

    if (memo[n] != UNDEFINED)
        return memo[n];

    // Guardamos el resultado en memo antes de devolverlo
    memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    return memo[n];
}

```

== Levenshtein Distance

#table(columns: 10)[][Distance][B][I][G][][D][A][T][A][Distancia][0][1][2][3][4][5][6][7][8][B][1][min{1 + 1, 0 + 0} = 0][min{1 + 2, 0 + 1} = 1][][][][][][][I][2][1][0][1][2][3][4][5][6][G][3][2][1][0][1][][][][][D][4][][][][][][][][][A][5][][][][][][][][][T][6][][][][][][][][][A][7][min{5 + 1, 7 + 1} = 6][5][4][4][4][3][min{1 + 1, 3 + 1} = 2][1]

En este caso: _el minimo local me lleva al minimo global_, notemos que *abajo a la derecha tenemos el minimo global* y es la distancia

#underline[Ejercicio en clase:]
Cual es la distancia?

```java
Levenshtein("exkusa", "ex-amigo")
```

Operaciones: 

$"exkusa" -> "ex-amigo"$

1) $k -> -$

2) $u -> a$

3) $s -> m$

4) $a -> i$

5) $"add" -> g$

6) $"add" -> o$

#align(center)[== Task]

1. Implementar la distancia de Levenshtein con programacion dinamica

2. Calcular complejidad *temporal* y *espacial* del algoritmo propuesto

3. Hacer la implementacion ocupando el menor espacio posible

*Recordar*: _La idea es siempre calcular en base al caso anterior_

