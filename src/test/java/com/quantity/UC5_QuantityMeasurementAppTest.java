package com.quantity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.quantity.UC5_QuantityMeasurementApp.Unit;
import static com.quantity.UC5_QuantityMeasurementApp.convert;

public class UC5_QuantityMeasurementAppTest {

    @Test
    void testFeetToInch() {
        assertEquals(12.0, convert(1, Unit.FEET, Unit.INCH));
    }

    @Test
    void testYardToInch() {
        assertEquals(36.0, convert(1, Unit.YARD, Unit.INCH));
    }

    @Test
    void testCmToFeet() {
        assertEquals(1.0, convert(30.48, Unit.CM, Unit.FEET), 0.0001);
    }

    @Test
    void testInchToFeet() {
        assertEquals(1.0, convert(12, Unit.INCH, Unit.FEET));
    }

    @Test
    void testSameUnit() {
        assertEquals(5.0, convert(5, Unit.FEET, Unit.FEET));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                convert(Double.NaN, Unit.FEET, Unit.INCH)
        );
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                convert(1, null, Unit.FEET)
        );
    }
}