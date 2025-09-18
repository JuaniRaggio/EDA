# Estructura de Datos y Algoritmos

# ITBA     2025-Q2

# Algoritmo ampliado

Ahora bien\, ¿cómo incorporamos los paréntesis en las expresiones?

Los mismos no deben aparecer en la salida ya que no son necesarios en las expresiones postfijas \(ni en prefijas\)\.

# Extensión del algoritmo: ()

Una forma sencilla es considerarlos como operadores especiales\, es decir:

Si el operador current es un un “\(“\, el mismo debe postergarse hasta que aparezca “\)”\. Es decir\, completar la tabla para que se lo pushee siempre\.

Si el operador current es un “\)” el mismo debe sacar todos los operadores de la pila y concatenarlos en el string de salida hasta encontrar el “\(“ que aparea con él\. Cuando en el tope aparezca el “\(“ debe sacarlo del tope de la pila pero no concatenarlo \(ya que los paréntesis no van a la expresión postfija\)\. Completar la tabla para manejar esta situación y colocar que la precendencia entre “\(“ y “\)”  es false para manejarla como un caso especial => sino se vacía la pila\!

Ej:  \(  \(  4 – 3  \) \*  2 \)

Ejemplo: Supongamos que tenemos la expresión infija   __\( 3 __  __\+ __  __10 \) __  __^ 2 \- 5 \* __  __7__

![](img/12-A%28parte3%29_0.png)

![](img/12-A%28parte3%29_1.png)

![](img/12-A%28parte3%29_2.png)

![](img/12-A%28parte3%29_3.png)

![](img/12-A%28parte3%29_4.png)

![](img/12-A%28parte3%29_5.png)

![](img/12-A%28parte3%29_6.png)

![](img/12-A%28parte3%29_7.png)

![](img/12-A%28parte3%29_8.png)

![](img/12-A%28parte3%29_9.png)

![](img/12-A%28parte3%29_10.png)

![](img/12-A%28parte3%29_11.png)

Ejercicio en papel\, mostrar el pasaje a postfija y la pila instante a instante en cada una de las siguientes expresiones infijas

3 \*  \(   \(   5  \-  10\.2 \) / 0\.5 \) \-  2

Rta      3   5  10\.2  \-   0\.5  /  \*  2  \-

Y evalúa como \-33\.19999

3 \*  \(   \(   5  \-  10\.2  / 0\.5 \) \-

Rta: Error falta \)

3 \*  \(      5  \-  10\.2  \) / 0\.5 \) \-  2

Rta: Error falta \(

Completemos la siguiente tabla con el agregado de paréntesis\. Lo que representa cada celda es la precedencia es si el tope de la pila tiene mayor precedencia que el elemento actual\.

Elemento que está siendo analizado \(actual\)

|  | \+ | \- | \* | / | ^ | \( | \) |
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| \+ | True | True | False | False | False | False | True |
| \- | True | True | False | False | False | False | True |
| \* | True | True | True | True | False | False | True |
| / | True | True | True | True | False | False | True |
| ^ | True | True | True | True | False | False | True |
| \( | False | False | False | False | False | False | <span style="color:#00b050">false</span> |

Elemento que está

en el tope

de la pila \(previo\)

Completemos la siguiente tabla con el agregado de paréntesis\. Lo que representa cada celda es la precedencia es si el tope de la pila tiene mayor precedencia que el elemento actual\.

Elemento que está siendo analizado \(actual\)

|  | \+ | \- | \* | / | ^ | \( | \) |
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| \+ | True | True | False | False | False | False | True |
| \- | True | True | False | False | False | False | True |
| \* | True | True | True | True | False | False | True |
| / | True | True | True | True | False | False | True |
| ^ | True | True | True | True | False | False | True |
| \( | False | False | False | False | False | False | <span style="color:#00b050">false</span> |

Elemento que está

en el tope

de la pila \(previo\)

__Ejercicio__

Implementar en Java el parser de precedencia de operadores que transforme una expresión de notación infija a postfija usando la tabla de precedencia discutida\, incorporando también el manejo de paréntesis\.

![](img/12-A%28parte3%29_12.png)

![](img/12-A%28parte3%29_13.png)

# Más aún

Podríamos considerar una nueva extensión del algoritmo\, donde los operandos no sean solo constantes sino variables previamente definidas\.

\(hacerlo Uds completando el TP\)

Caso de Uso:

__private__  __ __  __static__  __ __  __Map__  __<__  __String__  __\, __  __Integer__  __> __  _vbles_  _ _  _= new _  _HashMap_  _<_  _String_  _\, _  _Double_  _>\(\)_

\{   \{ put\("nro1"\, 0\.2\); put\("x"\, \-2\.0\); put\("y"\, 2\.0\) ; \}   \};

Se invoca igual que antes\.

Si  ingreso

\( nro1 \+  3 \) \*  \( x  \-  \-2  \+  y \)   se obtendría el valor 6\.4

Completar Evaluator para que maneje variables en las expresiones\.

Tip:

En el infijaToPostija  además del método i __sOperand__  __\(__  __currentToken__  __\) __  __ codificar el método __  __isVariable__  __\(__  __currentToken__  __\) y devolver el valor del __  __binding__  __ o error si no fue la variable predefinida__

# Posible implementación

![](img/12-A%28parte3%29_14.png)

