package com.jjcorsif.perfectNumbers;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerfectNumberTest {

    PerfectNumberChecker perfectNumberChecker;

    @BeforeEach
    void init() {
        perfectNumberChecker = new PerfectNumberChecker();
    }

    @Test
    void returnsTrueIfNumberIsAPerfectNumber() throws Exception {
        //given / arrange
        BigInteger number = BigInteger.valueOf(6);

        //when / act
        boolean numberIsPerfect = perfectNumberChecker.checkIfNumberIsPerfect(number);

        //then / assert
        assertThat(numberIsPerfect).isTrue();
    }

    @Test
    void returnsFalseIfNumberIsNotAPerfectNumber() throws Exception {
        //given / arrange
        BigInteger number = BigInteger.valueOf(7);

        //when / act
        boolean numberIsPerfect = perfectNumberChecker.checkIfNumberIsPerfect(number);

        //then / assert
        assertThat(numberIsPerfect).isFalse();
    }

}
