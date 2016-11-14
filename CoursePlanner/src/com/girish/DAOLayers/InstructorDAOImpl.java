package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.girish.util.*;

public class InstructorDAOImpl implements InstructorDAO 
{

	@Override
	public List<InstructorBean> read() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		InstructorBean bean = null;
		List<InstructorBean> l = new ArrayList<>();
		try 
		{
			con = MySqlUtility.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from instructor");
			while(rs.next())
			{
				bean = new InstructorBean();
				
				bean.setInst_id(rs.getString(1));
				bean.setInst_fname(rs.getString(2));
				bean.setInst_lname(rs.getString(3));
				bean.setDept_id(rs.getString(4));
				
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
	public void write(InstructorBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?,?)");
			ps.setString(1, bean.getInst_id());
			ps.setString(2, bean.getInst_fname());
			ps.setString(3, bean.getInst_lname());
			ps.setString(4, bean.getDept_id());
		
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
	public void update(InstructorBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update instructor set dept_id=? where inst_id=?");
			ps.setString(1, bean.getDept_id());
			ps.setString(2, bean.getInst_id());
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
	public void delete(InstructorBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from instructor where inst_id=?");
			ps.setString(1, bean.getInst_id());
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
