package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;


    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>(List.of(
                new Fraction(1, 2),
                new Fraction(2, 3),
                new Fraction(4, 5),
                new Fraction(6, 7)
        ));
        user = new User("id", "name", "familyName", fractions);
    }


    @Test
    void testGetUserId() {
        assertEquals("id", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("name", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("newName");
        assertEquals("newName", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("familyName", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("newFamilyName");
        assertEquals("newFamilyName", user.getFamilyName());
    }

    @Test
    void testSetFractions() {
        ArrayList<Fraction> newFractions = new ArrayList<>(Arrays.asList(
                new Fraction(3, 4),
                new Fraction(5, 6)
        ));
        user.setFractions(newFractions);
        assertEquals(newFractions, user.getFractions());
    }


    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(8, 9);
        user.addFraction(newFraction);
        assertEquals(5, user.getFractions().size());
    }


    @Test
    void testFullName() {
        assertEquals("name familyName", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("n.", user.initials());
    }

}