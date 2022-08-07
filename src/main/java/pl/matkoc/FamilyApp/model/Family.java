package pl.matkoc.FamilyApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
// implementuje interfejs Comparable<T> dla napisania metody compareTo
@Entity
public class Family implements Comparable<Family>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String familyName;
    private Integer nrOfAdults;
    private Integer nrOfChildren;
    private Integer nrOfInfants;

    public Family(String familyName, Integer nrOfAdults, Integer nrOfChildren, Integer nrOfInfants) {
        this.familyName = familyName;
        this.nrOfAdults = nrOfAdults;
        this.nrOfChildren = nrOfChildren;
        this.nrOfInfants = nrOfInfants;
    }

    public Family() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return familyName.equals(family.familyName) && nrOfAdults.equals(family.nrOfAdults)
                && nrOfChildren.equals(family.nrOfChildren) && nrOfInfants.equals(family.nrOfInfants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName, nrOfAdults, nrOfChildren, nrOfInfants);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(Integer nrOfAdults) {
        if(nrOfAdults <=0){
            throw new IllegalArgumentException("Błędne dane");
        }
        this.nrOfAdults = nrOfAdults;
    }

    public Integer getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(Integer nrOfChildren) {
        if(nrOfChildren < 0){
            throw new IllegalArgumentException("Błędne dane");
        }
        this.nrOfChildren = nrOfChildren;
    }

    public Integer getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(Integer nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", nrOfAdults=" + nrOfAdults +
                ", nrOfChildren=" + nrOfChildren +
                ", nrOfInfants=" + nrOfInfants +
                '}';
    }

    // nadpisanie metody compareTo() dla uporządkowania obiektów w kolekcjach wg nazwy, ilosći dorosłych, dzieci i niemowląt
    @Override
    public int compareTo(Family otherFamily) {

        int result = this.familyName.compareToIgnoreCase(otherFamily.getFamilyName());
        if(result == 0)
            result = this.nrOfAdults.compareTo(otherFamily.getNrOfAdults());
        if(result == 0)
            result = this.nrOfChildren.compareTo(otherFamily.getNrOfChildren());
        if(result == 0)
            result = this.nrOfInfants.compareTo(otherFamily.getNrOfInfants());

        return result;
    }
}
