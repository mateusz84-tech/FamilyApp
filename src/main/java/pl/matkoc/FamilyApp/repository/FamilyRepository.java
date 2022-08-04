package pl.matkoc.FamilyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.matkoc.FamilyApp.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Integer> {

    @Override
    <S extends Family> S save(S entity);
}
