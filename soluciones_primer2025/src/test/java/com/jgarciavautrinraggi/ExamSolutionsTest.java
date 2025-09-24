package com.jgarciavautrinraggi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ExamSolutionsTest {

    @Test
    public void testBoundedQueueBasic() {
        BoundedQueue<String> queue = new BoundedQueue<>(3);
        // Not throwing exception
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
        assertFalse(queue.isFull(), "Queue should not be full initially");
        queue.enqueue("A");
        assertFalse(queue.isEmpty(), "Queue should not be empty after adding element");
        queue.enqueue("B");
        queue.enqueue("C");
        assertTrue(queue.isFull(), "Queue should be full after adding 3 elements");
        String element = queue.dequeue();
        assertEquals("A", element, "First element should be A");
        assertFalse(queue.isFull(), "Queue should not be full after removing element");
    }

    @Test
    public void testSingleLinkedListReverseFirst() {
        SingleLinkedList list = new SingleLinkedList();
        // Test with empty list
        assertDoesNotThrow(() -> list.reverseFirst(3), "Should not throw exception with empty list");
        list.addFirst(10);
        list.addFirst(28);
        list.addFirst(30);
        list.addFirst(12);
        list.addFirst(50);
        assertDoesNotThrow(() -> list.reverseFirst(3), "reverseFirst should execute without errors");
        SingleLinkedList.mainA(null);
        SingleLinkedList.mainB(null);
        SingleLinkedList.mainC(null);
        SingleLinkedList.mainD(null);
    }

    @Test
    public void testEdgeCases() {
        // Test SingleLinkedList with negative number
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(1);
        assertDoesNotThrow(() -> list.reverseFirst(-1), "Should not throw exception with negative number");
        BoundedQueue<Integer> smallQueue = new BoundedQueue<>(1);
        smallQueue.enqueue(42);
        assertTrue(smallQueue.isFull(), "Small queue should be full");
        Integer value = smallQueue.dequeue();
        assertEquals(Integer.valueOf(42), value, "Value should be 42");
        assertTrue(smallQueue.isEmpty(), "Queue should be empty after dequeue");
    }

    @Test
    public void testTurnosExpressKSimple() {
        System.out.println("== Caso 1 ==");
        TurnosExpressK.atender(3,
                Arrays.asList("A:A1","A:A2","A:A3","A:A4","S","A:A5","S","A:A6","S","S","A:A7","A:A8"
        ));
        System.out.println("== Caso 2 ==");
        TurnosExpressK.atender(2,
                Arrays.asList("S","A:P1","S","S","A:P2","A:P3","S","A:P4","S"
        ));
        System.out.println("== Caso 3 ==");
        TurnosExpressK.atender(2,
                Arrays.asList("A:X","A:Y","A:Z","A:W","S","A:K","A:L","A:M"
        ));
        System.out.println("== Caso 4 ==");
        TurnosExpressK.atender(3,
                Arrays.asList("A:P1","A:P2","A:P3","A:P4","S","A:P5","S","A:P6","S","S"
        ));
        System.out.println("== Caso 5 ==");
        TurnosExpressK.atender(2,
                Arrays.asList("S","S", "A:P1", "A:P2"
        ));
    }
}
