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
			
				bean.setNuid(rs.getInt(1));
				bean.setNet_id(rs.getString(2));
				bean.setFname(rs.getString(3));
				bean.setLname(rs.getString(4));
				bean.setLevel(rs.getString(5));
				bean.setMajor(rs.getString(6));
				bean.setConcentration(rs.getString(7));
				
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
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getNuid());
			ps.setString(2, bean.getNet_id());
			ps.setString(3, bean.getFname());
			ps.setString(4, bean.getLname());
			ps.setString(5, bean.getLevel());
			ps.setString(6, bean.getMajor());
			ps.setString(7, bean.getConcentration());

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
			PreparedStatement ps = con.prepareStatement("update student set major=?, concentration=? where nuid=?");
			ps.setString(1, bean.getMajor());
			ps.setString(2, bean.getConcentration());
			ps.setInt(3, bean.getNuid());
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
			PreparedStatement ps = con.prepareStatement("delete from student where nuid=?");
			ps.setInt(1, bean.getNuid());
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
