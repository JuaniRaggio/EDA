# Estructura de Datos y Algoritmos

# ITBA     2025-Q2

__Ejercicio__

Agregar a la clase Evaluator  el método  __private__  __ __  __String__  __ __  __infijaToPostfija__  __\(\)__  para implementar el parser de precedencia que utiliza la tabla antes diseñada\.

__Caso__  __ de __  __Uso__  __:__

Evaluator e =  __new __  __Evaluator__  __\(\);__

System\. __out\.println__  __\(__  __e\.evaluate__  __\(\)\);__

System\. __out\.println__  __\(__  __e\.evaluate__  __\(\)\);__

System\. __out\.println__  __\(__  __e\.evaluate__  __\(\)\);__

__Si se ingresa__

2 \- 3 \* \-3    devuelve 11

2 / 4 / 2     devuelve  0\.25

2   4   \*      no devuelve excepción

# El algoritmo

A implementar \!\!\! Bajar de campus y completar



* <span style="color:#7f0055"> __private__ </span>  <span style="color:#000000"> __ __ </span>  <span style="color:#000000"> __String__ </span>  <span style="color:#000000"> __ __ </span>  <span style="color:#000000"> __infijaToPostfija__ </span>  <span style="color:#000000"> __\(\)__ </span>
* <span style="color:#000000">\{</span>
* <span style="color:#000000">  </span>  <span style="color:#000000">String</span>  <span style="color:#000000"> </span>  <span style="color:#6a3e3e">postfija</span>  <span style="color:#000000">= </span>  <span style="color:#2a00ff">""</span>  <span style="color:#000000">;</span>
* <span style="color:#000000">  </span>  <span style="color:#000000">Stack</span>  <span style="color:#000000"><</span>  <span style="color:#000000">String</span>  <span style="color:#000000">> </span>  <span style="color:#6a3e3e">theStack</span>  <span style="color:#000000">= </span>  <span style="color:#7f0055"> __new__ </span>  <span style="color:#000000"> __ __ </span>  <span style="color:#000000"> __Stack__ </span>  <span style="color:#000000"> __<__ </span>  <span style="color:#000000"> __String__ </span>  <span style="color:#000000"> __>\(\);__ </span>
* <span style="color:#7f0055"> __  __ </span>  <span style="color:#7f0055"> __while__ </span>  <span style="color:#000000"> __\( __ </span>  <span style="color:#0000c0"> __scannerLine__ </span>  <span style="color:#000000"> __\.hasNext__ </span>  <span style="color:#000000"> __\(\) __ </span>  <span style="color:#000000"> __\) __ </span>  <span style="color:#000000">  \{</span>
* <span style="color:#000000">     </span>  <span style="color:#000000">String</span>  <span style="color:#000000"> </span>  <span style="color:#6a3e3e">currentToken</span>  <span style="color:#000000"> = </span>  <span style="color:#0000c0">scannerLine</span>  <span style="color:#000000">\.next</span>  <span style="color:#000000">\(\);</span>
  * <span style="color:#7f0055"> __if__ </span>  <span style="color:#000000"> __ \( __ </span>  <span style="color:#000000"> __isOperand__ </span>  <span style="color:#000000"> __\(__ </span>  <span style="color:#6a3e3e"> __currentToken__ </span>  <span style="color:#000000"> __\) \) __ </span>  <span style="color:#000000">\{</span>
  * <span style="color:#6a3e3e">	postfija</span>  <span style="color:#000000">\+= </span>  <span style="color:#000000">String\.</span>  <span style="color:#000000"> _format_ </span>  <span style="color:#000000"> _\(_ </span>  <span style="color:#2a00ff"> _"%s "_ </span>  <span style="color:#000000"> _\, _ </span>  <span style="color:#6a3e3e"> _currentToken_ </span>  <span style="color:#000000"> _\);_ </span>
  * <span style="color:#000000">\}</span>
  * <span style="color:#7f0055"> __else__ </span>  <span style="color:#7f0055"> __ __ </span>  <span style="color:#000000">\{</span>
  * <span style="color:#7f0055"> __   __ </span>  <span style="color:#7f0055"> __while__ </span>  <span style="color:#000000"> __ \(\!__ </span>  <span style="color:#6a3e3e"> __theStack__ </span>  <span style="color:#000000"> __\.empty__ </span>  <span style="color:#000000"> __\(\)  && __ </span>  <span style="color:#000000"> __getPrecedence__ </span>  <span style="color:#000000"> __\(__ </span>  <span style="color:#6a3e3e"> __theStack__ </span>  <span style="color:#000000"> __\.peek__ </span>  <span style="color:#000000"> __\(\)\, __ </span>  <span style="color:#6a3e3e"> __currentToken__ </span>  <span style="color:#000000"> __\) \) __ </span>  <span style="color:#000000">\{</span>
  * <span style="color:#6a3e3e">	postfija</span>  <span style="color:#000000">\+= </span>  <span style="color:#000000">String\.</span>  <span style="color:#000000"> _format_ </span>  <span style="color:#000000"> _\(_ </span>  <span style="color:#2a00ff"> _"%s "_ </span>  <span style="color:#000000"> _\, _ </span>  <span style="color:#6a3e3e"> _theStack_ </span>  <span style="color:#000000"> _\.pop_ </span>  <span style="color:#000000"> _\(\) \);_ </span>
  * <span style="color:#000000"> </span>  <span style="color:#000000">  \}</span>
  * <span style="color:#6a3e3e">   </span>  <span style="color:#6a3e3e">theStack</span>  <span style="color:#000000">\.push</span>  <span style="color:#000000">\(</span>  <span style="color:#6a3e3e">currentToken</span>  <span style="color:#000000">\);</span>
  * <span style="color:#000000">\}</span>
* <span style="color:#000000">  \}</span>
* <span style="color:#7f0055"> __  __ </span>  <span style="color:#7f0055"> __while__ </span>  <span style="color:#000000"> __ __ </span>  <span style="color:#000000"> __\( \!__ </span>  <span style="color:#6a3e3e"> __theStack__ </span>  <span style="color:#000000"> __\.empty__ </span>  <span style="color:#000000"> __\(\) __ </span>  <span style="color:#000000"> __\) __ </span>  <span style="color:#000000">\{</span>
  * <span style="color:#6a3e3e">	postfija</span>  <span style="color:#000000">\+= </span>  <span style="color:#000000">String\.</span>  <span style="color:#000000"> _format_ </span>  <span style="color:#000000"> _\(_ </span>  <span style="color:#2a00ff"> _"%s "_ </span>  <span style="color:#000000"> _\, _ </span>  <span style="color:#6a3e3e"> _theStack_ </span>  <span style="color:#000000"> _\.pop_ </span>  <span style="color:#000000"> _\(\) \);_ </span>
* <span style="color:#000000">   \}</span>
* <span style="color:#7f0055"> __ __ </span>  <span style="color:#7f0055"> __  __ </span>  <span style="color:#7f0055"> __return__ </span>  <span style="color:#000000"> __ __ </span>  <span style="color:#6a3e3e"> __postfija__ </span>  <span style="color:#000000"> __;__ </span>
* <span style="color:#000000">\}</span>


Posible

solución:

Para chequear correctitud y ante la presencia de métodos private ¿cómo hacemos?

Si bien la idea de Junit es chequear métodos públicos \(del contrato\) si quisiéramos hacerlo con el método importante  infijaToPostfija\(\)  lo podemos hacer con alguna licencia…

public?

reflection

Sea la clase Sorpresa

<span style="color:#0000ff">public class </span>  <span style="color:#277f99">Sorpresa </span>  <span style="color:#3f9101">\{</span>  <span style="color:#3f9101">    </span>  <span style="color:#3f9101">    </span>  <span style="color:#0000ff">private double </span>  <span style="color:#795e26">f</span>  <span style="color:#3f9101">\(\)</span>  <span style="color:#0e4a8e">\{</span>  <span style="color:#0e4a8e">       </span>  <span style="color:#bf3be2">return </span>  <span style="color:#098658">35</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#0e4a8e">\}</span>  <span style="color:#0e4a8e">    </span>  <span style="color:#0e4a8e">    </span>  <span style="color:#0000ff">private double </span>  <span style="color:#795e26">f</span>  <span style="color:#3f9101">\(</span>  <span style="color:#0000ff">double </span>  <span style="color:#001080">param</span>  <span style="color:#3f9101">\)</span>  <span style="color:#0e4a8e">\{</span>  <span style="color:#0e4a8e">       </span>  <span style="color:#bf3be2">return </span>  <span style="color:#001080">param</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#0e4a8e">\}</span>  <span style="color:#3f9101">\}</span>

<span style="color:#0000ff">class </span>  <span style="color:#277f99">Testing </span>  <span style="color:#3f9101">\{</span>

<span style="color:#3f9101">  </span>  <span style="color:#808000">@Test</span>  <span style="color:#3f9101">  </span>  <span style="color:#0000ff">void </span>  <span style="color:#795e26">test1</span>  <span style="color:#3f9101">\(\) </span>  <span style="color:#0000ff">throws </span>  <span style="color:#277f99">NoSuchMethodException</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#277f99">SecurityException</span>  <span style="color:#3b3b3b">\,</span>  <span style="color:#3b3b3b">          </span>  <span style="color:#277f99">IllegalAccessException</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#277f99">IllegalArgumentException</span>  <span style="color:#3b3b3b">\,</span>  <span style="color:#3b3b3b">          </span>  <span style="color:#277f99">InvocationTargetException </span>  <span style="color:#3f9101">\{</span>

<span style="color:#3f9101">    </span>  <span style="color:#3f9101"> </span>  <span style="color:#277f99">Sorpresa </span>  <span style="color:#001080">sorpresaInstance </span>  <span style="color:#000000">= </span>  <span style="color:#bf3be2">new </span>  <span style="color:#795e26">Sorpresa</span>  <span style="color:#3f9101">\(\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3f9101"> </span>  <span style="color:#277f99">Method </span>  <span style="color:#001080">myMethod </span>  <span style="color:#000000">= </span>  <span style="color:#277f99">Sorpresa</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#0000ff">class</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#795e26">getDeclaredMethod</span>  <span style="color:#3f9101">\(</span>  <span style="color:#a31515">"f"</span>  <span style="color:#3f9101">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3f9101"> </span>  <span style="color:#001080"> __myMethod__ </span>  <span style="color:#3b3b3b"> __\.__ </span>  <span style="color:#795e26"> __setAccessible__ </span>  <span style="color:#3f9101"> __\(__ </span>  <span style="color:#0000ff"> __true__ </span>  <span style="color:#3f9101"> __\)__ </span>  <span style="color:#3b3b3b"> __;__ </span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3f9101"> </span>  <span style="color:#0000ff">double </span>  <span style="color:#001080">result </span>  <span style="color:#000000">= </span>  <span style="color:#3f9101">\(</span>  <span style="color:#277f99">Double</span>  <span style="color:#3f9101">\) </span>  <span style="color:#001080">myMethod</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#795e26">invoke</span>  <span style="color:#0e4a8e">\(</span>  <span style="color:#001080">sorpresaInstance</span>  <span style="color:#0e4a8e">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3f9101"> </span>  <span style="color:#3b3b3b"> _assertEquals_ </span>  <span style="color:#3f9101">\( </span>  <span style="color:#098658">35</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#001080">result</span>  <span style="color:#3f9101">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3f9101">  </span>  <span style="color:#3f9101">\}</span>

Sea la clase Sorpresa

<span style="color:#0000ff">public class </span>  <span style="color:#277f99">Sorpresa </span>  <span style="color:#3f9101">\{</span>  <span style="color:#3f9101">    </span>  <span style="color:#3f9101">    </span>  <span style="color:#0000ff">private double </span>  <span style="color:#795e26">f</span>  <span style="color:#3f9101">\(\)</span>  <span style="color:#0e4a8e">\{</span>  <span style="color:#0e4a8e">       </span>  <span style="color:#bf3be2">return </span>  <span style="color:#098658">35</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#0e4a8e">\}</span>  <span style="color:#0e4a8e">    </span>  <span style="color:#0e4a8e">    </span>  <span style="color:#0000ff">private double </span>  <span style="color:#795e26">f</span>  <span style="color:#3f9101">\(</span>  <span style="color:#0000ff">double </span>  <span style="color:#001080">param</span>  <span style="color:#3f9101">\)</span>  <span style="color:#0e4a8e">\{</span>  <span style="color:#0e4a8e">       </span>  <span style="color:#bf3be2">return </span>  <span style="color:#001080">param</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#0e4a8e">\}</span>  <span style="color:#3f9101">\}</span>

<span style="color:#808000">@Test</span>  <span style="color:#0000ff">void </span>  <span style="color:#795e26">test2</span>  <span style="color:#3f9101">\(\) </span>  <span style="color:#0000ff">throws </span>  <span style="color:#277f99">NoSuchMethodException</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#277f99">SecurityException</span>  <span style="color:#3b3b3b">\,</span>  <span style="color:#3b3b3b">       </span>  <span style="color:#277f99">IllegalAccessException</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#277f99">IllegalArgumentException</span>  <span style="color:#3b3b3b">\,</span>  <span style="color:#3b3b3b">       </span>  <span style="color:#277f99">InvocationTargetException </span>  <span style="color:#3f9101">\{</span>  <span style="color:#3f9101">    </span>  <span style="color:#277f99">Sorpresa </span>  <span style="color:#001080">sorpresaInstance </span>  <span style="color:#000000">= </span>  <span style="color:#bf3be2">new </span>  <span style="color:#795e26">Sorpresa</span>  <span style="color:#3f9101">\(\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#277f99">Method </span>  <span style="color:#001080">myMethod </span>  <span style="color:#000000">= </span>  <span style="color:#277f99">Sorpresa</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#0000ff">class</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#795e26">getDeclaredMethod</span>  <span style="color:#3f9101">\(</span>  <span style="color:#a31515">"f"</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#0000ff">double</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#0000ff">class</span>  <span style="color:#3f9101">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#001080"> __myMethod__ </span>  <span style="color:#3b3b3b"> __\.__ </span>  <span style="color:#795e26"> __setAccessible__ </span>  <span style="color:#3f9101"> __\(__ </span>  <span style="color:#0000ff"> __true__ </span>  <span style="color:#3f9101"> __\)__ </span>  <span style="color:#3b3b3b"> __;__ </span>  <span style="color:#3b3b3b">    </span>  <span style="color:#0000ff">double </span>  <span style="color:#001080">result </span>  <span style="color:#000000">= </span>  <span style="color:#3f9101">\(</span>  <span style="color:#277f99">Double</span>  <span style="color:#3f9101">\) </span>  <span style="color:#001080">myMethod</span>  <span style="color:#3b3b3b">\.</span>  <span style="color:#795e26">invoke</span>  <span style="color:#0e4a8e">\(</span>  <span style="color:#001080">sorpresaInstance</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#098658">34\.5</span>  <span style="color:#0e4a8e">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3b3b3b"> _assertEquals_ </span>  <span style="color:#3f9101">\( </span>  <span style="color:#098658">34\.5</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#001080">result</span>  <span style="color:#3f9101">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3f9101">\}</span>

Por otro lado\, cómo inyectar desde Junit algo en consola input?

<span style="color:#808000">@Test</span>  <span style="color:#0000ff">void </span>  <span style="color:#795e26">test</span>  <span style="color:#3f9101">\(\) \{</span>  <span style="color:#3f9101">    </span>  <span style="color:#008000">// </span>  <span style="color:#008000">inyecto</span>  <span style="color:#008000"> </span>  <span style="color:#008000">en</span>  <span style="color:#008000"> la standard input</span>  <span style="color:#008000">    </span>  <span style="color:#277f99"> __String __ </span>  <span style="color:#001080"> __input __ </span>  <span style="color:#000000"> __= __ </span>  <span style="color:#a31515"> __"15 \+ 3"__ </span>  <span style="color:#3b3b3b"> __;__ </span>  <span style="color:#3b3b3b"> __    __ </span>  <span style="color:#277f99"> __InputStream __ </span>  <span style="color:#001080"> __inputStream__ </span>  <span style="color:#001080"> __ __ </span>  <span style="color:#000000"> __= __ </span>  <span style="color:#bf3be2"> __new __ </span>  <span style="color:#795e26"> __ByteArrayInputStream__ </span>  <span style="color:#3f9101"> __\(__ </span>  <span style="color:#001080"> __input__ </span>  <span style="color:#3b3b3b"> __\.__ </span>  <span style="color:#795e26"> __getBytes__ </span>  <span style="color:#0e4a8e"> __\(\)__ </span>  <span style="color:#3f9101"> __\)__ </span>  <span style="color:#3b3b3b"> __;__ </span>  <span style="color:#3b3b3b"> __    __ </span>  <span style="color:#277f99"> __System__ </span>  <span style="color:#3b3b3b"> __\.__ </span>  <span style="color:#3b3b3b"> _setIn_ </span>  <span style="color:#3f9101"> __\(__ </span>  <span style="color:#001080"> __inputStream__ </span>  <span style="color:#3f9101"> __\)__ </span>  <span style="color:#3b3b3b"> __;__ </span>  <span style="color:#3b3b3b">    Evaluator </span>  <span style="color:#001080">myEval </span>  <span style="color:#000000">= </span>  <span style="color:#3b3b3b">Evaluator</span>  <span style="color:#3f9101">\(\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#0000ff">double </span>  <span style="color:#001080">rta </span>  <span style="color:#000000">= </span>  <span style="color:#001080">myEval</span>  <span style="color:#3b3b3b">\.evaluate</span>  <span style="color:#3f9101">\(\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3b3b3b">    </span>  <span style="color:#3b3b3b"> _assertEquals_ </span>  <span style="color:#3f9101">\( </span>  <span style="color:#098658">18</span>  <span style="color:#3b3b3b">\, </span>  <span style="color:#001080">rta</span>  <span style="color:#3f9101">\)</span>  <span style="color:#3b3b3b">;</span>  <span style="color:#3f9101">\}</span>

__Ejercicio__

Ahora vamos a incorporar el operador ^

La precedencia entre operadores está dado por:

Pero atención\, el operador  <span style="color:#00b050">es</span>  <span style="color:#00b050"> </span>  <span style="color:#00b050">asociativo</span>  <span style="color:#00b050"> a </span>  <span style="color:#00b050">derecha</span>  <span style="color:#00b050">\!\!\!\!</span> \.

![](img/12-A%28parte2%29%281%29_0.png)

[Ver](https://en.wikipedia.org/wiki/Order_of_operations)

[https](https://en.wikipedia.org/wiki/Order_of_operations)[://](https://en.wikipedia.org/wiki/Order_of_operations)[en\.wikipedia\.org/wiki/Order\_of\_operations](https://en.wikipedia.org/wiki/Order_of_operations)

\(Serial Exponentiation\)

![](img/12-A%28parte2%29%281%29_1.png)

Completemos la siguiente tabla sabiendo que ^ es asociativa a derecha\. Lo que representa cada celda es la precedencia es si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte2%29%281%29_2.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / | ^ |
| :-: | :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | false | false | False |
| \- | true | true | false | false | false |
| \* | true | true | true | true | False |
| / | true | true | true | true | false |
| ^ | True | True | True | true | false |

Completemos la siguiente tabla sabiendo que ^ es asociativa a derecha\. Lo que representa cada celda es la precedencia es si el tope de la pila tiene mayor precedencia que el elemento actual\.

![](img/12-A%28parte2%29%281%29_3.png)

Elemento que está siendo analizado \(actual\)

Elemento que está

en el tope

de la pila \(previo\)

|  | \+ | \- | \* | / | ^ |
| :-: | :-: | :-: | :-: | :-: | :-: |
| \+ | true | true | false | false | False |
| \- | true | true | false | false | false |
| \* | true | true | true | true | False |
| / | true | true | true | true | false |
| ^ | True | True | True | true | false |

Modificar la precedencia agregando el Nuevo operador\.

Chequear con las expresiones:

__3 \+ 10 \* 2 / __  __1  \(deberían obtener   3  10  2  \*  1  /   \+      y evalúa a 23__

__13  ^ 2 \- 1 \* 7   \(deberían obtener 13  2  ^ 1 7  \* \-  y evalúa a 162__

__5 ^ 2  ^ 3  \-  1   \(__  __debería__  __ __  __obtenerse__  __  5  2  3  ^  ^ 1 \-  y __  __eval__  __ú__  __a__  __ a 390624 __

__Ejercicio__

Implementar en Java el parser de precedencia de operadores que transforme una expresión de notación infija a postfija usando la tabla de precedencia discutida\, incorporando la exponenciación\.

![](img/12-A%28parte2%29%281%29_4.png)

__Posible__  __ __  __solución__  __:__

Solo agregar a la tabla de precedencia el ^

actualizar eval\(\) para que considere ^ como válido\, devolviendo  Math\.pow\(a\, b\)\.  No olvidar que matches también acepta el nuevo ^

Ejemplo:

2 \- 3 ^ \-3    devuelve 1\.9629

2 ^ 4 ^ 2     devuelve  65536  \( y no 256\)

3 \+ 10 \* 2 / 1    \(toPostfija\(\) da   3  10  2  \*  1  /   \+    \)   y evalúa a 23

13  ^ 2 \- 1 \* 7   \(toPostfija\(\) da 13  2  ^ 1 7  \* \-  \) y evalúa a 162

5 ^ 2  ^ 3  \-  1   \(toPostfija\(\) da  5  2  3  ^  ^ 1 \-  \) y evalúa a 390624

