import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {
    private static final double DELTA = 1e-6;

    @Test
    public void testCalcTax_BelowThreshold() {
        calc calculator = new calc();
        assertEquals(0, calculator.calcTax(1500), DELTA);
    }

    @Test
    public void testCalcTax_FirstBracket() {
        calc calculator = new calc();
        // 1600起征点，2100工资 → 500应税
        assertEquals(25.0, calculator.calcTax(2100), DELTA);
    }

    @Test
    public void testCalcTax_SecondBracketEdge() {
        calc calculator = new calc();
        // 1600+500+1500=3600工资
        assertEquals(500*0.05 + 1500*0.10, calculator.calcTax(3600), DELTA);
    }

    @Test
    public void testCalcTax_TopBracket() {
        calc calculator = new calc();
        // 1600+20000+1000=22600工资
        double expected = 500*0.05 + (2000-500)*0.10 + (5000-2000)*0.15 + 
                        (20000-5000)*0.20 + 1000*0.25;
        assertEquals(expected, calculator.calcTax(22600), DELTA);
    }

    @Test
    public void testSetTaxRate() {
        calc calculator = new calc();
        calculator.setTaxRate(1, 0.10);
        assertEquals(0.10, calculator.getTaxRate(1), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaxRate() {
        calc calculator = new calc();
        calculator.setTaxRate(1, 1.5);
    }

    // 添加获取税率的方法便于测试
    private double getTaxRate(calc c, int level) {
        return c.getTaxRate(level);
    }
}