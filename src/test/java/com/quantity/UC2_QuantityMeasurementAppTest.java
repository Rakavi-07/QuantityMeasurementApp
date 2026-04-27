package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.quantity.UC2_QuantityMeasurementApp.Feet;
import com.quantity.UC2_QuantityMeasurementApp.Inch;

public class UC2_QuantityMeasurementAppTest {

    // -------- FEET --------

    @Test
    void testFeet_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testFeet_DifferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    // -------- INCH --------

    @Test
    void testInch_SameValue() {
        Inch i1 = new Inch(1.0);
        Inch i2 = new Inch(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    void testInch_DifferentValue() {
        Inch i1 = new Inch(1.0);
        Inch i2 = new Inch(2.0);

        assertFalse(i1.equals(i2));
    }

    @Test
    void testInch_NullComparison() {
        Inch i1 = new Inch(1.0);

        assertFalse(i1.equals(null));
    }

    @Test
    void testInch_SameReference() {
        Inch i1 = new Inch(1.0);

        assertTrue(i1.equals(i1));
    }
}