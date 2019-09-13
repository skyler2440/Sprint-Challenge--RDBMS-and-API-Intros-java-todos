package local.skylerwebdev.sprinttodo.repository;

import local.skylerwebdev.sprinttodo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
