package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SearchesTest {
    private Searches finder;

    @BeforeEach
    void setUp() {
        User user1 = new User("1", "Hugo", "Vázquez", Arrays.asList(
                new Fraction(1, 2),
                new Fraction(1, 3),
                new Fraction(2, 3)
        ));

        User user2 = new User("2", "Lucía", "Rodríguez", Arrays.asList(
                new Fraction(4, 5),
                new Fraction(7, 8)
        ));

        User user3 = new User("3", "Nerea", "González", Arrays.asList(
                new Fraction(5, 2),
                new Fraction(3, 1)
        ));

        finder = new Searches(Arrays.asList(user1, user2, user3));
    }

    @Test
    void testFindFractionAdditionByUserId() {
        Optional<Fraction> result = finder.findFractionAdditionByUserId("1");
        assertTrue(result.isPresent());
        assertEquals(27, result.get().getNumerator());
        assertEquals(18, result.get().getDenominator());
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertTrue(finder.findUserIdBySomeProperFraction().anyMatch(id -> id.equals("1")));
        assertTrue(finder.findUserIdBySomeProperFraction().anyMatch(id -> id.equals("2")));
        assertFalse(finder.findUserIdBySomeProperFraction().anyMatch(id -> id.equals("3")));
    }

    @Test
    void testFindFirstDecimalFractionByUserName() {
        Optional<Double> result = finder.findFirstDecimalFractionByUserName("Hugo");
        assertTrue(result.isPresent());
        assertEquals(0.5, result.get(), 0.001);
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        Optional<Fraction> result = finder.findFirstProperFractionByUserId("1");
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getNumerator());
        assertEquals(2, result.get().getDenominator());
    }

}

