package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11_QuantityVolumeTest {

    @Test
    void testEquality_LitreAndMilliLitre() {
        UC10_Quantity<VolumeUnit> q1 =
                new UC10_Quantity<>(1, VolumeUnit.LITRE);

        UC10_Quantity<VolumeUnit> q2 =
                new UC10_Quantity<>(1000, VolumeUnit.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_LitreAndGallon() {
        UC10_Quantity<VolumeUnit> q1 =
                new UC10_Quantity<>(3.78541, VolumeUnit.LITRE);

        UC10_Quantity<VolumeUnit> q2 =
                new UC10_Quantity<>(1, VolumeUnit.GALLON);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testConversion() {
        UC10_Quantity<VolumeUnit> q =
                new UC10_Quantity<>(1, VolumeUnit.LITRE);

        UC10_Quantity<VolumeUnit> result =
                q.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    void testAddition_DefaultUnit() {
        UC10_Quantity<VolumeUnit> q1 =
                new UC10_Quantity<>(1, VolumeUnit.LITRE);

        UC10_Quantity<VolumeUnit> q2 =
                new UC10_Quantity<>(500, VolumeUnit.MILLILITRE);

        UC10_Quantity<VolumeUnit> result = q1.add(q2);

        assertEquals(1.5, result.getValue());
    }

    @Test
    void testAddition_TargetUnit() {
        UC10_Quantity<VolumeUnit> q1 =
                new UC10_Quantity<>(1, VolumeUnit.LITRE);

        UC10_Quantity<VolumeUnit> q2 =
                new UC10_Quantity<>(500, VolumeUnit.MILLILITRE);

        UC10_Quantity<VolumeUnit> result =
                q1.add(q2, VolumeUnit.MILLILITRE);

        assertEquals(1500.0, result.getValue());
    }

    @Test
    void testCrossCategoryComparison() {
        UC10_Quantity<VolumeUnit> volume =
                new UC10_Quantity<>(1, VolumeUnit.LITRE);

        UC10_Quantity<LengthUnit> length =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        assertFalse(volume.equals(length));
    }
}