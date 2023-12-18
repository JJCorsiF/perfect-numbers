package com.jjcorsif.perfectNumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PositiveNumber {

    private final BigInteger value;

    PositiveNumber(BigInteger value) throws NotAPositiveNumberException {
        if (!isPositive(value)) {
            throw new NotAPositiveNumberException("Perfect numbers must be positive integers.");
        }
        this.value = value;
    }

    BigInteger aliquotSum() {
        return divisorsExceptSelf().stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    boolean isPerfectNumber() {
        return !isPerfectSquare() && value.equals(aliquotSum());
    }

    boolean isPerfectSquare() {
        double sqrt = Math.sqrt(value.doubleValue());

        return Double.compare(sqrt, (int) sqrt) == 0;
    }

    List<BigInteger> divisorsExceptSelf() {
        List<BigInteger> divisors = new ArrayList<>();

        int intValue = value.intValue();
        final int SMALLEST_EVEN_DIVISOR = 2;

        if (intValue < SMALLEST_EVEN_DIVISOR) {
            return divisors;
        }

        divisors.add(BigInteger.ONE);

        for (int n = SMALLEST_EVEN_DIVISOR; n * n <= intValue; n++) {
            if (intValue % n == 0) {
                BigInteger divisor = BigInteger.valueOf(n);
                divisors.add(divisor);
                divisors.add(value.divide(divisor));
            }
        }

        return divisors;
    }

    private static boolean isPositive(BigInteger aNumber) {
        return aNumber.compareTo(BigInteger.ZERO) > 0;
    }

}
