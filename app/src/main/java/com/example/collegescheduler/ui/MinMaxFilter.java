package com.example.collegescheduler.ui;

import android.text.InputFilter;
import android.text.Spanned;

public class MinMaxFilter implements InputFilter {

    private int min, max;

    public MinMaxFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public MinMaxFilter(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        int input = Integer.parseInt(dest.toString() + source.toString());
        if (isInRange(min, max, input)) { return null; }
        return "";
    }

    private boolean isInRange(int min, int max, int input) {
        return (input <= max && input >= min && max >= min);
    }
}