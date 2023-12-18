package com.jjcorsif.perfectNumbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
public class PerfectNumberController {
    private PerfectNumberChecker perfectNumberChecker;

    PerfectNumberController(PerfectNumberChecker perfectNumberChecker) {
        this.perfectNumberChecker = perfectNumberChecker;
    }

    @GetMapping(produces={"application/json"})
    public Map<String, String> index() {
        Map<String, String> response = new HashMap<>();
        response.put("number/{number}/isPerfect", "To check if a given number is a perfect number");
        response.put(
            "perfectNumbersBetween/{startingNumber}/{endingNumber}",
            "To find all perfect numbers in a given interval (exclusive)"
        );
        return response;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/number/{number}/isPerfect", produces={"application/json"})
    public Map<String, String> isPerfect(@PathVariable BigInteger number) {
        try {
            boolean numberIsPerfect = perfectNumberChecker.checkIfNumberIsPerfect(number);

            return Map.of("isPerfect", "" + numberIsPerfect);
        } catch (NotAPositiveNumberException ex) {
            return Map.of("error", ex.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/perfectNumbersBetween/{startingNumber}/{endingNumber}", produces={"application/json"})
    public String findPerfectBetween(@PathVariable BigInteger startingNumber, @PathVariable BigInteger endingNumber) {
        try {
            List<BigInteger> perfectNumbers = perfectNumberChecker.findPerfectNumbersBetween(
                startingNumber.intValue(),
                endingNumber.intValue()
            );

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            return objectMapper.writeValueAsString(perfectNumbers);
        } catch (NotAPositiveNumberException ex) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            return "{\"error\": \"" + ex.getMessage() + "\"}";
        } catch (JsonProcessingException ex) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            return "{\"error\": \"" + ex.getMessage() + "\"}";
        }
    }
}
