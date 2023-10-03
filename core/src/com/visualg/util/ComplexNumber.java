package com.visualg.util;

public record ComplexNumber(double re, double im) {

    public ComplexNumber move(double re, double im) {
        return new ComplexNumber(this.re + re, this.im + im);
    }

    public ComplexNumber withRe(double newRe) {
        return new ComplexNumber(newRe, this.im);
    }

    public ComplexNumber withIm(double newIm) {
        return new ComplexNumber(this.re, newIm);
    }
}
