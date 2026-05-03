package com.quantity;

public class UC7_QuantityMeasurementApp {

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

    public static class Quantity {
        private final double value;
        private final Unit unit;

        public Quantity(double value, Unit unit) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid value");
            }
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public Unit getUnit() {
            return unit;
        }

        // 🔥 UC7 ADD METHOD (target unit specified)
        public Quantity add(Quantity other, Unit targetUnit) {

            if (other == null) {
                throw new IllegalArgumentException("Other quantity is null");
            }

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit is null");
            }

            // convert both → feet
            double thisInFeet = this.unit.toFeet(this.value);
            double otherInFeet = other.unit.toFeet(other.value);

            // add
            double sumInFeet = thisInFeet + otherInFeet;

            // convert → target unit
            double result = targetUnit.fromFeet(sumInFeet);

            return new Quantity(result, targetUnit);
        }
    }
}