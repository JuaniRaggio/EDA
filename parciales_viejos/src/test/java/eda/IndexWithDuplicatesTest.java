package eda;

import com.primeros_parciales.gordo.primerc_2024.IndexWithDuplicates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexWithDuplicatesTest {

    @Test
    void testCase1_IndicesOrdenadosSinElementosDuplicados() {
        // Caso de Uso 1 - Índices Ordenados sin Elementos Duplicados
        IndexWithDuplicates index1 = new IndexWithDuplicates();
        index1.initialize(new int[] {1, 3, 5, 7});

        IndexWithDuplicates index2 = new IndexWithDuplicates();
        index2.initialize(new int[] {2, 4, 6, 8});

        index1.merge(index2);

        // Resultado esperado: [1, 2, 3, 4, 5, 6, 7, 8]
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, index1.getIndexedData());
    }

    @Test
    void testCase2_IndicesOrdenadosConElementosDuplicados() {
        // Caso de Uso 2 - Índices Ordenados con Elementos Duplicados
        IndexWithDuplicates index1 = new IndexWithDuplicates();
        index1.initialize(new int[] {1, 1, 3, 5, 7});

        IndexWithDuplicates index2 = new IndexWithDuplicates();
        index2.initialize(new int[] {2, 4, 4, 6, 8});

        index1.merge(index2);

        // Resultado esperado: [1, 1, 2, 3, 4, 4, 5, 6, 7, 8]
        int[] expected = {1, 1, 2, 3, 4, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, index1.getIndexedData());
    }

    @Test
    void testCase3_IndicesOrdenadosConDiferentesCantidades() {
        // Caso de Uso 3 - Índices Ordenados con Diferentes Cantidades de Elementos
        IndexWithDuplicates index1 = new IndexWithDuplicates();
        index1.initialize(new int[] {1, 3, 5});

        IndexWithDuplicates index2 = new IndexWithDuplicates();
        index2.initialize(new int[] {2, 4, 6, 8, 10});

        index1.merge(index2);

        // Resultado esperado: [1, 2, 3, 4, 5, 6, 8, 10]
        int[] expected = {1, 2, 3, 4, 5, 6, 8, 10};
        assertArrayEquals(expected, index1.getIndexedData());
    }

    @Test
    void testMergeWithEmptyIndex() {
        // Caso adicional: fusionar con índice vacío
        IndexWithDuplicates index1 = new IndexWithDuplicates();
        index1.initialize(new int[] {1, 3, 5});

        IndexWithDuplicates index2 = new IndexWithDuplicates();
        index2.initialize(new int[] {});

        index1.merge(index2);

        // El resultado debe ser el mismo que index1 original
        int[] expected = {1, 3, 5};
        assertArrayEquals(expected, index1.getIndexedData());
    }

    @Test
    void testMergeWithNull() {
        // Caso adicional: fusionar con null
        IndexWithDuplicates index1 = new IndexWithDuplicates();
        index1.initialize(new int[] {1, 3, 5});

        index1.merge(null);

        // El resultado debe ser el mismo que index1 original
        int[] expected = {1, 3, 5};
        assertArrayEquals(expected, index1.getIndexedData());
    }

}