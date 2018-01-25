package hackerhank.dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student2{
	private int id;
	private String fname;
	private double cgpa;
	public Student2(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class Solution_Sort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student2> studentList = new ArrayList<Student2>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student2 st = new Student2(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		
		Collections.sort(studentList, new Comparator<Student2>() {

			@Override
			public int compare(Student2 o1, Student2 o2) {
				if(o2.getCgpa() == o1.getCgpa()) {
					if(o1.getFname().equals(o2.getFname())) {
						return o1.getId() - o2.getId();
					}
					return o1.getFname().compareTo(o2.getFname());
				}
				return Double.valueOf(o2.getCgpa()).compareTo(o1.getCgpa());
			}
		});
		
		for(Student2 st: studentList){
			System.out.println(st.getFname());
		}
	}
}
