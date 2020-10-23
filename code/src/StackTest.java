import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testEmpty() {
        assertEquals(0, new Stack<>().size());
    }

    @Test
    public void testEmptyConstructor() {
        assertEquals(0, new Stack<>().size());
    }

    @Test
    public void testArrayListConstructor() {
        ArrayList<Integer> testAList = new ArrayList<>();
        testAList.add(2);
        testAList.add(2);
        testAList.add(8);

        assertEquals(3, new Stack<>(testAList).size());
    }

}
