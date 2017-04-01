/*
 * Copyright 2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.shell.botscrew;

import org.junit.Test;
import org.shell.botscrew.models.Book;
import org.shell.botscrew.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;

import static org.junit.Assert.assertEquals;

public class HelloWorldCommandTests {

	@Autowired
	BookRepository bookRepository;
	@Test
	public void addBookShellTest() {
		Bootstrap bootstrap = new Bootstrap();
		
		JLineShellComponent shell = bootstrap.getJLineShellComponent();
		
		CommandResult cr = shell.executeCommand("book add --author 'J.K. Rownling' --title 'Harry Potter' ");
		assertEquals(true, cr.isSuccess());
		assertEquals("Book = [Harry Potter] [J.K. Rownling]", cr.getResult());
	}
}
