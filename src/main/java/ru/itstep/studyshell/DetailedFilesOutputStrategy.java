package ru.itstep.studyshell;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class DetailedFilesOutputStrategy implements FilesOutputStrategy {

	public void output(List<File> files) {

		long max = 0;
		for (File f : files) {
			if (f.length() > max)
				max = f.length();
		}

		System.out.println(max);
		String aString = Long.toString(max);

		for (File f : files) {

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			double length = f.length() / 1024.0;

			String type = null;
			if (f.isFile())
				type = "Файл ";
			if (f.isDirectory())
				type = "Каталог ";

			String line = String.format("%s %8s %" + (aString.length() + 5) + ".4fkb %s ", sdf.format(f.lastModified()),
					type, length, f.getName());

			System.out.println(line);
		}

		System.out.println("Размер папки: " + folderSize(files));

	}

	private long folderSize(List<File> files) {

		long foldersize = 0;

		for (File f : files) {
			if (f.isFile())
				foldersize += f.length();

			if (f.isDirectory()) {
				File[] list = f.listFiles();
				if (list != null)
					foldersize += folderSize(Arrays.asList(list));
			}

		}

		return foldersize;
	}
/*
	private long countFiles(File file2) {
		if (.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory())
					countFiles(file);
			}
			for (File file : files) {
				int n = 0;
				if (file.isFile()) {
					n++;

					return 0;
				}
			}
		}
	}
	*/
}
