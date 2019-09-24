package lt.bit.repositories;

import lt.bit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
