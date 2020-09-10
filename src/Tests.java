import org.junit.Test;
import java.io.File;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    du t1 = new du(true, true, true);
    du t2 = new du(false, true, false);
    du t3 = new du(true, false, true);
    @Test
    public void getFlagH() {
        assertTrue(t1.getFlagH());
        assertTrue(t3.getFlagH());
    }
    @Test
    public void getFlagC() {
        assertTrue(t1.getFlagC());
        assertTrue(t2.getFlagC());
    }
    @Test
    public void getFlagSi() {
        assertTrue(t1.getFlagSi());
        assertTrue(t3.getFlagSi());
    }
    @Test
    public void GetHumanFormatSizeAllFlags() {
      ArrayList<String> test = new ArrayList<>();
      test.add("[src\\panda\\panda1.webp] 192.158 Kb");
      File tested = new File("src/panda/panda1.webp");
      String test1 = "Sum = 192 Kb";
      assertEquals(test, t1.GetHumanFormatSize(tested));
      assertEquals(t1.prSum(), test1);
    }
    @Test
    public void findLengthAllFlag() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(192158L);
        File tested = new File("src/panda/panda1.webp");
        assertEquals(t1.findLength(tested), test2);
    }
    @Test
    public void falseGetFlagH() {
        assertFalse(t2.getFlagH());
    }

    @Test
    public void falseGetFlagC() {
        assertFalse(t3.getFlagC());
    }

    @Test
    public void FalseGetFlagSi() {
        assertFalse(t2.getFlagSi());
    }

    @Test
    public void getHumanFormattedSize1CFlag() {
        ArrayList<String> test = new ArrayList<>();
        test.add("[src\\panda\\panda1.webp] 192158 b");
        File tested = new File("src/panda/panda1.webp");
        String test3 = "Sum = 187";
        assertEquals(t2.GetHumanFormatSize(tested), test);
        assertEquals(t2.prSum(), test3);

    }

    @Test
    public void findLength1CFlag() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(192158L);
        File tested = new File("src/panda/panda1.webp");
        assertEquals(t2.findLength(tested), test2);
    }

    @Test
    public void getHumanFormattedSize2CFlag() {
        ArrayList<String> test = new ArrayList<>();
        test.add("[src\\panda\\panda2.jpg] 159.976 Kb");
        File tested = new File("src/panda/panda2.jpg");
        String test3 = "Sum = 159 Kb";
        assertEquals(t3.GetHumanFormatSize(tested), test);
        assertEquals(t3.prSum(), test3);

    }

    @Test
    public void findLength2CFlag() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(159976L);
        File tested = new File("src/panda/panda2.jpg");
        assertEquals(t3.findLength(tested), test2);
    }

    @Test
    public void getHumanFormattedSize2CFlagPanda() {
        ArrayList<String> test = new ArrayList<>();
        test.add("[src\\panda] 352.134 Kb");
        File tested = new File("src/panda");
        String test3 = "Sum = 352 Kb";
        assertEquals(t3.GetHumanFormatSize(tested), test);
        assertEquals(t3.prSum(), test3);

    }

    @Test
    public void findLength2CFlagPanda() {
        ArrayList<Long> test2 = new ArrayList<>();
        test2.add(352134L);
        File tested = new File("src/panda");
        assertEquals(t3.findLength(tested), test2);
    }
}
