package com.jjcorsif.perfectNumbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerfectNumberChecker {

    boolean checkIfNumberIsPerfect(BigInteger aNumber) throws NotAPositiveNumberException {
        PositiveNumber aPositiveNumber = new PositiveNumber(aNumber);

        return aPositiveNumber.isPerfectNumber();
    }

    List<BigInteger> findPerfectNumbersBetween(int startingNumber, int endingNumber)
        throws NotAPositiveNumberException
    {
        List<BigInteger> perfectNumbers = new ArrayList<>();

        for (int i = startingNumber + 1; i < endingNumber; i++) {
            BigInteger currentNumber = BigInteger.valueOf(i);
            boolean isPerfect = checkIfNumberIsPerfect(currentNumber);

            if (isPerfect) {
                perfectNumbers.add(currentNumber);
            }
        }

        return perfectNumbers;
    }
}
