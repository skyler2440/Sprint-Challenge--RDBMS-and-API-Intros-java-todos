package local.skylerwebdev.sprinttodo.repository;

import local.skylerwebdev.sprinttodo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long>
{
}
