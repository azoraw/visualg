package com.visualg.animations.spiral.ulam;

import java.util.Arrays;

import static com.visualg.animations.spiral.ulam.UlamSpiralAlg.SIDE_LENGTH;

public class Prime {

    private boolean[] primes;

    public Prime() {
        createPrimesBySieveOfEratosthenes();
    }

    public boolean isPrime(int n) {
        return primes[n];
    }

    private void createPrimesBySieveOfEratosthenes() {
        primes = new boolean[(SIDE_LENGTH) * (SIDE_LENGTH + 1) + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }


}