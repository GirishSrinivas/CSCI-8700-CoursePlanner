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
					
					bean.setNetid(rs.getString(1));
					bean.setC_id(rs.getString(2));
					bean.setSec_id(rs.getString(3));
					bean.setTerm(rs.getString(4));
					bean.setYear(rs.getShort(5));
					bean.setGpa(rs.getInt(6));
					bean.setGrade(rs.getString(7));
					bean.setStatus(rs.getString(8));
					
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
			PreparedStatement ps = con.prepareStatement("insert into enrolls values(?,?,?,?,?,?,?,?)");
			ps.setString(1, bean.getNetid());
			ps.setString(2, bean.getC_id());
			ps.setString(3, bean.getSec_id());
			ps.setString(4, bean.getTerm());
			ps.setInt(5, bean.getYear());
			ps.setInt(6, bean.getGpa());
			ps.setString(7, bean.getGrade());
			ps.setString(8, bean.getStatus());
			
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
	public void updateStatus(EnrollsBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update enrolls set status=? where s_netid=? and sec_sid=? and sec_term=? and sec_year=?");
			ps.setString(1, bean.getStatus());
			ps.setString(2, bean.getNetid());
			ps.setString(3, bean.getSec_id());
			ps.setString(4, bean.getTerm());
			ps.setInt(5, bean.getYear());
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
			PreparedStatement ps = con.prepareStatement("delete from enrolls where s_netid=? and sec_term=? and sec_year=?");
			ps.setString(1, bean.getStatus());
			ps.setString(2, bean.getNetid());
			ps.setString(3, bean.getSec_id());
			ps.setString(4, bean.getTerm());
			ps.setInt(5, bean.getYear());
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
	public void updateGPA(EnrollsBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update enrolls set gpa=? and grade=? and status=? where s_netid=? and sec_sid=? and sec_term=? and sec_year=?");
			ps.setInt(1, bean.getGpa());
			ps.setString(2, bean.getGrade());
			ps.setString(3, bean.getStatus());
			ps.setString(4, bean.getNetid());
			ps.setString(5, bean.getSec_id());
			ps.setString(6, bean.getTerm());
			ps.setInt(7, bean.getYear());
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
	
}
