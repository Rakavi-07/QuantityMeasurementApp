package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC12_QuantityTest {

    @Test
    void testSubtraction_DefaultUnit_Length() {
        UC10_Quantity<LengthUnit> q1 =
                new UC10_Quantity<>(10, LengthUnit.FEET);

        UC10_Quantity<LengthUnit> q2 =
                new UC10_Quantity<>(6, LengthUnit.INCH); // 0.5 ft

        UC10_Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(9.5, result.getValue());
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testSubtraction_TargetUnit_Volume() {
        UC10_Quantity<VolumeUnit> q1 =
                new UC10_Quantity<>(5, VolumeUnit.LITRE);

        UC10_Quantity<VolumeUnit> q2 =
                new UC10_Quantity<>(2000, VolumeUnit.MILLILITRE); // 2 L

        UC10_Quantity<VolumeUnit> result =
                q1.subtract(q2, VolumeUnit.MILLILITRE);

        assertEquals(3000.0, result.getValue());
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testSubtraction_NegativeResult() {
        UC10_Quantity<LengthUnit> q1 =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        UC10_Quantity<LengthUnit> q2 =
                new UC10_Quantity<>(24, LengthUnit.INCH); // 2 ft

        UC10_Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(-1.0, result.getValue());
    }

    @Test
    void testDivision_Weight() {
        UC10_Quantity<WeightUnit> q1 =
                new UC10_Quantity<>(10, WeightUnit.KILOGRAM);

        UC10_Quantity<WeightUnit> q2 =
                new UC10_Quantity<>(5, WeightUnit.KILOGRAM);

        assertEquals(2.0, q1.divide(q2));
    }

    @Test
    void testDivision_CrossUnits() {
        UC10_Quantity<LengthUnit> q1 =
                new UC10_Quantity<>(12, LengthUnit.INCH);

        UC10_Quantity<LengthUnit> q2 =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        assertEquals(1.0, q1.divide(q2));
    }

    @Test
    void testDivision_ByZero() {
        UC10_Quantity<WeightUnit> q1 =
                new UC10_Quantity<>(1, WeightUnit.KILOGRAM);

        UC10_Quantity<WeightUnit> q2 =
                new UC10_Quantity<>(0, WeightUnit.KILOGRAM);

        assertThrows(ArithmeticException.class, () -> q1.divide(q2));
    }

    @Test
    void testCrossCategoryBlocked() {
        UC10_Quantity<LengthUnit> l =
                new UC10_Quantity<>(1, LengthUnit.FEET);

        UC10_Quantity<WeightUnit> w =
                new UC10_Quantity<>(1, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> l.subtract((UC10_Quantity) w));
    }
}