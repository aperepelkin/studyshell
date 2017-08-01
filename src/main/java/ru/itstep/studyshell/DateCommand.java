package ru.itstep.studyshell;

import java.util.Date;

public class DateCommand implements Command{

	Date date = new Date();
	
	
	public void execute() {
		System.out.println(date);
		
	}
		DateCommand( String string) {
		this.date = date;	
		
	}
}
