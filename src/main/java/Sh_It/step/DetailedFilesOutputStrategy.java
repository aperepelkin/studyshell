package Sh_It.step;

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
		TotalSizes totalSizes = totalSize(files);
		
		System.out.println("Размер папки: " + totalSizes.foldersize);
		System.out.println("Количество файлов: " + totalSizes.count);
		System.out.println("Количество каталогов: " + totalSizes.countDirectory);
	}
	
	private class TotalSizes {
		long foldersize;
		long count;
		long countDirectory;
		
		public void add(TotalSizes other) {
			foldersize +=other.foldersize;
			count +=other.count;
			countDirectory +=other.countDirectory;
		}
	}

	private TotalSizes totalSize(List<File> files) {

		TotalSizes totalSize = new TotalSizes();

		
		for (File f : files) {
			if (f.isFile()) {
				totalSize.foldersize += f.length();
				totalSize.count++;
			}

			if (f.isDirectory()) {
				File[] list = f.listFiles();
				if (list != null)
					totalSize.add(totalSize(Arrays.asList(list)));
			}
			if(f.isDirectory()) {
				totalSize.countDirectory++;
				
				
			}

		}

		return totalSize;
	}
}
