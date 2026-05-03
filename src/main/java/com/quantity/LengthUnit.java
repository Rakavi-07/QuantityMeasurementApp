package com.quantity;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(1.0 / 30.48);

    private final double toFeet;

    LengthUnit(double toFeet) {
        this.toFeet = toFeet;
    }

    @Override
    public double toBase(double value) {
        return value * toFeet;
    }

    @Override
    public double fromBase(double value) {
        return value / toFeet;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}