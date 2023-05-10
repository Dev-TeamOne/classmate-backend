package devteamOne.classmate.user.repository;

import devteamOne.classmate.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
