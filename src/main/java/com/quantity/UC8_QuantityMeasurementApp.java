package com.quantity;

public class UC8_QuantityMeasurementApp {

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
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

        public LengthUnit getUnit() {
            return unit;
        }

        // equals (UC3+ logic)
        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisBase = this.unit.toBase(this.value);
            double otherBase = other.unit.toBase(other.value);

            return Double.compare(thisBase, otherBase) == 0;
        }

        // UC6 style add
        public Quantity add(Quantity other) {

            if (other == null) {
                throw new IllegalArgumentException("Other is null");
            }

            double sumBase =
                    this.unit.toBase(this.value) +
                    other.unit.toBase(other.value);

            double result = this.unit.fromBase(sumBase);

            return new Quantity(result, this.unit);
        }

        // UC7 style add with target
        public Quantity add(Quantity other, LengthUnit targetUnit) {

            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double sumBase =
                    this.unit.toBase(this.value) +
                    other.unit.toBase(other.value);

            double result = targetUnit.fromBase(sumBase);

            return new Quantity(result, targetUnit);
        }
    }
}