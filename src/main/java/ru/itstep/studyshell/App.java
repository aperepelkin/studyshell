package ru.itstep.studyshell;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		while (true) {
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			
			Command command = CommandRepository.getInstance().create(line);
			if (command != null)
				command.execute();

		}

	}
}
