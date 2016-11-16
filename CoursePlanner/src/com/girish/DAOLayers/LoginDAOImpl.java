package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.girish.util.MySqlUtility;

public class LoginDAOImpl implements LoginDAO 
{

	@Override
	public List<LoginBean> read() throws ClassNotFoundException, SQLException 
	{
		{
			Connection con = null;
			LoginBean bean = null;
			List<LoginBean> l = new ArrayList<>();
			try 
			{
				con = MySqlUtility.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from login");
				while(rs.next())
				{
					bean = new LoginBean();
					
					bean.setNuid(rs.getInt(1));
					bean.setPwd(rs.getString(2));
					bean.setNetid(rs.getString(3));
					
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
	}

	@Override
	public void write(LoginBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?)");
			ps.setInt(1, bean.getNuid());
			ps.setString(2, bean.getPwd());
			ps.setString(3, bean.getNetid());
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
	public void update(LoginBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update login set pwd=? where nuid=?");
			ps.setString(1, bean.getPwd());
			ps.setInt(2, bean.getNuid());
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
	public void delete(LoginBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from login where nuid=?");
			ps.setInt(1, bean.getNuid());
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

	@Override
	public boolean login(LoginBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT count(*) from login where nuid=? and pwd=?");
			ps.setInt(1, bean.getNuid());
			ps.setString(2, bean.getPwd());
			ResultSet rs = ps.executeQuery();
			rs.next();
			if (rs.getInt("count") > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ClassNotFoundException e) 
		{
			throw e;
		}
		catch (SQLException e) 
		{
			System.out.println("Login Error");
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
