package com.visualg.util;

import lombok.Value;

@Value
public class Pair<I, J> {
    public I first;
    public J second;

    public Pair(I first, J second) {
        this.first = first;
        this.second = second;
    }
}
