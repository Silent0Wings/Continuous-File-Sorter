package Sorting;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Sorter {
	
	
    JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

	
	
	
	public void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

	final File folder = new File("/home/you/Desktop");
	//listFilesForFolder(folder);

}

