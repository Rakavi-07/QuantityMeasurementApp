package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.quantity.UC3_QuantityMeasurementApp.Quantity;
import com.quantity.UC3_QuantityMeasurementApp.Unit;

public class UC3_QuantityMeasurementAppTest {

    @Test
    void testSameUnit_SameValue() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(1.0, Unit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testSameUnit_DifferentValue() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(2.0, Unit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testDifferentUnit_EqualValue() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(12.0, Unit.INCH);

        assertTrue(q1.equals(q2)); // conversion happens
    }

    @Test
    void testDifferentUnit_NotEqual() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(10.0, Unit.INCH);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void testSameReference() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);

        assertTrue(q1.equals(q1));
    }
}