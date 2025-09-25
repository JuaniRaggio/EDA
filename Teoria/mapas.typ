= Arbol Binario (Binary Tree o BT)

Estructura de datos formada por nodos, donde cada nodo o esta vacio o tiene 3 componentes:

+ Datos
+ Subarbol izquierdo
+ Subarbol derecho

_Nodo distinguido_: *raiz*

\

== Aplicaciones

=== Compiladores

Las expresiones formadas por operadores *unarios/binarios* pueden representarse con BT, donde las expresiones mas anidadas se deberan evaluar primero

\

=== Representaciones jerarquicas
Cualquier cosa que tenga una representacion jerarquica:

- Organizacion con "jefes"

\

=== Ordenes

Podria usarse como soporte para indices

= Arbol binario de expresiones

- Se utiliza para representar expresiones algebraicas
- Nodos internos $->$ operadores *binarios / unarios*
- Hojas representan $->$ *constantes / variables*

== Caracteristicas

- Permite representar expresiones en *notacion infija*
- Asi como usabamos una *pila y una tabla de precedencia de operadores*


== Formalmente

Una expresion aritmetica E esta dada por las siguientes reglas de derivacion (_las reglas las inventa uno_):

$ E -> (E + E) $
$ E -> (E - E) $
$ E -> (E * E) $
$ E -> (E / E) $
$ E -> (E ^ E) $
$ E -> "cte" $

=== Casos de uso A

```
new ExpTree("(2 + 3) \n");
```

==== Aplicamos:

_Siempre recursivamente de izquierda a derecha_

+ $E -> (E "op" E)$
+ Y cada $E -> "cte"$

\

=== Casos de uso B

```
new ExpTree("(2 + 3) )\n");
```

==== Aplicamos:

_Siempre recursivamente de izquierda a derecha_

+ $E -> (E "op" E)$
+ Y cada $E -> "cte"$

#align(center)[*Pero cuando llegamos al parentesis final, lo rechazamos*]

\

=== Casos de uso C

```
new ExpTree("( (2 + 3) )\n");
```

==== Aplicamos:

_Siempre recursivamente de izquierda a derecha_

+ $E -> (E "op" E)$
+ Y cada $E -> "cte"$

#align(center)[*Pero como se esperaba un operador antes del parentesis final, tiramos excepcion*]

\


=== Casos de uso D

```
new ExpTree("((2 + 3.5)*(-5/-1))\n");
```

==== Aplicamos:

_Siempre recursivamente de izquierda a derecha_

+ $E -> (E "op" E)$
+ Y cada $E -> "cte"$

#align(center)[*TODO OK*]

\

= Ejercicio





