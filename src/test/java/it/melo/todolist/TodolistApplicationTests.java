package it.melo.todolist;

import it.melo.todolist.entities.Todo;
import it.melo.todolist.repositories.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodolistApplicationTests {

	@Autowired
	TodoRepository repository;

	@Test
	@Transactional
	public void contextLoads() {
		Todo todo1 = new Todo();
		Todo todo2 = new Todo();
		todo1.setId(1);
		todo1.setText("todo 1");
		todo2.setId(2);
		todo2.setText("todo 2");
		repository.save(todo1);
		repository.save(todo2);
		assertThat(repository.count()).isEqualTo(2);
		String MESSAGE = "new message";
		todo2.setText(MESSAGE);
		repository.save(todo2);
		assertThat(repository.count()).isEqualTo(2);
		Todo persistedTodo = repository.getOne(2L);
		assertThat(persistedTodo.getText()).isEqualTo(MESSAGE);
	}
}
