package pl.matkoc.FamilyApp.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class FamilyTest {

    private Family family;
    @Before
    public void createFamily(){
        family = new Family();
    }

    @Test
    public void setFamilyName(){
        family.setFamilyName("Kowalscy");
        assertEquals("Kowalscy",family.getFamilyName());
    }

    @Test
    public void setNrOfAdultsMoreThanZero(){
        family.setNrOfAdults(2);
        assertEquals(Integer.valueOf(2),family.getNrOfAdults());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNrOfAdultsEqualsZero(){
        family.setNrOfAdults(0);
        assertEquals(Integer.valueOf(0),family.getNrOfAdults());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNrOfAdultsLesThanZero(){
        family.setNrOfAdults(-1);
        assertEquals(Integer.valueOf(-1),family.getNrOfAdults());
    }

    @Test
    public void setNrOfChildrenMOreThanZero(){
        family.setNrOfChildren(1);
        assertEquals(Integer.valueOf(1),family.getNrOfChildren());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNrOfChildrenLessThanZero(){
        family.setNrOfChildren(-1);
        assertEquals(Integer.valueOf(-1),family.getNrOfChildren());
    }


}