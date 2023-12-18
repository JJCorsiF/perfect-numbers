package com.jjcorsif.perfectNumbers;

import java.math.BigInteger;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfectNumberController {
    private PerfectNumberChecker perfectNumberChecker;

    PerfectNumberController(PerfectNumberChecker perfectNumberChecker) {
        this.perfectNumberChecker = perfectNumberChecker;
    }

    @GetMapping(value = "/isPerfect/{number}")
    public Map<String, String> isPerfect(@PathVariable BigInteger number) {
        try {
            boolean numberIsPerfect = perfectNumberChecker.checkIfNumberIsPerfect(number);

            return Map.of("isPerfect", "" + numberIsPerfect);
        } catch (NotAPositiveNumberException ex) {
            return Map.of("error", ex.getMessage());
        }
    }
}
