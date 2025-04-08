package com.mycompany;

import java.util.Iterator;
import java.util.NoSuchElementException;

class PrimeIterator implements Iterator<Integer> {
    private int nextPrime;

    public PrimeIterator() {
        nextPrime = 1; // Start checking for primes from 2
    }

    @Override
    public boolean hasNext() {
        return true; // There are infinitely many prime numbers
    }

    @Override
    public Integer next() {
        nextPrime++;
        while (!isPrime(nextPrime)) {
            nextPrime++;
        }
        return nextPrime;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeIterator primeIterator = new PrimeIterator();
        for (int i = 0; i < 10; i++) {
            System.out.println(primeIterator.next());
        }
    }
}
