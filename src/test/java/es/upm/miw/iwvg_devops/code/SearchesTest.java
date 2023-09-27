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
}

