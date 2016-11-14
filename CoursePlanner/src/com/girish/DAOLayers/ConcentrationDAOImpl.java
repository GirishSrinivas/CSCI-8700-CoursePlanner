package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.girish.util.*;

public class ConcentrationDAOImpl implements ConcentrationDAO 
{

	@Override
	public List<ConcentrationBean> read() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		ConcentrationBean bean = null;
		List<ConcentrationBean> l = new ArrayList<>();
		try 
		{
			con = MySqlUtility.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from concentration");
			while(rs.next())
			{
				bean = new ConcentrationBean();
				
				bean.setConc_id(rs.getString(1));
				bean.setConc_name(rs.getString(2));
				
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
	public void write(ConcentrationBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into concentration values(?,?)");
			ps.setString(1, bean.getConc_id());
			ps.setString(2, bean.getConc_name());
			
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
	public void update(ConcentrationBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update concentration set conc_name=? where conc_id=?");
			ps.setString(1, bean.getConc_name());
			ps.setString(2, bean.getConc_id());
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
	public void delete(ConcentrationBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from concentration where conc_id=?");
			ps.setString(1, bean.getConc_id());
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
