package p.lodz.teamproject_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import p.lodz.teamproject_back.model.Role;
import p.lodz.teamproject_back.model.RoleEnum;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum roleName);
}
