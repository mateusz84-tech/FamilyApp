package pl.matkoc.FamilyApp.validate;

import pl.matkoc.FamilyApp.model.Family;
import pl.matkoc.FamilyApp.model.FamilyMember;
import java.util.List;
public class ValidateData{

    public static boolean validateFamilyMemberAge(Family family){

        Integer nrOfAdults = family.getNrOfAdults();
        Integer nrOfChildren = family.getNrOfChildren();
        Integer nrOfInfants = family.getNrOfInfants();
        int sumMembers = nrOfAdults + nrOfChildren + nrOfInfants;
        List<FamilyMember> familyMembers = family.getFamilyMembers();

        boolean correctAge = true;
        if(familyMembers.size() == sumMembers){
            for(int i=1; i<=nrOfAdults; i++){
                if(familyMembers.get(i-1).getAge() > 16) {
                    correctAge = true;
                }
                else return false;
            }
            for(int i=1; i<=nrOfChildren; i++){
                if(familyMembers.get(i-1+nrOfAdults).getAge() > 4
                && familyMembers.get(i-1+nrOfAdults).getAge() <= 16){
                    correctAge = true;
                }
                else return false;
            }
            for(int i=1; i<=nrOfInfants; i++){
                if(familyMembers.get(i-1+(nrOfAdults+nrOfChildren)).getAge() >= 0
                && familyMembers.get(i-1+(nrOfAdults+nrOfChildren)).getAge() <=4){
                    correctAge = true;
                }
                else return false;
            }
            return correctAge;
        }
        else return false;
    }
}
