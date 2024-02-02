package com.dolly.bookstoreapi;

import com.dolly.bookstoreapi.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookStoreApiApplicationTests {

	private BookController controller=new BookController();
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
