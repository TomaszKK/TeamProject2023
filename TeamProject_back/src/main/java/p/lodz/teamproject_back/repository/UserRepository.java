package p.lodz.teamproject_back.repository;

import p.lodz.teamproject_back.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

}
