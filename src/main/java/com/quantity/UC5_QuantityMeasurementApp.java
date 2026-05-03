package com.quantity;

public class UC5_QuantityMeasurementApp {

    // Units with conversion to base (feet)
    public enum Unit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(1.0 / 30.48);

        private final double toFeet;

        Unit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double value) {
            return value / toFeet;
        }
    }

    // Conversion method (STATIC API)
    public static double convert(double value, Unit source, Unit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid number");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        // Step 1 → convert to base (feet)
        double valueInFeet = source.toFeet(value);

        // Step 2 → convert to target
        return target.fromFeet(valueInFeet);
    }
}