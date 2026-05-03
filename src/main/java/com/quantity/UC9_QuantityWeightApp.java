package com.quantity;

public class UC9_QuantityWeightApp {

    public static class QuantityWeight {
        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {
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

        public WeightUnit getUnit() {
            return unit;
        }

        // 🔹 Equality (normalize to kg)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityWeight other = (QuantityWeight) obj;

            double thisKg = this.unit.toBase(this.value);
            double otherKg = other.unit.toBase(other.value);

            return Double.compare(thisKg, otherKg) == 0;
        }

        // 🔹 Convert to target unit
        public QuantityWeight convertTo(WeightUnit target) {
            if (target == null) {
                throw new IllegalArgumentException("Target unit is null");
            }

            double baseKg = this.unit.toBase(this.value);
            double converted = target.fromBase(baseKg);

            return new QuantityWeight(converted, target);
        }

        // 🔹 Add → result in first operand's unit (UC6 style)
        public QuantityWeight add(QuantityWeight other) {
            if (other == null) {
                throw new IllegalArgumentException("Other is null");
            }

            double sumKg =
                    this.unit.toBase(this.value) +
                    other.unit.toBase(other.value);

            double result = this.unit.fromBase(sumKg);

            return new QuantityWeight(result, this.unit);
        }

        // 🔹 Add → explicit target unit (UC7 style)
        public QuantityWeight add(QuantityWeight other, WeightUnit target) {
            if (other == null || target == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double sumKg =
                    this.unit.toBase(this.value) +
                    other.unit.toBase(other.value);

            double result = target.fromBase(sumKg);

            return new QuantityWeight(result, target);
        }
    }
}