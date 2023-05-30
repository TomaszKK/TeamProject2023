package p.lodz.teamproject_back.repository;

import p.lodz.teamproject_back.model.Role;
import p.lodz.teamproject_back.model.RoleEnum;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(RoleEnum roleName);
}
