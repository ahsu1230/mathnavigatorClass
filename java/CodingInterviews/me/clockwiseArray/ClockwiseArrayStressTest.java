package clockwiseArray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaronhsu on 7/22/15.
 */
public class ClockwiseArrayStressTest {
    @Test
    public void test1x1() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A" }
        };
        assertEquals("A", cp.doPrint(arr));
    }

    @Test
    public void test2x2() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B" },
                { "D", "C" }
        };
        assertEquals("ABCD", cp.doPrint(arr));
    }

    @Test
    public void test3x3() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C" },
                { "H", "I", "D" },
                { "G", "F", "E" }
        };
        assertEquals("ABCDEFGHI", cp.doPrint(arr));
    }

    @Test
    public void test1x3() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C" }
        };
        assertEquals("ABC", cp.doPrint(arr));
    }

    @Test
    public void test3x1() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A",},
                { "B",},
                { "C",}
        };
        assertEquals("ABC", cp.doPrint(arr));
    }

    @Test
     public void test2x3() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C" },
                { "F", "E", "D" }
        };
        assertEquals("ABCDEF", cp.doPrint(arr));
    }

    @Test
    public void test3x2() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B" },
                { "F", "C" },
                { "E", "D" }
        };
        assertEquals("ABCDEF", cp.doPrint(arr));
    }

    @Test
    public void test3x4() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C", "D" },
                { "J", "K", "L", "E" },
                { "I", "H", "G", "F" },
        };
        assertEquals("ABCDEFGHIJKL", cp.doPrint(arr));
    }

    @Test
    public void test4x3() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C"},
                { "J", "K", "D"},
                { "I", "L", "E"},
                { "H", "G", "F"}
        };
        assertEquals("ABCDEFGHIJKL", cp.doPrint(arr));
    }

    @Test
    public void test4x4() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C", "D" },
                { "L", "M", "N", "E" },
                { "K", "P", "O", "F" },
                { "J", "I", "H", "G" }
        };
        assertEquals("ABCDEFGHIJKLMNOP", cp.doPrint(arr));
    }

    @Test
    public void test5x5() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A", "B", "C", "D", "E" },
                { "P", "Q", "R", "S", "F" },
                { "O", "X", "Y", "T", "G" },
                { "N", "W", "V", "U", "H" },
                { "M", "L", "K", "J", "I" },
        };
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXY", cp.doPrint(arr));
    }
}