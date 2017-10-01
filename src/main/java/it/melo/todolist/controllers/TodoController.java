package it.melo.todolist.controllers;

import it.melo.todolist.entities.Todo;
import it.melo.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


/**
 * Created by melo on 01/10/17.
 */
@Controller
public class TodoController {

    static Logger log = Logger.getLogger(TodoController.class.getName());

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(value = "/todo/", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> listAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        if (todoList.isEmpty()){
         log.debug("Requested empty Todo list");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTodo(@PathVariable("id") long id) {
        log.debug("Requested Todo with id: "+id);

        Todo todo = todoRepository.findOne(id);
        if (todo == null) {
            log.warn("Invalid todo requested: "+id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/", method = RequestMethod.POST)
    public ResponseEntity<?> createTodo(@RequestBody Todo todo, UriComponentsBuilder ucBuilder) {
        todoRepository.save(todo);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(todo.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTodo(@PathVariable("id") long id) {

        Todo todo = todoRepository.findOne(id);
        if (todo == null) {
            log.warn("Invalid todo to delete requested: "+id);
            return new ResponseEntity(
                    HttpStatus.NOT_FOUND);
        }
        todoRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> replace(@PathVariable("id") long id, @RequestBody Todo todo) {
        log.debug("Updating Todo with id: "+id);

        Todo oldTodo = todoRepository.findOne(id);

        if (oldTodo == null) {
            log.warn("Invalid todo to delete requested: "+id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        oldTodo.setText(todo.getText());
        todoRepository.save(oldTodo);
        return new ResponseEntity<>(oldTodo, HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody Todo todo) {
        log.debug("Updating Todo with id: "+id);

        Todo oldTodo = todoRepository.findOne(id);

        if (oldTodo == null) {
            log.warn("Invalid todo to delete requested: "+id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (todo.getText()!=null) {
            oldTodo.setText(todo.getText());
            todoRepository.save(oldTodo);
        }
        return new ResponseEntity<>(oldTodo, HttpStatus.OK);
    }
}
