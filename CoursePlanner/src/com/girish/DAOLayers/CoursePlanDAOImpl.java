package com.girish.DAOLayers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.girish.util.MySqlUtility;

public class CoursePlanDAOImpl implements CoursePlanDAO
{

	@Override
	public List<Object[]> read(String netid) throws ClassNotFoundException, SQLException 
	{
		{
			Connection con = null;
			CoursePlanBean bean = null;
			CourseBean cb = null;
			Object[] o = null;
			List<Object[]> l = new ArrayList<>();
			try 
			{
				con = MySqlUtility.getConnection();
				PreparedStatement ps = con.prepareStatement("select crspln.c_id, sec_sid, course.c_name, sec_term, sec_year, grade "
										+ "from crspln, course "
										+ "WHERE course.c_id=crspln.c_id AND s_netid = ?");
				ps.setString(1, netid);
				 ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					o = new Object[2];
					bean = new CoursePlanBean();
					cb = new CourseBean();
					
					bean.setC_id(rs.getString(1));
					bean.setSec_id(rs.getString(2));
					cb.setC_name(rs.getString(3));
					bean.setTerm(rs.getString(4));
					bean.setYear(rs.getInt(5));
					bean.setGrade(rs.getString(6));

					o[0] = bean;
					o[1] = cb;
					
					l.add(o);
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
	public void write(CoursePlanBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into crspln values(?,?,?,?,?,?)");
			ps.setString(1, bean.getNetid());
			ps.setString(2, bean.getC_id());
			ps.setString(3, bean.getSec_id());
			ps.setString(4, bean.getTerm());
			ps.setInt(5, bean.getYear());
			ps.setString(6, bean.getGrade());
			
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
	public boolean isPresent(CoursePlanBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM crspln "
					+ "WHERE s_netid = ? AND "
					+ "c_id = ? AND "
					+ "sec_term = ? AND "
					+ "sec_year = ?");
			ps.setString(1, bean.getNetid());
			ps.setString(2, bean.getC_id());
			ps.setString(3, bean.getTerm());
			ps.setInt(4, bean.getYear());
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			if (rs.getInt(1) > 0)
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
			System.out.println("is present error...");
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
	public void delete(CoursePlanBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from crspln where s_netid=? and c_id=? and sec_term=? and sec_year=?");
			ps.setString(1, bean.getNetid());
			ps.setString(2, bean.getC_id());
			ps.setString(3, bean.getTerm());
			ps.setInt(4, bean.getYear());
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
