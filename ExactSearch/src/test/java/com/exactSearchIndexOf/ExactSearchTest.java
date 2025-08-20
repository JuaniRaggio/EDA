package com.exactSearchIndexOf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExactSearchTest {

    @Test
    void testTargetEncontradoAlInicio() {
        assertEquals(0, ExactSearch.indexOf("hola mundo".toCharArray(), "hola".toCharArray()));
    }

    @Test
    void testTargetEncontradoEnMedio() {
        assertEquals(6, ExactSearch.indexOf("prueba hola mundo".toCharArray(), "hola".toCharArray()));
    }

    @Test
    void testTargetEncontradoAlFinal() {
        assertEquals(5, ExactSearch.indexOf("adioshola".toCharArray(), "hola".toCharArray()));
    }

    @Test
    void testTargetNoEncontrado() {
        assertEquals(-1, ExactSearch.indexOf("hola".toCharArray(), "mundo".toCharArray()));
    }

    @Test
    void testTargetMasLargoQueQuery() {
        assertEquals(-1, ExactSearch.indexOf("hi".toCharArray(), "hijo".toCharArray()));
    }

    @Test
    void testQueryVacia() {
        assertEquals(-1, ExactSearch.indexOf("".toCharArray(), "hola".toCharArray()));
    }

    @Test
    void testTargetVacio() {
        // Definición típica: buscar cadena vacía devuelve índice 0
        assertEquals(0, ExactSearch.indexOf("hola".toCharArray(), "".toCharArray()));
    }

    @Test
    void testAmbosVacios() {
        assertEquals(0, ExactSearch.indexOf("".toCharArray(), "".toCharArray()));
    }

    @Test
    void testCoincidenciaParcial() {
        // "hol" está al inicio, pero target = "hola" no aparece completo
        assertEquals(-1, ExactSearch.indexOf("hol".toCharArray(), "hola".toCharArray()));
    }

    @Test
    void testCoincidenciaRepetida() {
        // La primera ocurrencia de "aa" empieza en índice 0
        assertEquals(0, ExactSearch.indexOf("aaa".toCharArray(), "aa".toCharArray()));
    }
    
}

