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





