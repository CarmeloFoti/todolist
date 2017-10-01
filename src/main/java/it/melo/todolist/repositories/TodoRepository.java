package it.melo.todolist.repositories;

import it.melo.todolist.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by melo on 01/10/17.
 */
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
