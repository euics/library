package eucis.libraryapp.repository;

import eucis.libraryapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByName(String name);
    void deleteById(long id);
}
