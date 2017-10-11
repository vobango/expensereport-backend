package com.reach_u.expensereport.model;

public enum Currency {
    EEK (0.06),
    EUR (1.00),
    SEK (0.11),
    USD (0.89),
    LVL (1.00),
    TRY (0.31),
    LTL (1.00),
    CHF (0.92),
    RUB (0.01),
    GBP (1.27);

    private double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}