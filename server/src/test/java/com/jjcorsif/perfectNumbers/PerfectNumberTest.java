package com.jjcorsif.perfectNumbers;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenExceptionOfType;
import static org.assertj.core.api.BDDAssertions.thenNoException;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class PerfectNumberTest {

    @Test
    void shouldThrowAnExceptionIfNotPositive() {
        //given / arrange
        BigInteger negativeNumber = BigInteger.valueOf(-6);

        //when / act
        final ThrowingCallable callable = () -> new PositiveNumber(negativeNumber);

        //then / assert
        thenExceptionOfType(NotAPositiveNumberException.class)
            .isThrownBy(callable)
            .withMessageContaining("Perfect numbers must be positive integers.");
    }

    @Test
    void shouldNotThrowAnExceptionIfNumberIsPositive() {
        //given / arrange
        BigInteger aNumber = BigInteger.valueOf(5);

        //when / act
        final ThrowingCallable callable = () -> new PositiveNumber(aNumber);

        //then / assert
        thenNoException().isThrownBy(callable);
    }

    @Test
    void returnsTrueIfNumberIsAPerfectSquare() throws NotAPositiveNumberException {
        //given / arrange
        BigInteger number = BigInteger.valueOf(25);
        PositiveNumber positiveNumber = new PositiveNumber(number);

        //when / act
        boolean numberIsPerfectSquare = positiveNumber.isPerfectSquare();

        //then / assert
        then(numberIsPerfectSquare).isTrue();
    }

    @Test
    void returnsFalseIfNumberIsNotAPerfectSquare() throws NotAPositiveNumberException {
        //given / arrange
        BigInteger number = BigInteger.valueOf(15);
        PositiveNumber positiveNumber = new PositiveNumber(number);

        //when / act
        boolean numberIsPerfect = positiveNumber.isPerfectSquare();

        //then / assert
        then(numberIsPerfect).isFalse();
    }

    @Test
    void returnsListOfDivisorsFor6() throws NotAPositiveNumberException {
        //given / arrange
        BigInteger number = BigInteger.valueOf(6);
        PositiveNumber positiveNumber = new PositiveNumber(number);

        //when / act
        List<BigInteger> divisors = positiveNumber.divisorsExceptSelf();

        //then / assert
        then(divisors)
            .contains(BigInteger.ONE)
            .contains(BigInteger.TWO)
            .contains(BigInteger.valueOf(3));
    }

    @Test
    void returnsListOfDivisorsFor120() throws NotAPositiveNumberException {
        //given / arrange
        BigInteger number = BigInteger.valueOf(120);
        PositiveNumber positiveNumber = new PositiveNumber(number);

        //when / act
        List<BigInteger> divisors = positiveNumber.divisorsExceptSelf();

        //then / assert
        then(divisors)
            .contains(BigInteger.ONE)
            .contains(BigInteger.TWO)
            .contains(BigInteger.valueOf(3))
            .contains(BigInteger.valueOf(4))
            .contains(BigInteger.valueOf(5));
    }

}
