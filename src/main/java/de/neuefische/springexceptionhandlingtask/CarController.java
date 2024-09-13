package de.neuefische.springexceptionhandlingtask;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @GetMapping("{brand}")
    String getCarBrand(@PathVariable String brand) {
        if (!brand.equals("porsche")) {
            throw new IllegalArgumentException("Only 'porsche' allowed");
        }
        return brand;
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ErrorMessage handleIllegalArgumentException(IllegalArgumentException e){
//        System.out.println("IllegalArgumentException: " + e.getMessage() + " local");
//        return new ErrorMessage(e.getMessage());
//    }

    @GetMapping
    String getAllCars() {
        throw new NoSuchElementException("No Cars found");
    }
}
