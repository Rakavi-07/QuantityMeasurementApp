package com.quantity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.quantity.UC9_QuantityWeightApp.QuantityWeight;

public class UC9_QuantityWeightAppTest {

    @Test
    void testEquality_KgAndGram() {
        QuantityWeight q1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_KgAndPound() {
        QuantityWeight q1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(2.20462, WeightUnit.POUND);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testConversion() {
        QuantityWeight q = new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight result = q.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    void testAddition_DefaultUnit() {
        QuantityWeight q1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(500, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(1.5, result.getValue());
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    void testAddition_TargetUnit() {
        QuantityWeight q1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(500, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2, WeightUnit.GRAM);

        assertEquals(1500.0, result.getValue());
    }

    @Test
    void testInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM));
    }
}