package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.girish.util.*;

public class CourseDAOImpl implements CourseDAO
{

	@Override
	public List<CourseBean> read() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		CourseBean bean = null;
		List<CourseBean> l = new ArrayList<>();
		try 
		{
			con = MySqlUtility.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from course");
			while(rs.next())
			{
				bean = new CourseBean();
				
				bean.setC_no(rs.getString(1));
				bean.setC_name(rs.getString(2));
				bean.setC_type(rs.getString(3));
				bean.setC_credits(rs.getInt(4));
				bean.setC_rotation(rs.getInt(5));
				
				
				l.add(bean);
			}
			return l;
		} 
		catch (ClassNotFoundException e) 
		{
			throw e;
		} 
		catch (SQLException e) 
		{
			System.out.println("Select Error...");
			throw e;
		}
		finally
		{
			try
			{
				MySqlUtility.closeConnection(con);
			}
			catch(SQLException e)
			{
				throw e;
			}
		}
	}

	@Override
	public void write(CourseBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into course values(?,?,?,?,?)");
			ps.setString(1, bean.getC_no());
			ps.setString(2, bean.getC_name());
			ps.setString(3, bean.getC_type());
			ps.setInt(4, bean.getC_credits());
			ps.setInt(5, bean.getC_rotation());
			
			ps.execute();
			System.out.println("Data Inserted Successfully");
			
		} 
		catch (ClassNotFoundException e) 
		{
			throw e;
		}
		catch (SQLException e) 
		{
			System.out.println("Insertion Error");
			throw e;
		}
		finally
		{
			try 
			{
				MySqlUtility.closeConnection(con);
			}
			catch (SQLException e) 
			{
				throw e;
			}
		}
		
	}

	@Override
	public void update(CourseBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update course set c_rotation=?, c_type=? where c_no=?");
			ps.setInt(1, bean.getC_rotation());
			ps.setString(2, bean.getC_type());
			ps.setString(2, bean.getC_no());
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			throw e;
		}
		catch (SQLException e) 
		{
			System.out.println("Update Error");
			throw e;
		}
		finally
		{
			try 
			{
				MySqlUtility.closeConnection(con);
			}
			catch (SQLException e) 
			{
				throw e;
			}
		}
		
	}

	@Override
	public void delete(CourseBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from course where c_no=?");
			ps.setString(1, bean.getC_no());
			ps.execute();
		}
		catch (ClassNotFoundException e) 
		{
			throw e;
		}
		catch (SQLException e) 
		{
			System.out.println("Delete Error");
			throw e;
		}
		finally
		{
			try 
			{
				MySqlUtility.closeConnection(con);
			}
			catch (SQLException e) 
			{
				throw e;
			}
		}	
	}
	
}
