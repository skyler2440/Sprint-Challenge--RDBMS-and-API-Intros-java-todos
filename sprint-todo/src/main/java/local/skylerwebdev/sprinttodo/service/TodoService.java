package local.skylerwebdev.sprinttodo.service;

import local.skylerwebdev.sprinttodo.model.Todo;

import java.util.List;

public interface TodoService
{
    List<Todo> findAll();

    Todo findTodoById(long id);

    List<Todo> findByUserName ();

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);


}
