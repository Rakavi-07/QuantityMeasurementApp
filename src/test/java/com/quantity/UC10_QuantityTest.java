package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC10_QuantityTest {

    @Test
    void testLengthEquality() {
        UC10_Quantity<LengthUnit> q1 =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        UC10_Quantity<LengthUnit> q2 =
                new UC10_Quantity<>(12, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testWeightEquality() {
        UC10_Quantity<WeightUnit> q1 =
                new UC10_Quantity<>(1, WeightUnit.KILOGRAM);

        UC10_Quantity<WeightUnit> q2 =
                new UC10_Quantity<>(1000, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testAddition_Length() {
        UC10_Quantity<LengthUnit> q1 =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        UC10_Quantity<LengthUnit> q2 =
                new UC10_Quantity<>(12, LengthUnit.INCH);

        assertEquals(2.0, q1.add(q2).getValue());
    }

    @Test
    void testConversion_Weight() {
        UC10_Quantity<WeightUnit> q =
                new UC10_Quantity<>(1, WeightUnit.KILOGRAM);

        assertEquals(1000.0,
                q.convertTo(WeightUnit.GRAM).getValue());
    }

    @Test
    void testCrossCategoryComparison() {
        UC10_Quantity<LengthUnit> length =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        UC10_Quantity<WeightUnit> weight =
                new UC10_Quantity<>(1, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }
}