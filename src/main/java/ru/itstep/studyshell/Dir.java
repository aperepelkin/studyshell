package ru.itstep.studyshell;

public class Dir {
	private static Dir instance;
	private static String curentDir;
	public static void toDirectiry(){
		
	}
	public static Directory getInstance(){
		if (instance==null) {
			instance = new Dir();
		}
		return instance;
	}
	public static String getCurentDirectory(){
		return curentDir;
	}
	public void getCurentDirectory(String dir){
		curentDir = dir;
	}
	
	
	
	
}