package com.quantity;

public interface IMeasurable {

    double toBase(double value);

    double fromBase(double value);

    String getUnitName();
}