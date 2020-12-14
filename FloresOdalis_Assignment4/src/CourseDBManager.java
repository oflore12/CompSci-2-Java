import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	private ArrayList<String> courses;
	private ArrayList<Integer> crnArray;
	private CourseDBStructure courseDBS;
	private CourseDBElement courseDBE;
	private int size = 20;
	
	public CourseDBManager() {
		this.courseDBS = new CourseDBStructure(size);
		this.courses = new ArrayList<String>();
		this.crnArray = new ArrayList<>();
	}
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		this.courseDBE= new CourseDBElement(id, crn, credits, roomNum, instructor);
		courseDBS.add(courseDBE);
		courses.add(courseDBE.toString());
		crnArray.add(crn);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return courseDBS.get(crn);
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		ArrayList<Integer> crnArray= new ArrayList<>();
		Scanner fileInput = new Scanner(input);
		String[] arr= new String[100];
		int index=0;
		
		while(fileInput.hasNextLine()) {
			arr[index]=fileInput.nextLine().trim();
			index++;
		}
		
		for(int i=0; i<index; i++) {
		Scanner currentLine = new Scanner(arr[i]);
		while(currentLine.hasNextLine()) {
			String courseID =currentLine.next();
			int CRN = Integer.parseInt(currentLine.next().trim());
			int credits = Integer.parseInt(currentLine.next());
			String roomNum = currentLine.next();
			String instruct ="";
			while(currentLine.hasNext()) {
				instruct+=currentLine.next()+" ";
			}
			instruct=instruct.trim();
			add(courseID, CRN, credits, roomNum, instruct);
			}
		}
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> ordered = new ArrayList<>();
		Collections.sort(crnArray);
		for(int i=0; i<crnArray.size();i++) {
			ordered.add("\n"+get(crnArray.get(i)).toString());
		}
		return ordered;
	}


}
