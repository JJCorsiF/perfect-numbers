package com.jjcorsif.perfectNumbers;

import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerfectNumberChecker {

    boolean checkIfNumberIsPerfect(BigInteger aNumber) throws NotAPositiveNumberException {
        PositiveNumber aPositiveNumber = new PositiveNumber(aNumber);

        if (aPositiveNumber.isPerfectSquare()) {
            return false;
        }

        List<BigInteger> divisors = aPositiveNumber.divisorsExceptSelf();

        return aNumber.intValue() == sum(divisors);
    }

    private int sum(List<BigInteger> numbers) {
        return numbers.stream().reduce(BigInteger.ZERO, (sum, current) -> sum.add(current)).intValue();
    }
}
