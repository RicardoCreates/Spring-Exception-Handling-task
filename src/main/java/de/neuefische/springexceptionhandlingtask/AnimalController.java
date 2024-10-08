package de.neuefische.springexceptionhandlingtask;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @GetMapping("{species}")
    String getAnimalSpecies(@PathVariable String species) {
        if (!species.equals("dog")) {
            throw new IllegalArgumentException("Only 'dog' is allowed");
        }
        return species;
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ErrorMessage handleIllegalArgumentExpection(IllegalArgumentException e){
//        return new ErrorMessage(e.getMessage());
//    }

    @GetMapping
    String getAllAnimals() {
        throw new NoSuchElementException("No Animals found");
    }
}
