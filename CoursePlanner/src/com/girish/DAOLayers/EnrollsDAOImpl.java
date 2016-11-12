package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.girish.util.MySqlUtility;

public class EnrollsDAOImpl implements EnrollsDAO
{

	@Override
	public List<EnrollsBean> read() throws ClassNotFoundException, SQLException 
	{
		{
			Connection con = null;
			EnrollsBean bean = null;
			List<EnrollsBean> l = new ArrayList<>();
			try 
			{
				con = MySqlUtility.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from enrolls");
				while(rs.next())
				{
					bean = new EnrollsBean();
					
					bean.setNuid(rs.getInt(1));
					bean.setSec_id(rs.getString(2));
					bean.setTerm(rs.getString(3));
					bean.setYear(rs.getShort(4));
					
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
	public void write(EnrollsBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into enrolls values(?,?,?,?)");
			ps.setInt(1, bean.getNuid());
			ps.setString(2, bean.getSec_id());
			ps.setString(3, bean.getTerm());
			ps.setInt(4, bean.getYear());
			
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
	public void update(EnrollsBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update enrolls set term=?, year=? where nuid=? and section_id=?");
			ps.setString(1, bean.getTerm());
			ps.setInt(2, bean.getYear());
			ps.setInt(3, bean.getNuid());
			ps.setString(4, bean.getSec_id());
			
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
	public void delete(EnrollsBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from enrolls where nuid=? and section_id=?");
			ps.setInt(1, bean.getNuid());
			ps.setString(2, bean.getSec_id());
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
