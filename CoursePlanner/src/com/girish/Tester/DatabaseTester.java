package com.girish.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.girish.DAOLayers.CourseBean;
import com.girish.DAOLayers.LoginBean;
import com.girish.DAOLayers.LoginDAOImpl;
import com.girish.DAOLayers.SectionBean;
import com.girish.DAOLayers.SectionDAOImpl;
import com.girish.DAOLayers.UsersBean;

public class DatabaseTester 
{

	public static void main(String[] args) 
	{
		SectionDAOImpl u = new SectionDAOImpl();
		LoginDAOImpl log = new LoginDAOImpl();
		Scanner inp = new Scanner(System.in);
		List<Object []> l = new ArrayList<>();
		char ch;
		
		do
		{
			System.out.println("1. Custom Select based on Term and Year");
			System.out.println("2. Custom Select based on Term only");
			System.out.println("3. Select Enrollment");
			System.out.println("4. Login");
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
						
				case 2: System.out.print("Enter the Term: ");
						String s1 = inp.next();
				
						try 
						{
							l = u.customSelectTerm(s1);
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
						LoginBean b = new LoginBean();
						b.setNuid(nuid);
						b.setPwd(pwd);
						try
						{
							UsersBean bean = log.login(b);
							System.out.println("Welcome "+bean.getFname());
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
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
