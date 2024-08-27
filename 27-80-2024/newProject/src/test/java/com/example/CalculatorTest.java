package test.java.com.example;



import org.junit.Test;


import main.java.com.example.Calculator;


/**
 * CalculatorTest
 */
public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator calci = new Calculator();
        int sum = calci.add(5, 2);
        assertEquals(7,sum);
    }

    @Test
    public void testSub(){
        Calculator calci = new Calculator();
        int res = calci.sub(5, 2);
        assertEquals(3,res);
    }
}

