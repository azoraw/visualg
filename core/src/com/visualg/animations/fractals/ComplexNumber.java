package com.visualg.animations.fractals;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ComplexNumber {

    double re;
    double im;

    public ComplexNumber move(double re, double im) {
        return new ComplexNumber(this.re + re, this.im + im);
    }

}
