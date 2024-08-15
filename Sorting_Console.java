package Sorter_Package;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Sorting_Console {

	public static String[] Array;
	public static  File[] File_Array;
	public static File search_Folder;
	public static File New_Folder;
	public static String word="1 -";
	public static int wordplus;
	public static int numberoftimes;
	public static int File_numbers;
	public static int i=0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//_____________________________________________________________________		
		 @SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter word to check");

		    String userName = myObj.nextLine();  // Read user input
		    System.out.println("word is: " + userName);  // Output user input

		 

//_____________________________________________________________________		  
		  @SuppressWarnings({ "unused", "resource" })
		Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter the start number");

		    int test1 = myObj.nextInt();  // Read user input
		    System.out.println("the start number is: " + test1);  // Output user input
		    wordplus=test1;

//_____________________________________________________________________

		    
		    Scanner myObj11 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter the loop number");

		    int test11 = myObj.nextInt();  // Read user input
		    System.out.println(" the loopr number is: " + test11);  // Output user input
		    numberoftimes=test11;

		    myObj11.close();
		    
		    JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    chooser.setFileFilter(filter);
		    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		    }
			//store the patha as a file

			final  File file = chooser.getSelectedFile();

 //_____________________________________________________________________
		    
		    for(int virtu=wordplus;virtu<numberoftimes;virtu++)
		    {
		    	word=userName+(wordplus+1);

		    	//file choser to pick a folder
				
				
				String tes= file.getAbsolutePath();
				search_Folder=file;
				System.out.println(tes);
				System.out.println("________________________________");

				//this is to show every file in a folder
				//System.out.println("File path"+file.getAbsolutePath());

				
				File_numbers=Number_Of_Files(file);
				System.out.println("File_numbers"+File_numbers);

				
				
				File_Array=new File[File_numbers];
				//System.out.println("File_Array size"+File_Array.length);

				//Creat_Folder(word,file);
		        System.out.println(" 0 New_Folder"+New_Folder);

		        i=0;
				listFilesForFolder(file);
			    Check_For_Word(File_Array);
		    	
		    	
		    	
		    	
		    }
		
	}
	public static void listFilesForFolder(final File folder) {

	    for (final File fileEntry : folder.listFiles()) {

	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else if(fileEntry.isFile()) {
	        	if(i==File_numbers)
	        	{
	        		return;
	        	}else
	        	{
	        		System.out.println("i : " + i);

		            System.out.println(fileEntry.getName());
			        File_Array[i] =fileEntry; 
			    	i+=1;
	        		
	        	}
	            
	        }
			

	    }
	}
	public static int Number_Of_Files(final File folder) {

		int Z=-1;
	    for (final File fileEntry : folder.listFiles()) {

	        if (fileEntry.isDirectory()) {
	        	
	            
	        } else {
	        	
	           
	        	Z+=1;
	        }
			

	    }
	    return Z;
	}
	public static void Check_For_Word(File[] array)
	{ 
		for(int i=0 ; i<File_Array.length ; i++)
		{
			String Ocean = File_Array[i].getName();
			System.out.println("CAMPARING "+File_Array[i].getName());

			
		    // Checks to see if the word "Java" is found in the Ocean
		    // variable.
		    String Fish = word;
		    if (Ocean.indexOf(Fish) != -1) {
		        System.out.println("Found the word " + Fish +
		                " at index number " + Ocean.indexOf(Fish));
		    } else {
		        System.out.println("Can't find " + Fish);
		    }

		    // Or use the String.contains() method if you are not interested
		    // with the index of the word.
		    if (Ocean.contains(Fish)) {
		        System.out.println("Eureka we've found Java!");
		      // System.out.println("   "+New_Folder.getAbsolutePath()+"\\"+word+"\\"+File_Array[i].getName());
		       //System.out.println("New_Folder"+ New_Folder.getAbsolutePath());

				New_Folder= Creat_Folder(word,search_Folder);

		        Move_File(File_Array[i]);

		    }
		    
		    
			
		}
	
		
		
	}
	public static void Move_File(File a_file)
	{
		
        System.out.println("   DEST  "+New_Folder.getPath()+"\\"+a_file.getName() );


        String New_Name=a_file.getName();
		a_file.renameTo(new File(New_Folder.getAbsolutePath()+"\\"+a_file.getName() ) );
		//Path source=Paths.get(a_file.getAbsolutePath());
		//Path target=Paths.get(New_Folder.getAbsolutePath()+"\\"+a_file.getName());
        //Files.move(source,target.resolve(source.getFileName()));
		
		/*
        System.out.println("src  "+a_file.getAbsolutePath());
		String src=a_file.getAbsolutePath();
		
		
        System.out.println("dest  "+New_Folder.getAbsolutePath()+"\\"+a_file.getName());
		String dest=New_Folder.getAbsolutePath()+"\\"+a_file.getName();
		
		Path result = null;
	      try {
	         result = Files.move(Paths.get(src), Paths.get(dest));
	      } catch (IOException e) {
	         System.out.println("Exception while moving file: " + e.getMessage());
	      }
	      if(result != null) {
	         System.out.println("File moved successfully.");
	      }else{
	         System.out.println("File movement failed.");
	      }
		*/
		
		
        System.out.println("Done !!!!");


	}
	public static File Creat_Folder(String word,File folder)
	{

		File f = new File(folder.getAbsolutePath()+"\\"+word+"");
        System.out.println("Directory Created"+folder.getAbsolutePath()+"\\"+word);

		try{
		    if(f.mkdir()) { 
		        System.out.println("Directory Created");
		        

		    } else {
		        System.out.println("Directory is not created");
		    }
		} catch(Exception e){
		    e.printStackTrace();
		} 
		
		return f;
	}
}
