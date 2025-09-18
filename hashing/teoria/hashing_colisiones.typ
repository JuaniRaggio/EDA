= Hashing

- Buena formula de hashing -> Menos colisiones

- No es Orden 1 en rigor, porque *hay siempre posibilidad de colisiones*

== Que pide Java?

- Un buen HashCode, porque Java no tiene idea nuestro tipo de dato


== Como evitar colisiones?

- Una vez el arreglo de la hashtable esta lo suficientemente lleno -> resize


== Resolucion de colisiones

=== *Open Addressing / Closed Hashing*

$=>$ dentro de la misma tabla de hashing se guardan los elementos que colisionan

  + Hasheas
  + Si ya hay un elemento pero tiene un hashCode distinto, colision
  + Avanzas en el arreglo linealmente y lo guardas en el primer espacio libre

_Notemos que si hay lugar, lo encuentra si o si_. La desventaja se presenta cuando aparece el "*Primary clustering*"

==== Baja Fisica 

- Pasa si no hay forma de que seas puente (que el siguiente elemento del arreglo no este ocupado)

==== Baja Logica

- Pasa si pudiste haber sido puente

- En caso de que haya una baja logica y queremos agregar un elemento y coincide con una baja logica, *tenemos que seguir comparando con los siguientes*


=== Open Hashing / Closed Addressing / Chaining

$=>$ fuera del hashing se alamacenan los elementos que colisionaron

- Se resuelven en una estructura auxiliar (Lista lineal, etc)

- Cada ranura puede tener null, o bien una estructura auxiliar con los componentes que colisionaron en dicha ranura

- La zona de overflow se administra a demanda (no a priori)


==== Factor de carga global => Threshold

En caso de alcanzarlo, duplicamos la tabla y rehasheamos con la idea de acercarnos a O(1)

===== Problema
_Si hay una ranura muy llena_, no podemos darnos cuenta con el factor de carga global

===> Algunos usan *factor de carga local* y si una lista particular supera cierta longitud se hace split. Otros *combinan las estrategias*

===== Como lo soluciona Java?

- Si hay pocos elementos, deja la lista desordenada

- Si se alcanza el *factor de carga local*, transforma ese bucket en un RedBlackTree especial que usa tieBreakOrder


