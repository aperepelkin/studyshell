package it.test;

import org.junit.Test;

import ru.itstep.studyshell.App;
import ru.itstep.studyshell.ChangeDirectoryCommand;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.CommandFactory;

import org.junit.Assert;
import org.junit.Before;

public class ListDirectoryCommandTest {
	
	private CommandFactory factory;
	
	@Before
	public void init() {
		factory = ChangeDirectoryCommand.createFactory();
	}

	@Test
	public void testValid() {
		Command command = new ChangeDirectoryCommand("/home/user");
		command.execute();
		Assert.assertEquals("/home/user", 
				(App.getInstance()).getDirectory());
	}

	@Test
	public void testValidCommand() {
		Command command = factory.create("cd /home/user");
		Assert.assertNotNull(command);
		Assert.assertEquals(
				ChangeDirectoryCommand.class, command.getClass());
		command.execute();
		Assert.assertEquals("/home/user", 
				App.getInstance().getDirectory());
	}

	@Test
	public void testValidUpperCaseCommand() {
		Command command = factory.create("CD /home/user");
		Assert.assertNotNull(command);
		Assert.assertEquals(
				ChangeDirectoryCommand.class, command.getClass());
		command.execute();
		Assert.assertEquals("/home/user", 
				App.getInstance().getDirectory());
	}
	
	@Test
	public void testInvalidCommand() {
		Command command = factory.create("c d /home/user");
		Assert.assertNull(command);
	}
}
