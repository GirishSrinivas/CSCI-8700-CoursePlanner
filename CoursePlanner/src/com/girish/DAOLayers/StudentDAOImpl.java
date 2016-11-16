package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.girish.util.MySqlUtility;

public class StudentDAOImpl implements StudentDAO 
{

	@Override
	public List<StudentBean> read() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		StudentBean bean = null;
		List<StudentBean> l = new ArrayList<>();
		try 
		{
			con = MySqlUtility.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			while(rs.next())
			{
				bean = new StudentBean();
			
				bean.setS_netid(rs.getString(1));
				bean.setLevel(rs.getString(2));
				bean.setMajor(rs.getString(3));
				bean.setConcentration(rs.getString(4));
				bean.setA_netid(rs.getString(5));
				
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
	public void write(StudentBean bean) throws ClassNotFoundException, SQLException
	{
		Connection con = null;

		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
			
			ps.setString(1, bean.getS_netid());
			ps.setString(2, bean.getLevel());
			ps.setString(3, bean.getMajor());
			ps.setString(4, bean.getConcentration());
			ps.setString(5, bean.getA_netid());

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
	public void update(StudentBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update student set s_level=?, s_major=?, s_conc=?, a_netid=? where s_netid=?");
			ps.setString(1, bean.getLevel());
			ps.setString(2, bean.getMajor());
			ps.setString(3, bean.getConcentration());
			ps.setString(4, bean.getA_netid());
			ps.setString(5, bean.getS_netid());
		
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
	public void delete(StudentBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where s_netid=?");
			ps.setString(1, bean.getS_netid());
			ps.execute();
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

}
