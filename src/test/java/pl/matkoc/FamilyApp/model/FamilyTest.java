package pl.matkoc.FamilyApp.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyTest {
    private Family family;
    @Before
    public void createFamily(){
        family = new Family();
    }
    @Test
    public void createObjectFamilyWithDefaultsValues(){
        assertNull(family.getFamilyName());
        assertNull(family.getNrOfAdults());
        assertNull(family.getNrOfChildren());
        assertNull(family.getNrOfInfants());
    }
    @Test
    public void createObjectWithInjectValues(){
        family = new Family("Kowalscy",2,1,1);
        assertEquals("Kowalscy",family.getFamilyName());
        assertEquals(Integer.valueOf(2),family.getNrOfAdults());
        assertEquals(Integer.valueOf(1),family.getNrOfChildren());
        assertEquals(Integer.valueOf(1),family.getNrOfInfants());
    }
    @Test(expected = NullPointerException.class)
    public void createObjectWithNullValueOfName(){
        family = new Family(null, 1,1,1);
        assertEquals(Integer.valueOf(1),family.getNrOfAdults());
        assertEquals(Integer.valueOf(1),family.getNrOfChildren());
        assertEquals(Integer.valueOf(1),family.getNrOfInfants());
    }
    @Test(expected = NullPointerException.class)
    public void createObjectWithNullNrOfAdults(){
        family = new Family("Kowalscy",null,1,1);
        assertNull(family.getNrOfAdults());
    }
    @Test(expected = NullPointerException.class)
    public void createObjectWithNullNrOfChildren(){
        family = new Family("Kowalscy", 1, null, 1);
        assertNull(family.getNrOfChildren());
    }

    @Test(expected = NullPointerException.class)
    public void createObjectWithNullNrOfInfants(){
        family = new Family("Kowalscy", 1,1,null);
        assertNull(family.getNrOfInfants());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createObjectWithNrOfAdultsLessThanZero(){
        family = new Family("Kowalscy",-1,1,1);
        assertEquals("Kowalscy",family.getFamilyName());
        assertEquals(Integer.valueOf(-1),family.getNrOfAdults());
    }
    @Test(expected = IllegalArgumentException.class)
    public void createObjectWithNrOfChildrenLessThanZero(){
        family = new Family("Kowalscy",1,-1,1);
        assertEquals(Integer.valueOf(-1),family.getNrOfChildren());
    }
    @Test(expected = IllegalArgumentException.class)
    public void createObjectWithNrOfInfantsLessThanZero(){
        family = new Family("Kowalscy", 1,1,-1);
        assertEquals(Integer.valueOf(-1),family.getNrOfInfants());
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
    @Test
    public void setNrOfInfantsMoreThanZero(){
        family.setNrOfInfants(1);
        assertEquals(Integer.valueOf(1),family.getNrOfInfants());
    }
    @Test
    public void setNrOfInfantsEqualsZero(){
        family.setNrOfInfants(0);
        assertEquals(Integer.valueOf(0),family.getNrOfInfants());
    }
    @Test(expected = IllegalArgumentException.class)
    public void setNrOfInfantsLessThanZero(){
        family.setNrOfInfants(-1);
        assertEquals(Integer.valueOf(-1),family.getNrOfInfants());
    }
}