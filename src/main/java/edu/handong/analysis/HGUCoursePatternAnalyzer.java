package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		int i=1;
		
		students = initiateStudentArrayFromLines(lines);
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			if(studentExist(students,student)==false)
			{
				break;
			}
			
			if(i<=numOfStudents)
			{
				System.out.println(student.getName());
				i++;
			}
			else
			{
				break;
			}
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		i=1;
		for(Course course: courses) {
			if(courseExist(courses,course)==false)
			{
				break;
			}
			
			if(i<=numOfCourses)
			{
				System.out.println(course.getCourseName());
				i++;
			}
			else
			{
				break;
			}
		}
		
	}

	/** 
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		String temp=" ";
		String[] stu=new String[lines.length];
		int i=0;
		
		for(String spname:lines)
		{
			String sp=spname.split(",")[1].trim();
			if(!(temp.equals(sp)))
			{
				stu[i]=sp;
				i++;
			}
			
			temp=sp;
		}
		i=0;
		Student[] st=new Student[stu.length];
		for(String exname:stu)
		{
			st[i]=new Student(exname);
			i++;
		}
		return st;
		
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		if(students!=null && student!=null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		String[] cos=new String[lines.length];
		int i=0,j,ch=0;
		
		for(i=0;i<lines.length;i++)
		{
			cos[i]=" ";
		}
		
		j=0;
		for(String csname:lines)
		{
			String cs=csname.split(",")[2].trim();
			ch=0;
			for(i=0;i<lines.length;i++)
			{
				if((cs.equals(cos[i])))
				{
					ch++;
				}
			}
			if(ch==0)
			{
				cos[j]=cs;
				j++;
			}
		}
		
		i=0;
		Course[] cs=new Course[cos.length];
		for(String exname:cos)
		{
			cs[i]=new Course(exname);
			i++;
		}
		return cs;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		
		if(courses!=null && course!=null)
		{
			return true;
		}
		return false;
	}

}
