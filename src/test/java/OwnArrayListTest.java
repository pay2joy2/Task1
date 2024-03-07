import org.example.OwnArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OwnArrayListTest {

    private OwnArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new OwnArrayList<>();
    }

    @Test
    void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(Arrays.asList(1, 2, 3), list.showAsList());
    }

    @Test
    void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(1, 9);

        assertEquals(3, list.size());
        assertEquals(Arrays.asList(1, 9, 2), list.showAsList());
    }

    @Test
    void testShowAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Arrays.asList(1,2,3), list.showAsList());
    }

    @Test
    void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(2, list.get(1));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(Arrays.asList(1, 3), list.showAsList());
    }

    @Test
    void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertEquals(0, list.size());
        assertEquals(Arrays.asList(), list.showAsList());
    }

    @Test
    void testSort() {
        list.add(3);
        list.add(1);
        list.add(2);
        list.sort(Comparator.naturalOrder());
        assertEquals(Arrays.asList(1, 2, 3), list.showAsList());
    }
}
