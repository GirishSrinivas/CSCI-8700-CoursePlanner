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
				bean.setGpa(rs.getDouble(6));
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
			ps.setDouble(6, bean.getGpa());
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
			PreparedStatement ps = con.prepareStatement("delete from enrolls where s_netid=? and c_id=? and sec_sid=? and sec_term=? and sec_year=?");
			ps.setString(1, bean.getNetid());
			ps.setString(2, bean.getC_id());
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
			ps.setDouble(1, bean.getGpa());
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

	@Override
	public boolean isPresent(EnrollsBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM enrolls "
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
	public List<Object[]> read(String netid) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		EnrollsBean bean = null;
		CourseBean cb = null;
		Object[] o = null;
		List<Object[]> l = new ArrayList<>();
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT enrolls.c_id, sec_sid, course.c_name, sec_term, sec_year, gpa, grade, status "
									+ "FROM enrolls, course "
									+ "WHERE enrolls.c_id=course.c_id AND s_netid=?");
			ps.setString(1, netid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				o = new Object[2];
				bean = new EnrollsBean();
				cb = new CourseBean();
					
				bean.setC_id(rs.getString(1));
				bean.setSec_id(rs.getString(2));
				cb.setC_name(rs.getString(3));
				bean.setTerm(rs.getString(4));
				bean.setYear(rs.getInt(5));
				bean.setGpa(rs.getDouble(6));
				bean.setGrade(rs.getString(7));
				bean.setStatus(rs.getString(8));
				
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
