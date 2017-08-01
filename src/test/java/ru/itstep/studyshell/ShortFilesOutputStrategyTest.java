package ru.itstep.studyshell;

import org.junit.Test;

public class ShortFilesOutputStrategyTest {
	
	@Test
	public void testOutput() {
		ShortFilesOutputStrategy strategy = new ShortFilesOutputStrategy();
		strategy.setOut(new OutputInterface() {
			public void println(Object out) {
			}
		});
	}
}
