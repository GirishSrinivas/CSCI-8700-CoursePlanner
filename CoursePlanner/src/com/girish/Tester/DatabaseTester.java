package com.girish.Tester;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.girish.DAOLayers.UsersBean;
import com.girish.DAOLayers.UsersDAOImpl;
import com.girish.util.*;
public class DatabaseTester 
{

	public static void main(String[] args) 
	{
		UsersDAOImpl u = new UsersDAOImpl();
		Scanner inp = new Scanner(System.in);
		List<UsersBean> l = new ArrayList();
		char ch;
		
		do
		{
			System.out.println("1. Read");
			System.out.println("2. Write");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("Press any key to exit");
			System.out.print("Enter your choice: ");
			int choice = inp.nextInt();
			
			switch(choice)
			{
				case 1: 
						try 
						{
								l = u.read();
						} 
						catch (Exception e) 
						{
							System.out.println(e.getMessage());
						}
					
				
						for(UsersBean ub : l)
						{
							System.out.println(ub.getNetid() +" " +ub.getFname() +" " +ub.getLname() +" " +ub.getEmail() );
						}
						break;
				case 2:
						System.out.println("Write");
						break;
				case 3: 
						System.out.println("Update");
						break;
				case 4: 
						System.out.println("Delete");
						break;
				default: System.exit(0);
			}
			
			System.out.println("Press 1 to re-try (OR) press any key to exit");
			ch = inp.next().charAt(0);
		}while(ch == '1');

	}

}
