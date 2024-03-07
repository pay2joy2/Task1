import org.example.OwnArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OwnArrayListStringTest {

    private OwnArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new OwnArrayList<>();
    }


    @Test
    void testAdd() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        assertEquals(Arrays.asList("A", "B","C"), list.showAsList());
    }


    @Test
    void testAddAtIndex() {
        list.add("A");
        list.add("B");
        list.add(1, "Z");

        assertEquals(3, list.size());
        assertEquals(Arrays.asList("A", "Z", "B"), list.showAsList());
    }

    @Test
    void testAddAtWrongIndex() {
        list.add("A");
        list.add("B");
        assertThrows(IndexOutOfBoundsException.class, ()-> list.add(5, "Y"));
    }

    @Test
    void testShowAsList() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(Arrays.asList("A","B","C"), list.showAsList());
    }

    @Test
    void testGet() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.get(1));
    }
    @Test
    void testGetAtWrongIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertThrows(IndexOutOfBoundsException.class, ()-> list.add(5, "Y"));
    }

    @Test
    void testRemove() {
        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(Arrays.asList("A", "C"), list.showAsList());
    }
    @Test
    void testRemoveAtWrongIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(5));
    }

    @Test
    void testClear() {
        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();

        assertEquals(0, list.size());
        assertEquals(List.of(), list.showAsList());
    }

    @Test
    void testSort() {
        list.add("C");
        list.add("B");
        list.add("A");
        list.sort(Comparator.naturalOrder());
        assertEquals(Arrays.asList("A","B","C"), list.showAsList());
    }
}
