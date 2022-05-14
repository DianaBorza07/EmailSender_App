package ro.sd.a3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a3.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}