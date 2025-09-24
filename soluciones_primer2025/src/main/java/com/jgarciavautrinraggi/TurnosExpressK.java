package com.jgarciavautrinraggi;

import java.util.Arrays;
import java.util.List;

public class TurnosExpressK {
    public static void atender(int K, List<String> tokens) {
        BoundedQueue<String> queue = new BoundedQueue<>(K);
        int atendidos = 0;
        int rechazados = 0;

        for (String token : tokens) {
            if (token.startsWith("A:")) {
                // Evento de agregado
                String personId = token.substring(2);
                if (!queue.isFull()) {
                    queue.enqueue(personId);
                } else {
                    rechazados++;
                }
            } else if (token.equals("S")) {
                // Evento de sacado
                if (!queue.isEmpty()) {
                    queue.dequeue();
                    atendidos++;
                }
                // Si está vacía, se ignora
            }
        }

        // Contar personas que quedaron en cola
        int enCola = 0;
        while (!queue.isEmpty()) {
            queue.dequeue();
            enCola++;
        }

        System.out.println("ATENDIDOS=" + atendidos + " RECHAZADOS=" + rechazados + " EN_COLA=" + enCola);
    }

    public static void main(String[] args) {
        System.out.println("== Caso 1 ==");
        atender(3,
                Arrays.asList("A:A1","A:A2","A:A3","A:A4","S","A:A5","S","A:A6","S","S","A:A7","A:A8"
        ));

        System.out.println("== Caso 2 ==");
        atender(2,
                Arrays.asList("S","A:P1","S","S","A:P2","A:P3","S","A:P4","S"
        ));

        System.out.println("== Caso 3 ==");
        atender(2,
                Arrays.asList("A:X","A:Y","A:Z","A:W","S","A:K","A:L","A:M"
        ));
        System.out.println("== Caso 4 ==");
        atender(3,
                Arrays.asList("A:P1","A:P2","A:P3","A:P4","S","A:P5","S","A:P6","S","S"
        ));
        System.out.println("== Caso 5 ==");
        atender(2,
                Arrays.asList("S","S", "A:P1", "A:P2"
        ));
    }
}
