package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.Optional;

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
}