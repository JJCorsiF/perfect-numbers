package com.jjcorsif.perfectNumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PositiveNumber {

    private final BigInteger value;

    PositiveNumber(BigInteger value) throws NotAPositiveNumberException {
        if (isNotPositive(value)) {
            throw new NotAPositiveNumberException("Perfect numbers must be positive integers.");
        }
        this.value = value;
    }

    boolean isPerfectSquare() {
        double sqrt = Math.sqrt(value.doubleValue());

        return Double.compare(sqrt, (int) sqrt) == 0;
    }

    List<BigInteger> divisorsExceptSelf() {
        List<BigInteger> divisors = new ArrayList<>();

        if (value.intValue() < 2) {
            return divisors;
        }

        divisors.add(BigInteger.ONE);

        for (int n = 2; n * n <= value.intValue(); n++) {
            if (value.intValue() % n == 0) {
                divisors.add(BigInteger.valueOf(n));
                divisors.add(BigInteger.valueOf(value.intValue() / n));
            }
        }

        return divisors;
    }

    private static boolean isNotPositive(BigInteger aNumber) {
        return aNumber.intValue() < 1;
    }

}
