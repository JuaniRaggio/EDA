# Estructura de Datos y Algoritmos

# ITBA     2025-Q2

# Parser de Precedencia de Operadores

__Algoritmo__  __ para __  __transformar__  __ __  __expresión__  __ __  __en__  __ __  __notación__  __ __  __infija__  __ a __  __expresión__  __ __  __en__  __ __  __notación__  __ __  __postfija__  __\.__

Idea:

cada vez que aparezcan varios operadores se consultará un tabla que indique cuál se evalúa primero\.

Si dos operadores tienen la misma precedencia\, se utiliza la regla de asociatividad para saber cuál se evalúa primero\.

Ejemplo:

La asociatividad de esas 4 operaciones es de izquierda a derecha\.

Por lo tanto si tenemos A \- B \+ C en la expresión postfija primero tiene que aparecer el – \(ya que se evaluará primero A – B\)\.

Eso es debido a que \+\- tienen la misma precedencia\, pero como es asociativo a izquierda si llega un “\+” y había previo un  “\-”\, entonces el previo – se evalúa antes que el \+\.

![](img/12-A%28parte1%29_0.png)

Ejemplo:

Si tenemos  A  \+  B  \*  C  / D  entre el “\+” y el “\*”\, el segundo debe aparecer antes que el “\+” en la expression postfija

Pero entre el “\*” y el “/”  el “\*” también tiene que aparecer antes porque aunque tiene igual precedencia\, la asociatividad a izquierda indica que se evaluará primero el “\*” y luego el “/”\.

Resumiendo\, deberían aparecer en la expression postfija:  primero el \*\, luego el /  y finalmente el \+

La expression original es equivalente a : A \+ \( \(B \* C\) / D \) \.

Salvo que se quisiera cambiar este comportamiento\, no hace falta colocar paréntesis en la expresión infija\.

Completemos la siguiente tabla sabiendo que esas operaciones son asociativas a izquierda\. Lo que representa cada celda es la precedencia de si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte1%29_1.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / |
| :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | False | false |
| \- | true | true | False | false |
| \* | true | true | True | True |
| / | true | true | True | true |

Completemos la siguiente tabla sabiendo que esas operaciones son asociativas a izquierda\. Lo que representa cada celda es la precedencia de si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte1%29_2.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / |
| :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | False | false |
| \- | true | true | False | false |
| \* | true | true | True | True |
| / | true | true | True | true |

Completemos la siguiente tabla sabiendo que esas operaciones son asociativas a izquierda\. Lo que representa cada celda es la precedencia de si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte1%29_3.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / |
| :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | False | false |
| \- | true | true | False | false |
| \* | true | true | True | True |
| / | true | true | True | true |

Completemos la siguiente tabla sabiendo que esas operaciones son asociativas a izquierda\. Lo que representa cada celda es la precedencia de si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte1%29_4.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / |
| :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | False | false |
| \- | true | true | False | false |
| \* | true | true | True | True |
| / | true | true | True | true |

Completemos la siguiente tabla sabiendo que esas operaciones son asociativas a izquierda\. Lo que representa cada celda es la precedencia de si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte1%29_5.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / |
| :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | False | false |
| \- | true | true | False | false |
| \* | true | true | True | True |
| / | true | true | True | true |

# Algoritmo infija=>postfija



* <span style="color:#c00000">Cada </span>  <span style="color:#c00000">operando </span> de la expresión infija se copia en la expresión postfija\.
* Cuando aparece  <span style="color:#00b050">un operador </span> hay que analizar precedencia respecto del resto de los previos operadores\, por lo tanto los casos se reducen a chequear la precedencia entre el  __tope de la pila __ y el  __operador __  __current__ :
* Si la pila está vacía\, se  “ __pushea__  __” el operador __  __current__  ya que no se lo puede comparar con nada porque es el primero de la subexpresión\.
* Si la pila no está vacía:
  * Si el  __tope de la pila __  __tiene__  __ mayor __  __precedencia__  __ __ que el  __operador__  __ curre__ nt\, entonces se realizar “ __pop__ ” del operador en la pila y se lo copia en la expresión postfija  <span style="color:#ff0000"> __hasta que __ </span> se acabe la pila o quede en ella uno de menor precedencia que el  __operador__  __ current__ \.  <span style="color:#ff0000"> __S__ </span>  <span style="color:#ff0000">e </span>  <span style="color:#ff0000"> __pushea__ </span>  <span style="color:#ff0000"> __ al operador __ </span>  <span style="color:#ff0000"> __current__ </span>  <span style="color:#ff0000">\, ya que hay que postergar su acción hasta que aparezca otro operador\.</span>
  * Si el  __tope de la pila tiene menor precedencia que __ el  __operador __  __current__  __ no se puede ir todavía… __  <span style="color:#ff0000"> __S__ </span>  <span style="color:#ff0000">e </span>  <span style="color:#ff0000"> __pushea__ </span>  <span style="color:#ff0000"> __ al operador __ </span>  <span style="color:#ff0000"> __current__ </span>  <span style="color:#ff0000">\, </span>  <span style="color:#ff0000">ya que hay que postergar su acción hasta que aparezca otro operador</span>  <span style="color:#ff0000">\.</span>
* Cuando se terminó de analizar la expresión infija\, se __ “popean”__  todos los operadores de la pila y se copian en la expresión postfija\.


Ejemplo:  Supongamos que tenemos la expresión infija   __3 \+ 10 \* 2 / 1__

El algoritmo funciona así:

![](img/12-A%28parte1%29_6.png)

![](img/12-A%28parte1%29_7.png)

![](img/12-A%28parte1%29_8.png)

![](img/12-A%28parte1%29_9.png)

![](img/12-A%28parte1%29_10.png)

![](img/12-A%28parte1%29_11.png)

![](img/12-A%28parte1%29_12.png)

![](img/12-A%28parte1%29_13.png)

O sea\,

__3 __  __ \+  10  \*  2  __  __/ __  __ 1__    =>    3   10   2  \*  1  /  \+

Aplicar el algoritmo \(en papel\) para pasar a notación postfija las siguientes expresiones infijas:

![](img/12-A%28parte1%29_14.png)

Notar que el pasaje de infija a postfija no detecta muchos errores\. La mayoría se detectan en tiempo de ejecución al  __evaluar__  la expresión\.

Ej:  4 \* / 2      no da error\, genera   4 \* 2 /

__Ejercicio__

¿Cómo implementar en Java la tabla que utiliza el parser de precedencia de operadores ?

# Posibilidad Opcion 1

![](img/12-A%28parte1%29_15.png)

![](img/12-A%28parte1%29_16.png)

![](img/12-A%28parte1%29_17.png)

![](img/12-A%28parte1%29_18.png)

