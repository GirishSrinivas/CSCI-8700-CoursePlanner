package com.girish.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.girish.DAOLayers.CourseBean;
import com.girish.DAOLayers.CoursePlanBean;
import com.girish.DAOLayers.CoursePlanDAOImpl;
import com.girish.DAOLayers.LoginBean;
import com.girish.DAOLayers.LoginDAOImpl;
import com.girish.DAOLayers.SectionBean;
import com.girish.DAOLayers.SectionDAOImpl;
import com.girish.DAOLayers.StudentBean;
import com.girish.DAOLayers.StudentDAOImpl;
import com.girish.DAOLayers.UsersBean;

public class DatabaseTester 
{

	public static void main(String[] args) 
	{
		SectionDAOImpl u = new SectionDAOImpl();
		LoginDAOImpl log = new LoginDAOImpl();
		LoginBean b = new LoginBean();
		StudentDAOImpl sb = new StudentDAOImpl();
		Scanner inp = new Scanner(System.in);
		List<Object []> l = new ArrayList<>();
		char ch;
		
		do
		{
			System.out.println("1. Custom Select based on Term and Year");
			System.out.println("2. Custom Select based on course ID only");
			System.out.println("3. Select Enrollment");
			System.out.println("4. Login");
			System.out.println("5. is present");
			System.out.println("Press any key to exit");
			System.out.print("Enter your choice: ");
			int choice = inp.nextInt();
			
			switch(choice)
			{
				case 1: System.out.print("Enter the Term: ");
						String s = inp.next();
						System.out.print("Enter the Year: ");
						int y = inp.nextInt();
						try 
						{
								l = u.customSelect(s, y);
						} 
						catch (Exception e) 
						{
							System.out.println(e.getMessage());
						}
					
				
						for(Object o[] : l)
						{
							SectionBean sec = (SectionBean) o[0];
							CourseBean c = (CourseBean)o[1];							
							System.out.println(sec.getCourse_no() +" " +sec.getSection_id() +" " +c.getC_name() +" " +sec.getTerm() +" " +sec.getYear() +" " +sec.getInst_id());
						}
						break;
						
				case 2: System.out.print("Enter the course ID: ");
						String s1 = inp.next();
						System.out.print("Enter the Term: ");
						String s2 = inp.next();
				
						try 
						{
							//l = u.customSelectTerm(s1, s2);
						} 
						catch (Exception e) 
						{	
							System.out.println(e.getMessage());
						}
		
						for(Object o[] : l)
						{
							SectionBean sec = (SectionBean) o[0];
							CourseBean c = (CourseBean)o[1];							
							System.out.println(sec.getCourse_no() +" " +sec.getSection_id() +" " +c.getC_name() +" " +sec.getTerm() +" " +sec.getYear() +" " +sec.getInst_id());
						}
						break;
				
				case 3: try 
						{
							l = u.customSelect();
						} 
						catch (Exception e) 
						{	
							System.out.println(e.getMessage());
						}

						for(Object o[] : l)
						{
							SectionBean sec = (SectionBean) o[0];
							CourseBean c = (CourseBean)o[1];							
							System.out.println(sec.getCourse_no() +" " +sec.getSection_id() +" " +c.getC_name() +" " +sec.getTerm() +" " +sec.getYear() +" " +sec.getInst_id());
						}	
						break;
				
				case 4: System.out.print("Enter nuid: ");
						int nuid = inp.nextInt();
						System.out.print("Enter pwd: ");
						String pwd = inp.next();
						
						b.setNuid(nuid);
						b.setPwd(pwd);
						try
						{
							UsersBean b1 = log.login(b);
							System.out.println("Welcome "+b1.getFname());
							if(b1.getRole().equals("Student"))
							{
								StudentBean bean = sb.read(b1.getNetid());
								System.out.println("You'r a " +bean.getMajor() +" major");
							}
							else
							{
								System.out.println("You'r a " +b1.getRole());
							}
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
						break;
						
				case 5: CoursePlanDAOImpl cpd = new CoursePlanDAOImpl();
						CoursePlanBean cpb = new CoursePlanBean();
						System.out.print("Enter netid: ");
						cpb.setNetid(inp.next());
						System.out.print("Enter course id: ");
						cpb.setC_id(inp.next());
						System.out.print("Enter sec id: ");
						cpb.setSec_id(inp.next());
						System.out.print("Enter Term: ");
						cpb.setTerm(inp.next());
						System.out.print("Enter Year: ");
						cpb.setYear(inp.nextInt());
						
						try 
						{
							boolean res = cpd.isPresent(cpb);
							System.out.println("Its working " +res);
						} 
						catch (Exception e) 
						{
							System.out.println("Its not working");
						}
						
						
						
						break;
	
				default: System.exit(0);
			}
			
			System.out.print("\nPress 1 to re-try (OR) press any key to exit: ");
			ch = inp.next().charAt(0);
		}while(ch == '1');
		System.out.println("Program Terminated!");
		inp.close();
	}

}
