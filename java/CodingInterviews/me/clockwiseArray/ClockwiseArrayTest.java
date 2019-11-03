package clockwiseArray;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClockwiseArrayTest {

	@Test
	public void test1x1() {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][] {
                { "A" }
        };

        assertEquals("A", cp.doPrint(arr));
    }
}
