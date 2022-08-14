package com.visualg.util;

import lombok.Data;

@Data
public class MutablePair<I, J> {
    public I first;
    public J second;

    public MutablePair(I first, J second) {
        this.first = first;
        this.second = second;
    }
}
