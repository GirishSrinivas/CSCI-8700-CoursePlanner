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
					
					bean.setNet_id(rs.getString(1));
					bean.setFname(rs.getString(2));
					bean.setLname(rs.getString(3));
					bean.setRole(rs.getString(4));
					bean.setEmail(rs.getString(5));
					bean.setPwd(rs.getString(6));
					
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
			PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?,?,?,?)");
			ps.setString(1, bean.getNet_id());
			ps.setString(2, bean.getFname());
			ps.setString(3, bean.getLname());
			ps.setString(4, bean.getRole());
			ps.setString(5, bean.getEmail());
			ps.setString(6, bean.getPwd());
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
			PreparedStatement ps = con.prepareStatement("update login set pwd=? where net_id=?");
			ps.setString(1, bean.getPwd());
			ps.setString(2, bean.getNet_id());
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
			PreparedStatement ps = con
					.prepareStatement("delete from login where net_id=?");
			ps.setString(1, bean.getNet_id());
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
			PreparedStatement ps = con
					.prepareStatement("SELECT count(*) from login where net_id=? and pwd=?");
			ps.setString(1, bean.getNet_id());
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
