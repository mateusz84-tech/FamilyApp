package pl.matkoc.FamilyApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class FamilyMember implements Comparable<FamilyMember>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int yearAdults;
    private int yearChildren;
    private int yearInfants;

    public FamilyMember(String name, int yearAdults, int yearChildren, int yearInfants) {
        this.name = name;
        this.yearAdults = yearAdults;
        this.yearChildren = yearChildren;
        this.yearInfants = yearInfants;
    }

    public FamilyMember() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return yearAdults == that.yearAdults &&
                yearChildren == that.yearChildren &&
                yearInfants == that.yearInfants && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearAdults, yearChildren, yearInfants);
    }

    @Override
    public int compareTo(FamilyMember otherFamilyMembers) {
        int result = name.compareTo(otherFamilyMembers.getName());
        if(result == 0) result = Integer.compare(yearAdults, otherFamilyMembers.getYearAdults());
        if(result == 0) result = Integer.compare(yearChildren, otherFamilyMembers.getYearChildren());
        if(result == 0) result = Integer.compare(yearInfants, otherFamilyMembers.getYearInfants());
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearAdults() {
        return yearAdults;
    }

    public void setYearAdults(int yearAdults) {
        this.yearAdults = yearAdults;
    }

    public int getYearChildren() {
        return yearChildren;
    }

    public void setYearChildren(int yearChildren) {
        this.yearChildren = yearChildren;
    }

    public int getYearInfants() {
        return yearInfants;
    }

    public void setYearInfants(int yearInfants) {
        this.yearInfants = yearInfants;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearAdults=" + yearAdults +
                ", yearChildren=" + yearChildren +
                ", yearInfants=" + yearInfants +
                '}';
    }
}
