package com.quantity;

import java.util.Objects;

public class UC10_Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public UC10_Quantity(double value, U unit) {
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

    public U getUnit() {
        return unit;
    }

    // 🔹 EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UC10_Quantity<?> other)) return false;

        // prevent cross-category comparison
        if (this.unit.getClass() != other.unit.getClass()) return false;

        double thisBase = unit.toBase(value);
        double otherBase = ((IMeasurable) other.unit).toBase(other.value);

        return Double.compare(thisBase, otherBase) == 0;
    }

    // 🔹 CONVERT
    public UC10_Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit is null");
        }

        double base = unit.toBase(value);
        double result = targetUnit.fromBase(base);

        return new UC10_Quantity<>(round(result), targetUnit);
    }

    // 🔹 ADD (same unit as first)
    public UC10_Quantity<U> add(UC10_Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Other is null");
        }

        double sumBase =
                unit.toBase(value) +
                other.unit.toBase(other.value);

        double result = unit.fromBase(sumBase);

        return new UC10_Quantity<>(round(result), unit);
    }

    // 🔹 ADD (target unit)
    public UC10_Quantity<U> add(UC10_Quantity<U> other, U targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase =
                unit.toBase(value) +
                other.unit.toBase(other.value);

        double result = targetUnit.fromBase(sumBase);

        return new UC10_Quantity<>(round(result), targetUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.getClass(), unit.toBase(value));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}