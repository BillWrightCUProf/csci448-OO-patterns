package ooconcepts.encapsulation.list;

import ooconcepts.encapsulation.list.solution.MapList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapListTest {
    MapList list;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        list = new MapList();
    }
    
    @Test
    void testEmptyList() {
        assertEquals(0, list.size());
    }

    @Test
    void testAddAndSize() {
        list.add("Hello");
        assertEquals(1, list.size());
        list.add("World");
        assertEquals(2, list.size());
    }

    @Test
    void testAddAndGet() {
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test
    void testRemove() {
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.remove(0));
        assertEquals("World", list.get(0));  // After removal, "World" should be at index 0
    }

    @Test
    void testSizeAfterRemove() {
        list.add("Hello");
        list.add("World");
        assertEquals(2, list.size());
        list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveFromMiddle() {
        list.add("Hello");
        list.add("My");
        list.add("World");
        list.remove(1);
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testClear() {
        list.add("Hello");
        list.add("World");
        list.clear();
        assertEquals(0, list.size());
    }

}