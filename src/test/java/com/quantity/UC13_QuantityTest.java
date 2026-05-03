package com.quantity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UC13_QuantityTest {

    @Test
    void testAdd() {
        UC13_Quantity<LengthUnit> q1 =
                new UC13_Quantity<>(1, LengthUnit.FEET);
        UC13_Quantity<LengthUnit> q2 =
                new UC13_Quantity<>(12, LengthUnit.INCH);

        assertEquals(2.0, q1.add(q2).getValue());
    }

    @Test
    void testSubtract() {
        UC13_Quantity<LengthUnit> q1 =
                new UC13_Quantity<>(10, LengthUnit.FEET);
        UC13_Quantity<LengthUnit> q2 =
                new UC13_Quantity<>(6, LengthUnit.INCH);

        assertEquals(9.5, q1.subtract(q2).getValue());
    }

    @Test
    void testDivide() {
        UC13_Quantity<WeightUnit> q1 =
                new UC13_Quantity<>(10, WeightUnit.KILOGRAM);
        UC13_Quantity<WeightUnit> q2 =
                new UC13_Quantity<>(5, WeightUnit.KILOGRAM);

        assertEquals(2.0, q1.divide(q2));
    }

    @Test
    void testConversion() {
        UC13_Quantity<VolumeUnit> q =
                new UC13_Quantity<>(1, VolumeUnit.LITRE);

        assertEquals(1000.0,
                q.convertTo(VolumeUnit.MILLILITRE).getValue());
    }
}