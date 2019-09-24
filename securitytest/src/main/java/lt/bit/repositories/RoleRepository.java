package lt.bit.repositories;

import lt.bit.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query("FROM Role WHERE name = ?1")
    Role findByName(String name);
}
