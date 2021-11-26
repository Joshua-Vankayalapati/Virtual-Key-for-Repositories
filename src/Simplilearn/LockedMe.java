package Simplilearn;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class LockedMe {
	private static final String EXIT = null;

	static void WelcomeScreen() {
		System.out.println("===============================================");
		System.out.println("Welcome to Lockedme.com\n\n" + "Developer: Joshua Vankayalapati");
		System.out.println("===============================================");
	}

	static void DisplayMenu() {
		System.out.println("\nMain Menu");
		System.out.printf("\n1. Display Files in the Folder \n2. File Menu Options \n3. Quit \n");
		
		boolean running = true;
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter your option from the above Menu:");
			int input = sc.nextInt();
			switch (input) {
			
			case 1:
				File Retrievefiles = new File("D:\\LockedMe\\main");
				File array[] = Retrievefiles.listFiles();
				for (int i = 0; i<array.length; i++) {
					// isFile and isDirectory will confirm if the hierarchy contains files or
					// folders
					if (array[i].isFile()) {
						System.out.println("File: " + array[i]);
					} else if (array[i].isDirectory()) {
						System.out.println("Directory: " + array[i]);
					}
				}
				break;
				
			case 2:
				FileMenu();
				break;
				
			case 3:
				System.out.println("Input correct value and retry");
				
				break;
				
			}
System.exit(0);
		} while (running == true);
	}

	static void FileMenu() {

		boolean running = true;
		
		do {
			System.out.println("===============================================\nFile Operations Menu\n");
			System.out.println(
					"1. Add File\n2. Delete File\n3. Search File\n4. Return to Main Menu\n5. Exit\n===============================================");
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter your option from this File Menu:");
			int input1 = sc.nextInt();

			switch (input1) {

			case 1:
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the name of the File to Add: ");
				String filename = scan.nextLine().toLowerCase();
				Path file = Paths.get("./main/" + filename);
				try {
					Files.createDirectories(file.getParent());

					Files.createFile(file);

					System.out.println(file + " created successfully");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("File created successfully");
				break;

			case 2:
				System.out.println("Enter the File or Folder name and filetype to Delete: ");
				String n1 = sc.next();
				File filename1 = new File("D:\\main", n1);
				if (filename1.delete()) {
					System.out.println("File deleted successfully");
				} else {
					System.out.println("Failed to delete the File");
				}
				break;

			case 3:
				System.out.println("Enter the name of the File to Search: ");
				String name1 = sc.next().toLowerCase();
				File filename2 = new File("./main/");
				File array1[] = filename2.listFiles();
				for (int i = 0; i < array1.length; i++) {

					if (array1[i].getName().startsWith(name1)) {
						System.out.println(array1[i]);
					}
				}
				break;
				
			case 4:
				DisplayMenu();
				break;

			case 5:
				System.out.println("Program terminated successfully");
return;	
			default:
				System.exit(0);
				break;

			}
		} while (running == false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WelcomeScreen();
		DisplayMenu();
	}

}
