= Algoritmos para texto
Estuvimos viendo algoritmos de aproximacion y similitud

== Problema 1
Dado dos arreglos de chars: *target* y *query*, queremos un codigo Java que permita calcular la primera aoaricion de source en target o -1 si no hay tal aparicion

= Algoritmo Knuth-Morris-Pratt

- Usa el conocimiento de caracteres calculados previamente

- Preprocesa el query antes de la busqueda una vez

- Construye una tabla *Next* del mismo size del query

- Tiene en cada posicion "i" la *longitud del borde propio*

== Ejercicio 1
Calcular el next en cada caso

#table(columns: 12)[Query][A][B][R][A][C][A][D][A][B][R][A][Next][0][0][0][1][0][1][0][1][2][3][4]

#table(columns: 4)[Query][A][B][A][Next][0][0][1]

