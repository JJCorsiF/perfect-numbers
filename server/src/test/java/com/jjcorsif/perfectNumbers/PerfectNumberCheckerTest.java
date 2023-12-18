package com.jjcorsif.perfectNumbers;

import static org.assertj.core.api.BDDAssertions.then;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerfectNumberCheckerTest {

    PerfectNumberChecker perfectNumberChecker;

    @BeforeEach
    void init() {
        perfectNumberChecker = new PerfectNumberChecker();
    }

    @Test
    void returnsTrueIfNumberIsAPerfectNumber() throws NotAPositiveNumberException {
        //given / arrange
        BigInteger number = BigInteger.valueOf(6);

        //when / act
        boolean numberIsPerfect = perfectNumberChecker.checkIfNumberIsPerfect(number);

        //then / assert
        then(numberIsPerfect).isTrue();
    }

    @Test
    void returnsFalseIfNumberIsNotAPerfectNumber() throws NotAPositiveNumberException {
        //given / arrange
        BigInteger number = BigInteger.valueOf(7);

        //when / act
        boolean numberIsPerfect = perfectNumberChecker.checkIfNumberIsPerfect(number);

        //then / assert
        then(numberIsPerfect).isFalse();
    }

    @Test
    void returnsAllPerfectNumbersBetween4And30() throws NotAPositiveNumberException {
        //given / arrange
        int startingNumber = 4;
        int endingNumber = 30;

        //when / act
        List<BigInteger> perfectNumbers = perfectNumberChecker.findPerfectNumbersBetween(startingNumber, endingNumber);

        //then / assert
        then(perfectNumbers)
            .contains(BigInteger.valueOf(6))
            .contains(BigInteger.valueOf(28));
    }

    @Test
    void returnsAllPerfectNumbersBetween490And8130() throws NotAPositiveNumberException {
        //given / arrange
        int startingNumber = 490;
        int endingNumber = 8130;

        //when / act
        List<BigInteger> perfectNumbers = perfectNumberChecker.findPerfectNumbersBetween(startingNumber, endingNumber);

        //then / assert
        then(perfectNumbers)
            .contains(BigInteger.valueOf(496))
            .contains(BigInteger.valueOf(8128));
    }

}
