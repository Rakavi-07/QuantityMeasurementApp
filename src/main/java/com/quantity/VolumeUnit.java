package com.quantity;

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),     // 1 mL = 0.001 L
    GALLON(3.78541);       // 1 gal ≈ 3.78541 L

    private final double toLitre;

    VolumeUnit(double toLitre) {
        this.toLitre = toLitre;
    }

    @Override
    public double toBase(double value) {
        return value * toLitre;
    }

    @Override
    public double fromBase(double value) {
        return value / toLitre;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}