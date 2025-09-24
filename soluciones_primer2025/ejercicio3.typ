#align(center)[= Ejercicio 3]

_Query (con StandardAnalyzer):_ content:beta OR content:delta

== Documentos indexados
- Doc10.txt: alfa beta gama
- Doc11.txt: beta beta gama beta gama
- Doc12.txt: gama delta
- Doc13.txt: alfa beta gama delta

== Analisis de terminos

*Termino "beta"*
- Aparece en Doc10 (1 vez), Doc11 (3 veces), Doc13 (1 vez)  
- Document frequency (DF) = 3  
- Inverse Document Frequency (IDF):  
$ "idf"(beta) = ln(4/3) = 0.287682 $

*Termino "delta"*
- Aparece en Doc12 (1 vez), Doc13 (1 vez)  
- Document frequency (DF) = 2  
- Inverse Document Frequency (IDF):  
$ "idf"(delta) = ln(4/2) = 0.693147 $

== Calculos de "TF"
- Doc10: tf(beta)=1 → $"TF" = sqrt(1)=1$
- Doc11: tf(beta)=3 → $"TF" = sqrt(3)=1.732051$
- Doc12: tf(delta)=1 → $"TF" = sqrt(1)=1$
- Doc13: tf(beta)=1 → $"TF" =1$, tf(delta)=1 → $"TF"=1$

== Scores por documento
*Doc10*  
$ "Score" = 1 times 0.287682 = 0.287682 $

*Doc11*  
$ "Score" = 1.732051 times 0.287682 = 0.498676 $

*Doc12*  
$ "Score" = 1 times 0.693147 = 0.693147 $

*Doc13*  
$ "Score" = 1 times 0.287682 + 1 times 0.693147 = 0.980829 $

== Ranking final
1. $"Score" = 0.980829 arrow "Doc13.txt (docid=3)"$
2. $"Score" = 0.693147 arrow "Doc12.txt (docid=2)"$
3. $"Score" = 0.498676 arrow "Doc11.txt (docid=1)"$
4. $"Score" = 0.287682 arrow "Doc10.txt (docid=0)"$

== Justificacion
1. *TF*: Se usa la raiz cuadrada del conteo de apariciones.  
2. *IDF*: $ln(N/"df")$, donde $N=4$ documentos.  
3. *"Score" por termino*: $"TF" times "IDF"$
4. *"Score" del documento*: Suma de los scores de todos los terminos del query presentes en el doc. 

*Obs:* El termino *delta* tiene mas peso porque aparece en menos documentos (mayor IDF), lo que lo hace mas discriminativo que *beta*.

