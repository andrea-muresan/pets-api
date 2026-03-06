package org.example.petsapi.pet;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PetService {

    private final List<Pet> pets = List.of(
                new Pet(
                    "Luna",
                    "Andrea",
                    "dog",
                    "Frenchie",
                    3
                ),
                new Pet("Dodo", "Andres", "dog", "Cane Corso", 4),
                new Pet("Lulu", "Emma", "cat", "Siamese", 3),
                new Pet("Happy", "Maria", "dog", "Bichon", 7),
                new Pet("Piri", "Sami", "cat", "British", 2)
        );
    public List<Pet> getPets() {
        return pets;
    }

    public List<Pet> getPets(String type, String sort) {
        Stream<Pet> stream = pets.stream();

        if (type != null) {
            stream = stream.filter(p -> p.getType().toLowerCase().equals(type));
        }

        if ("realAge,asc".equals(sort)) {
            stream = stream.sorted(Comparator.comparing(Pet::getRealAge));
        } else if ("realAge,desc".equals(sort)) {
            stream = stream.sorted(Comparator.comparing(Pet::getRealAge).reversed());
        } else if ("name,asc".equals(sort)) {
            stream = stream.sorted(Comparator.comparing(Pet::getName));
        } else if ("name,desc".equals(sort)) {
            stream = stream.sorted(Comparator.comparing(Pet::getName).reversed());
        }

        return stream.toList();
    }
}
