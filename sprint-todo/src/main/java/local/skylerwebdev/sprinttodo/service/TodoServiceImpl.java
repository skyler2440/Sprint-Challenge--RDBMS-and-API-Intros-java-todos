package local.skylerwebdev.sprinttodo.service;

import local.skylerwebdev.sprinttodo.model.Todo;
import local.skylerwebdev.sprinttodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements TodoService
{
    @Autowired
    private TodoRepository todorepos;
    @Override
    public List<Todo> findAll()
    {
        List<Todo> todolist = new ArrayList<>();
        todorepos.findAll().iterator().forEachRemaining(todolist::add);
        return todolist;
    }

    @Override
    public Todo findTodoById(long id)
    {
        return todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Todo> findByUserName(String username)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {
        if(todorepos.findById(id).isPresent())
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(todorepos.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName()))
            {
                todorepos.deleteById(id);
            }else
            {
                throw new EntityNotFoundException(Long.toString(id) + " " + authentication.getName());
            }
        }else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }
    @Transactional
    @Override
    public Todo save(Todo todo)
    {
        return todorepos.save(todo);
    }

    @Override
    public Todo update(Todo todo, long id)
    {
        Todo newTodo = todorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if(todo.getDescription() != null)
        {
            newTodo.setDescription(todo.getDescription());
        }
        if(todo.getUser() != null)
        {
            newTodo.setUser(todo.getUser());
        }
        return todorepos.save(newTodo);
    }
}
