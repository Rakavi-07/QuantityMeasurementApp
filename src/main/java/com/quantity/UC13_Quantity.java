package com.quantity;

import java.util.Objects;

public class UC13_Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public UC13_Quantity(double value, U unit) {
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

    // 🔹 ENUM FOR OPERATIONS
    private enum Operation {
        ADD, SUBTRACT, DIVIDE
    }

    // 🔹 CENTRALIZED HELPER
    private double performOperation(UC13_Quantity<U> other, Operation op) {

        if (other == null) {
            throw new IllegalArgumentException("Other is null");
        }

        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Different categories");
        }

        double thisBase = unit.toBase(value);
        double otherBase = other.unit.toBase(other.value);

        return switch (op) {
            case ADD -> thisBase + otherBase;
            case SUBTRACT -> thisBase - otherBase;
            case DIVIDE -> {
                if (otherBase == 0.0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield thisBase / otherBase;
            }
        };
    }

    // 🔹 EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UC13_Quantity<?> other)) return false;

        if (this.unit.getClass() != other.unit.getClass()) return false;

        double thisBase = unit.toBase(value);
        double otherBase = ((IMeasurable) other.unit).toBase(other.value);

        return Double.compare(thisBase, otherBase) == 0;
    }

    // 🔹 CONVERT
    public UC13_Quantity<U> convertTo(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit is null");
        }

        double base = unit.toBase(value);
        double result = targetUnit.fromBase(base);

        return new UC13_Quantity<>(round(result), targetUnit);
    }

    // 🔹 ADD
    public UC13_Quantity<U> add(UC13_Quantity<U> other) {
        double base = performOperation(other, Operation.ADD);
        return new UC13_Quantity<>(round(unit.fromBase(base)), unit);
    }

    public UC13_Quantity<U> add(UC13_Quantity<U> other, U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit is null");
        }

        double base = performOperation(other, Operation.ADD);
        return new UC13_Quantity<>(round(targetUnit.fromBase(base)), targetUnit);
    }

    // 🔹 SUBTRACT
    public UC13_Quantity<U> subtract(UC13_Quantity<U> other) {
        double base = performOperation(other, Operation.SUBTRACT);
        return new UC13_Quantity<>(round(unit.fromBase(base)), unit);
    }

    public UC13_Quantity<U> subtract(UC13_Quantity<U> other, U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit is null");
        }

        double base = performOperation(other, Operation.SUBTRACT);
        return new UC13_Quantity<>(round(targetUnit.fromBase(base)), targetUnit);
    }

    // 🔹 DIVIDE
    public double divide(UC13_Quantity<U> other) {
        return round(performOperation(other, Operation.DIVIDE));
    }

    // 🔹 ROUND
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