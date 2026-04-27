package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.quantity.UC4_QuantityMeasurementApp.Quantity;
import com.quantity.UC4_QuantityMeasurementApp.Unit;

public class UC4_QuantityMeasurementAppTest {

    @Test
    void testFeetAndYard_Equal() {
        Quantity q1 = new Quantity(3.0, Unit.FEET);
        Quantity q2 = new Quantity(1.0, Unit.YARD);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetAndInch_Equal() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(12.0, Unit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testInchAndCm_Equal() {
        Quantity q1 = new Quantity(1.0, Unit.INCH);
        Quantity q2 = new Quantity(2.54, Unit.CM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testDifferentUnits_NotEqual() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);
        Quantity q2 = new Quantity(10.0, Unit.INCH);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testSameUnit_SameValue() {
        Quantity q1 = new Quantity(5.0, Unit.CM);
        Quantity q2 = new Quantity(5.0, Unit.CM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        Quantity q1 = new Quantity(1.0, Unit.FEET);

        assertFalse(q1.equals(null));
    }
}