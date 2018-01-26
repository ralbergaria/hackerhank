package hackerhank.dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Priorities {

	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> queue = new PriorityQueue<Student>();
		for(String event : events) {
			if (event.equals("SERVED")) {
				queue.poll();
				continue;
			}
			String[] c = event.split(" ");
			Student st = new Student(Integer.valueOf(c[3]), c[1], Double.valueOf(c[2]));
			queue.offer(st);
		}
		
		List<Student> list = new ArrayList<Student>(queue);
		Collections.sort(list);
		return list;
	}	
}

class Student implements Comparable<Student>{
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	private String name;
	private double cgpa;
	
	public Student(int id, String name, double cgpa){
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	@Override
	public int compareTo(Student o) {
		if(o.getCgpa() == this.getCgpa()) {
			if(this.getName().equals(o.getName())) {
				return this.getId() - o.getId();
			}
			return this.getName().compareTo(o.getName());
		}
		return Double.valueOf(o.getCgpa()).compareTo(this.getCgpa());
	}	
}

public class Solution_priorityqueue {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }    
}