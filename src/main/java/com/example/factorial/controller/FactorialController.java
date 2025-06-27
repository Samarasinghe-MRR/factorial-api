package com.example.factorial.controller;

import com.example.factorial.model.FactorialResponse;
import com.example.factorial.service.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FactorialController {

    @Autowired
    private FactorialService factorialService;

    @GetMapping("/factorial/{number}")
    public ResponseEntity<FactorialResponse> getFactorial(@PathVariable("number") String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            long result = factorialService.calculateFactorial(number);
            return ResponseEntity.ok(new FactorialResponse(number, result));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(new FactorialResponse("Invalid input: " + numberStr));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new FactorialResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new FactorialResponse("Unexpected error: " + e.getMessage()));
        }
    }
}
