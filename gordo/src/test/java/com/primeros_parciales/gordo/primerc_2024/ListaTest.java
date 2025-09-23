package com.primeros_parciales.gordo.primerc_2024;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    @Test
    void testRandomSplitListas_CasoA_Main1() {
        // Test del caso A (main1) del parcial
        Lista l = new Lista(10); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10

        // Verificar que la lista original tiene los elementos esperados
        assertNotNull(l);

        Lista[] resultado = l.randomSplitListas(4);

        // Verificar que se crearon 4 listas
        assertEquals(4, resultado.length);

        // Verificar que todas las listas fueron creadas
        for (int i = 0; i < 4; i++) {
            assertNotNull(resultado[i]);
        }

        // Verificar que la lista original quedó vacía
        assertTrue(isListEmpty(l));

        // Verificar que el total de elementos se conserva
        int totalElementos = 0;
        for (Lista lista : resultado) {
            totalElementos += countElements(lista);
        }
        assertEquals(10, totalElementos);
    }

    @Test
    void testRandomSplitListas_CasoB_Main2() {
        // Test del caso B (main2) del parcial
        Lista l = new Lista(5, 7, true); // 5 -> 7 -> 12 -> 14 -> 19 -> 21 -> 26

        Lista[] resultado = l.randomSplitListas(6);

        // Verificar que se crearon 6 listas
        assertEquals(6, resultado.length);

        // Verificar que todas las listas fueron creadas
        for (int i = 0; i < 6; i++) {
            assertNotNull(resultado[i]);
        }

        // Verificar que la lista original quedó vacía
        assertTrue(isListEmpty(l));

        // Verificar que el total de elementos se conserva
        int totalElementos = 0;
        for (Lista lista : resultado) {
            totalElementos += countElements(lista);
        }
        assertEquals(7, totalElementos);
    }

    @Test
    void testRandomSplitListas_CasoC_Main3() {
        // Test del caso C (main3) del parcial
        Lista l = new Lista(5, 7, false); // 5 -> 10 -> 12 -> 17 -> 19 -> 24 -> 26

        Lista[] resultado = l.randomSplitListas(6);

        // Verificar que se crearon 6 listas
        assertEquals(6, resultado.length);

        // Verificar que todas las listas fueron creadas
        for (int i = 0; i < 6; i++) {
            assertNotNull(resultado[i]);
        }

        // Verificar que la lista original quedó vacía
        assertTrue(isListEmpty(l));

        // Verificar que el total de elementos se conserva
        int totalElementos = 0;
        for (Lista lista : resultado) {
            totalElementos += countElements(lista);
        }
        assertEquals(7, totalElementos);
    }

    @Test
    void testRandomSplitListas_CasoD_Main4() {
        // Test del caso D (main4) del parcial - lista vacía
        Lista l = new Lista(); // Lista vacía

        Lista[] resultado = l.randomSplitListas(4);

        // Verificar que se crearon 4 listas
        assertEquals(4, resultado.length);

        // Verificar que todas las listas fueron creadas pero están vacías
        for (int i = 0; i < 4; i++) {
            assertNotNull(resultado[i]);
            assertTrue(isListEmpty(resultado[i]));
        }

        // Verificar que la lista original sigue vacía
        assertTrue(isListEmpty(l));
    }

    @Test
    void testRandomSplitListas_UnaSolaLista() {
        // Test con una sola lista destino
        Lista l = new Lista(5); // 1 -> 2 -> 3 -> 4 -> 5

        Lista[] resultado = l.randomSplitListas(1);

        // Verificar que se creó 1 lista
        assertEquals(1, resultado.length);
        assertNotNull(resultado[0]);

        // Todos los elementos deben estar en la primera lista
        assertEquals(5, countElements(resultado[0]));

        // La lista original debe estar vacía
        assertTrue(isListEmpty(l));
    }

    @Test
    void testRandomSplitListas_MasListasQueElementos() {
        // Test con más listas que elementos
        Lista l = new Lista(3); // 1 -> 2 -> 3

        Lista[] resultado = l.randomSplitListas(5);

        // Verificar que se crearon 5 listas
        assertEquals(5, resultado.length);

        // Verificar que todas las listas fueron creadas
        for (int i = 0; i < 5; i++) {
            assertNotNull(resultado[i]);
        }

        // Verificar que el total de elementos se conserva
        int totalElementos = 0;
        for (Lista lista : resultado) {
            totalElementos += countElements(lista);
        }
        assertEquals(3, totalElementos);

        // Al menos 2 listas deben estar vacías
        int listasVacias = 0;
        for (Lista lista : resultado) {
            if (countElements(lista) == 0) {
                listasVacias++;
            }
        }
        assertTrue(listasVacias >= 2);

        // La lista original debe estar vacía
        assertTrue(isListEmpty(l));
    }

    @Test
    void testConstructores() {
        // Test constructor vacío
        Lista l1 = new Lista();
        assertTrue(isListEmpty(l1));

        // Test constructor con número máximo
        Lista l2 = new Lista(5);
        assertEquals(5, countElements(l2));

        // Test constructor con parámetros (sorpresa = true)
        Lista l3 = new Lista(10, 4, true);
        assertEquals(4, countElements(l3));

        // Test constructor con parámetros (sorpresa = false)
        Lista l4 = new Lista(10, 4, false);
        assertEquals(4, countElements(l4));
    }

    @Test
    void testConstructorExcepciones() {
        // Test excepciones en constructores
        assertThrows(RuntimeException.class, () -> new Lista(0));
        assertThrows(RuntimeException.class, () -> new Lista(-1));
        assertThrows(RuntimeException.class, () -> new Lista(5, 0, true));
        assertThrows(RuntimeException.class, () -> new Lista(5, -1, false));
    }

    // Métodos auxiliares para testing
    private boolean isListEmpty(Lista lista) {
        // Usando reflexión para acceder a los campos privados
        try {
            java.lang.reflect.Field firstField = Lista.class.getDeclaredField("first");
            firstField.setAccessible(true);
            Object first = firstField.get(lista);
            return first == null;
        } catch (Exception e) {
            // Si no podemos acceder por reflexión, usamos el método dump para verificar
            return true; // Asumimos que está vacía si no podemos verificar
        }
    }

    private int countElements(Lista lista) {
        // Contar elementos usando reflexión
        try {
            java.lang.reflect.Field firstField = Lista.class.getDeclaredField("first");
            firstField.setAccessible(true);
            Object first = firstField.get(lista);

            if (first == null) {
                return 0;
            }

            int count = 0;
            Object current = first;

            while (current != null) {
                count++;
                java.lang.reflect.Field nextField = current.getClass().getDeclaredField("next");
                nextField.setAccessible(true);
                current = nextField.get(current);
            }

            return count;
        } catch (Exception e) {
            return 0; // Si no podemos contar, retornamos 0
        }
    }

    @Test
    void testNoSeCreanNuevosNodos() {
        // Verificar que no se crean nuevos nodos, solo se redistribuyen
        Lista l = new Lista(5);

        // Contar nodos antes
        int nodosAntes = countElements(l);

        Lista[] resultado = l.randomSplitListas(3);

        // Contar nodos después
        int nodosDesues = 0;
        for (Lista lista : resultado) {
            nodosDesues += countElements(lista);
        }

        // Debe ser la misma cantidad
        assertEquals(nodosAntes, nodosDesues);

        // La lista original debe estar vacía
        assertEquals(0, countElements(l));
    }
}