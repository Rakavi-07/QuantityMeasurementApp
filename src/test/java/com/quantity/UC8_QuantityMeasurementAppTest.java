package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.quantity.UC8_QuantityMeasurementApp.Quantity;
import com.quantity.LengthUnit;

public class UC8_QuantityMeasurementAppTest {

    @Test
    void testEquality() {
        Quantity q1 = new Quantity(1, LengthUnit.FEET);
        Quantity q2 = new Quantity(12, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testAddition_DefaultUnit() {
        Quantity q1 = new Quantity(1, LengthUnit.FEET);
        Quantity q2 = new Quantity(12, LengthUnit.INCH);

        Quantity result = q1.add(q2);

        assertEquals(2.0, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_TargetUnit() {
        Quantity q1 = new Quantity(1, LengthUnit.FEET);
        Quantity q2 = new Quantity(12, LengthUnit.INCH);

        Quantity result = q1.add(q2, LengthUnit.YARD);

        assertEquals(0.6667, result.getValue(), 0.01);
    }

    @Test
    void testConversionEquality_CM() {
        Quantity q1 = new Quantity(2.54, LengthUnit.CM);
        Quantity q2 = new Quantity(1, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }
}