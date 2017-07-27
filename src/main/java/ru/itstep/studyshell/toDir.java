package ru.itstep.studyshell;

public class toDir {
	private static String curentDirectory;

	public static void toDirectory(String where) {
		where.equals("..");
			StringBuilder sb = new StringBuilder();
			String[] new Dir = curentDirectory.split("/");
			for(int i = 0; i < new Dir.leght -i; i++){
				sb.append(new Dir[i] + "/");
			}
			curentDirectory = sb.toString()
		}	else if (where.contains(":")) {
			curentDirectory = (String)where.contains(":");{
				curentDirectory = where.replace("/", "\\");
			}else { StringBuilder sb = new SB();
			SB.append(curentDirectory);
			SB.append("\\" + where);
				
			}
		}
	}

}
