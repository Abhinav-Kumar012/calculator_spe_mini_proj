package com.spe.calc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class calculatorTest {
    private final calcfxn calc = new calcfxn();
    private final double Epsilon = 0.00001D;

    @Test
    void factTestNormal(){
        assertAll(
            () -> assertEquals(120L, calc.factorial(5)),
            () -> assertEquals(1L, calc.factorial(0)),
            () -> assertEquals(1L, calc.factorial(1))
        );
    }

    @Test
    void factTestExcept(){
        assertAll(() -> {
                Exception exc = assertThrows(ArithmeticException.class, () -> calc.factorial(-1));
                assertEquals("factorial of negative number is not defined", exc.getMessage());
            },
            () -> {
                Exception exc = assertThrows(ArithmeticException.class, () -> calc.factorial(120));
                assertEquals("long overflow", exc.getMessage());
            }
        );
    }

    @Test
    void sqrtTestNormal(){
        assertAll(
            () -> assertEquals(2.0D,calc.sqrt(4.0D),Epsilon),
            () -> assertEquals(1.732050D,calc.sqrt(3.0D),Epsilon),
            () -> assertEquals(0.0D, calc.sqrt(0),Epsilon),
            () -> assertEquals(1.0D, calc.sqrt(1),Epsilon)
        );
    }

    @Test
    void sqrtTestExcept(){
        Exception exc = assertThrows(ArithmeticException.class, () -> calc.sqrt(-1.0D));
        assertEquals("square root of negative number is imaginary", exc.getMessage());
    }

    @Test
    void logTestNormal(){
        assertAll(
            () -> assertEquals(0.693147D,calc.log(2.0D),Epsilon),
            () -> assertEquals(2.0D,calc.log(7.38905609893D),Epsilon),
            () -> assertEquals(0.0D,calc.log(1.0D),Epsilon),
            () -> assertEquals(Double.NEGATIVE_INFINITY,calc.log(0.0D),Epsilon)
        );
    }

    @Test
    void logTestExcept(){
        Exception exc = assertThrows(ArithmeticException.class, () -> calc.log(-1.0D));
        assertEquals("log of negative number is not defined", exc.getMessage());
    }

    @Test
    void powerTest(){
        assertAll(
            () -> assertEquals(4.0D,calc.power(2.0D, 2.0D),Epsilon),
            () -> assertEquals(0.0332918924D,calc.power(3.9D, -2.5D),Epsilon),
            () -> assertEquals(Double.NaN,calc.power(-0.4D, 58.34D),Epsilon),
            () -> assertEquals(0.0D,calc.power(0.4D, 58.0D),Epsilon),
            () -> assertEquals(0.11890606D,calc.power(-2.9D, -2.0D),Epsilon),
            () -> assertEquals(Double.POSITIVE_INFINITY,calc.power(18934.0D, 209474.0D),Epsilon),
            () -> assertEquals(Double.NEGATIVE_INFINITY,calc.power(-18934.0D, 209475.0D),Epsilon),
            () -> assertEquals(Double.POSITIVE_INFINITY,calc.power(-18934.0D, 209474.0D),Epsilon)
        );
    }
}
