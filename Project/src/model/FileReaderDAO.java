package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileReaderDAO {
	private List<Object> list = new LinkedList<>();
	private static FileReaderDAO instance;
	
	private FileReaderDAO() {
	}
	
	
	public static FileReaderDAO getInstance(){
		if(instance == null)
			instance = new FileReaderDAO();
		return instance;
	}

	
	
	public List<Object> createActivity(String file) {
		try {
			list.clear();
			Scanner scanner = new Scanner(new File(file));
			while(scanner.hasNextLine()) {
				TrackPoint mp = new TrackPoint(scanner.nextLine());
				this.list.add(mp);
			}
			
			scanner.close();
			return this.list;
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	

}