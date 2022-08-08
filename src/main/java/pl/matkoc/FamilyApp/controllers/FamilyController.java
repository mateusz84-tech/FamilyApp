package pl.matkoc.FamilyApp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.matkoc.FamilyApp.model.Family;
import pl.matkoc.FamilyApp.repository.FamilyRepository;

@RestController
@RequestMapping("/family")
public class FamilyController {

    private final FamilyRepository familyRepository;

    public FamilyController(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @PostMapping()
    public int createFamily(@RequestBody Family family) {

        if (family != null) {
            if (family.getFamilyName() != null && family.getNrOfAdults() > 0 &&
                    family.getNrOfChildren() >= 0 && family.getNrOfInfants() >= 0) {
                familyRepository.save(family);
            }
            return family.getId();
        }
        else return -1;
    }
}
