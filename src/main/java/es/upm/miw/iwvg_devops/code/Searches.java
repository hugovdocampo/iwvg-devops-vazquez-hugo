package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Searches {
    private final List<User> users;

    public Searches(List<User> users) {
        this.users = users;
    }

    public Optional<Fraction> findFractionAdditionByUserId(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::add);
    }

    public Stream<String> findUserIdBySomeProperFraction() {
        return users.stream()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId)
                .distinct();
    }

    public Optional<Double> findFirstDecimalFractionByUserName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal)
                .findFirst();
    }

    public Optional<Fraction> findFirstProperFractionByUserId(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst();
    }
}