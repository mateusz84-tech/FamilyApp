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

        if(family != null){
            if(family.getFamilyName() != null && family.getNrOfInfants() >=0 &&
                family.getNrOfChildren() >= 0 && family.getNrOfInfants() >= 0){
                familyRepository.save(family);
                return family.getId();
            }
        }
        return -1;
    }
    @GetMapping("/{id}")
    public Family getFamily(@PathVariable Integer id){

        return familyRepository.getFirstById(id);
    }
}
