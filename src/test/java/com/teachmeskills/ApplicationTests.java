package com.teachmeskills;

import com.teachmeskills.Service.OperationService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ApplicationTests {


    private final OperationService calculator = new OperationService();

    @Test
    public void testAdd_Success() {
        assertEquals(10, calculator.add(5.0, 5.0), "Add operation successful");
        assertEquals(1, calculator.add(9, -8), "Add operation successful" );
        assertEquals(-90, calculator.add(-80, -10), "Add operation successful" );
    }

    @Test
    public void testSubtract_Success() {
        assertEquals(1000, calculator.subtract(2000, 1000),"Subtract operation successful");
        assertNotEquals(0.1, calculator.subtract(0.3, 0.2),  "Subtract operation failed" );
        assertEquals(0, calculator.subtract(1, 1),"Subtract operation successful");
    }

    @Test
    public void testMultiply() {
        assertEquals(0.0, calculator.multiply(5, 0), "Multiply operation successful");
        assertEquals(-10.0, calculator.multiply(-5, 2),  "Multiply operation successful" );
        assertEquals(15.0, calculator.multiply(-5, -3), "Multiply operation successful" );
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(4, 2), "Divide operation successful" );
        assertEquals(-3.0, calculator.divide(-9, 3), "Divide operation successful");
        assertEquals(-2.0, calculator.divide(4, -2), "Divide operation successful" );

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

}
