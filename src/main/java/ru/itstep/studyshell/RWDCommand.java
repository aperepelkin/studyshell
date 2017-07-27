package ru.itstep.studyshell;

import java.io.File;

public class RWDCommand implements CommandFactory {

	private static final String MKDIR = "mkdir";
	private static final String DELDIR = "deldir";

	File mk = new File("./");
	boolean createMK = mk.mkdir();
	boolean delMK = mk.delete();
	public Command create(String command) {

		File mk = new File(command);
		// 
		String[] split = command.split(" ");
		// 
		if (split.length > 1 && split[0].equals(MKDIR)) {
			
		}
		if (createMK = true) {
			System.out.println("mk true");
		} if (createMK != false) {
			System.out.println("mk false");
		}if (split.length > 1 && split[0].equals(DELDIR)) {

		}
		if (delMK = true) {
			System.out.println("del true");
		} if (delMK != false) {
			System.out.println("del false");
		}
		
		return null;
	}

	private void mkdir() {
		// TODO Auto-generated method stub

	}

}