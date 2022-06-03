package com.walmart.queuedatabase;

import com.walmart.queuedatabase.dao.PeopleDao;
import com.walmart.queuedatabase.model.People;
import com.walmart.queuedatabase.services.PeopleService;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueueDatabaseApplicationTests {

	@Autowired
	PeopleDao peopleDao;

	@Test
	@Order(1)
	public void testCreatePerson() {
		People person = new People();
		person.setPersonid("1234");
		person.setName("Burks, Rosella");
		person.setFirst("Rosella");
		person.setLast("Burks");
		person.setMiddle("Middle");
		person.setEmail("test@test.email");
		person.setPhone("123.456.7890");
		person.setFax("123.456.7890");
		person.setTitle("testTitle");
		this.peopleDao.save(person);
		Assertions.assertNotNull(this.peopleDao.findById("1234").get());
	}

	@Test
	@Order(2)
	public void testReadAllPeople() {
		List<People> listPeople = this.peopleDao.findAll();
		AssertionsForClassTypes.assertThat(listPeople).asList().size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSinglePerson() {
		People person = (People) this.peopleDao.findById("1234").get();
		Assertions.assertEquals("Burks, Rosella", person.getName());
	}

	@Test
	@Order(4)
	public void testDeletePerson() {
		this.peopleDao.deleteById("1234");
		AssertionsForClassTypes.assertThat(this.peopleDao.existsById("1234")).isFalse();
	}
}
