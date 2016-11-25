package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.girish.util.*;

public class SectionDAOImpl implements SectionDAO 
{

	@Override
	public List<SectionBean> read() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		SectionBean bean = null;
		List<SectionBean> l = new ArrayList<>();
		try 
		{
			con = MySqlUtility.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from section");
			while(rs.next())
			{
				bean = new SectionBean();
				
				bean.setCourse_no(rs.getString(1));
				bean.setSection_id(rs.getString(2));
				bean.setTerm(rs.getString(3));
				bean.setYear(rs.getInt(4));
				bean.setInst_id(rs.getString(5));
				bean.setTotal_seats(rs.getInt(6));
				bean.setSeats_taken(rs.getInt(7));
				bean.setLoc(rs.getString(8));
				bean.setDays(rs.getString(9));
				bean.setS_date(rs.getString(10));
				bean.setE_date(rs.getString(11));
				bean.setS_time(rs.getString(12));
				bean.setE_time(rs.getString(13));
				
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
	public void write(SectionBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, bean.getCourse_no());
			ps.setString(2, bean.getSection_id());
			ps.setString(3, bean.getTerm());
			ps.setInt(4, bean.getYear());
			ps.setString(5, bean.getInst_id());
			ps.setInt(6, bean.getTotal_seats());
			ps.setInt(7, bean.getSeats_taken());
			ps.setString(8, bean.getLoc());
			ps.setString(9, bean.getDays());
			ps.setString(10, bean.getS_date());
			ps.setString(11, bean.getE_date());
			ps.setString(12, bean.getS_time());
			ps.setString(13, bean.getE_time());
			
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
	public void update(SectionBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update section set sec_term=?,sec_year=?,inst_id=?,sec_seats=?,sec_aseats=?,sec_loc=?,sec_sdays=?,sec_sdate=?,sec_edate=?,sec_stime=?,sec_etime=? where sec_sid=? and c_no=?");
			
			ps.setString(1, bean.getTerm());
			ps.setInt(2, bean.getYear());
			ps.setString(3, bean.getInst_id());
			ps.setInt(4, bean.getTotal_seats());
			ps.setInt(5, bean.getSeats_taken());
			ps.setString(6, bean.getLoc());
			ps.setString(7, bean.getDays());
			ps.setString(8, bean.getS_date());
			ps.setString(9, bean.getE_date());
			ps.setString(10, bean.getS_time());
			ps.setString(11, bean.getE_time());
			ps.setString(12, bean.getCourse_no());
			ps.setString(13, bean.getSection_id());
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
	public void delete(SectionBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		try 
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from section where sec_sid=?");
			ps.setString(1, bean.getSection_id());
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
	public List<Object []> customSelect(String s, int year) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		SectionBean beans = null;
		CourseBean beanc = null;
		List<Object []> l = new ArrayList<>();
		Object[] o;
		
		try
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update section set sec_year = ?");
			ps.setInt(1, year);
			ps.execute();
			
			PreparedStatement ps1 = con.prepareStatement(
					"SELECT section.c_id, sec_sid, c_name, sec_term, sec_year, sec_seats, sec_aseats, sec_enstat, sec_loc, sec_days, sec_stime, sec_etime, sec_sdate, sec_edate, inst_netid "
					+ "from section, course "
					+ "WHERE course.c_id = section.c_id AND "
					+ "c_rotation = ? AND sec_term = ? "
					+ "UNION "
					+ "SELECT section.c_id, sec_sid, c_name, sec_term, sec_year, sec_seats, sec_aseats, sec_enstat, sec_loc, sec_days, sec_stime, sec_etime, sec_sdate, sec_edate, inst_netid "
					+ "from section, course "
					+ "WHERE course.c_id = section.c_id AND "
					+ " c_rotation = 0 AND sec_term = ?");
		
			if(year % 2 == 0)
			{
				ps1.setInt(1, 2);
			}
			else
			{
				ps1.setInt(1, 1);
			}
			ps1.setString(2, s);
			ps1.setString(3, s);
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				o = new Object[2];
				beans = new SectionBean();
				beanc = new CourseBean();
				beans.setCourse_no(rs.getString(1));
				beans.setSection_id(rs.getString(2));
				beanc.setC_name(rs.getString(3));
				beans.setTerm(rs.getString(4));
				beans.setYear(rs.getInt(5));
				beans.setTotal_seats(rs.getInt(6));
				beans.setSeats_taken(rs.getInt(7));
				beans.setStatus(rs.getString(8));
				beans.setLoc(rs.getString(9));
				beans.setDays(rs.getString(10));
				beans.setS_time(rs.getString(11));
				beans.setE_time(rs.getString(12));
				beans.setS_date(rs.getString(13));
				beans.setE_date(rs.getString(14));
				beans.setInst_id(rs.getString(15));
				o[0] = beans;
				o[1] = beanc;
				
				l.add(o);
			}
			int yy = Calendar.getInstance().get(Calendar.YEAR);
			ps = con.prepareStatement("update section set sec_year = ?");
			ps.setInt(1, yy);
			ps.execute();
			
			
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
	public List<Object[]> customSelectTerm(String s) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		SectionBean beans = null;
		CourseBean beanc = null;
		List<Object []> l = new ArrayList<>();
		Object[] o;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		try
		{
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update section set sec_year = ?");
			ps.setInt(1, year);
			ps.execute();
			
			PreparedStatement ps1 = con.prepareStatement(
					"SELECT section.c_id, sec_sid, c_name, sec_term, sec_year, sec_seats, sec_aseats, sec_enstat, sec_loc, sec_days, sec_stime, sec_etime, sec_sdate, sec_edate, inst_netid "
					+ "from section, course "
					+ "WHERE course.c_id = section.c_id AND "
					+ "c_rotation = ? AND sec_term = ? "
					+ "UNION "
					+ "SELECT section.c_id, sec_sid, c_name, sec_term, sec_year, sec_seats, sec_aseats, sec_enstat, sec_loc, sec_days, sec_stime, sec_etime, sec_sdate, sec_edate, inst_netid "
					+ "from section, course "
					+ "WHERE course.c_id = section.c_id AND "
					+ " c_rotation = 0 AND sec_term = ?");
		
			if(year % 2 == 0)
			{
				ps1.setInt(1, 2);
			}
			else
			{
				ps1.setInt(1, 1);
			}
			ps1.setString(2, s);
			ps1.setString(3, s);
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				o = new Object[2];
				beans = new SectionBean();
				beanc = new CourseBean();
				beans.setCourse_no(rs.getString(1));
				beans.setSection_id(rs.getString(2));
				beanc.setC_name(rs.getString(3));
				beans.setTerm(rs.getString(4));
				beans.setYear(rs.getInt(5));
				beans.setTotal_seats(rs.getInt(6));
				beans.setSeats_taken(rs.getInt(7));
				beans.setStatus(rs.getString(8));
				beans.setLoc(rs.getString(9));
				beans.setDays(rs.getString(10));
				beans.setS_time(rs.getString(11));
				beans.setE_time(rs.getString(12));
				beans.setS_date(rs.getString(13));
				beans.setE_date(rs.getString(14));
				beans.setInst_id(rs.getString(15));
				o[0] = beans;
				o[1] = beanc;
				
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

	@Override
	public List<Object[]> customSelect() throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		SectionBean beans = null;
		CourseBean beanc = null;
		List<Object []> l = new ArrayList<>();
		Object[] o;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String term = null;
		
		if(month >= 1 && month <= 4)
		{
			term = "Summer";
		}
		else if(month >= 5 && month <= 7)
		{
			term = "Fall";
		}
		else
		{
			term = "Spring";
			year += 1;
		}
		
		try
		{	
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("update section set sec_year = ?");
			ps.setInt(1, year);
			ps.execute();
			
			PreparedStatement ps1 = con.prepareStatement(
					"SELECT section.c_id, sec_sid, c_name, sec_term, sec_year, sec_seats, sec_aseats, sec_enstat, sec_loc, sec_days, sec_stime, sec_etime, sec_sdate, sec_edate, inst_netid "
					+ "from section, course "
					+ "WHERE course.c_id = section.c_id AND "
					+ "c_rotation = ? AND sec_term = ? "
					+ "UNION "
					+ "SELECT section.c_id, sec_sid, c_name, sec_term, sec_year, sec_seats, sec_aseats, sec_enstat, sec_loc, sec_days, sec_stime, sec_etime, sec_sdate, sec_edate, inst_netid "
					+ "from section, course "
					+ "WHERE course.c_id = section.c_id AND "
					+ " c_rotation = 0 AND sec_term = ?");
		
			if(year % 2 == 0)
			{
				ps1.setInt(1, 2);
			}
			else
			{
				ps1.setInt(1, 1);
			}
			ps1.setString(2, term);
			ps1.setString(3, term);
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				o = new Object[2];
				beans = new SectionBean();
				beanc = new CourseBean();
				beans.setCourse_no(rs.getString(1));
				beans.setSection_id(rs.getString(2));
				beanc.setC_name(rs.getString(3));
				beans.setTerm(rs.getString(4));
				beans.setYear(rs.getInt(5));
				beans.setTotal_seats(rs.getInt(6));
				beans.setSeats_taken(rs.getInt(7));
				beans.setStatus(rs.getString(8));
				beans.setLoc(rs.getString(9));
				beans.setDays(rs.getString(10));
				beans.setS_time(rs.getString(11));
				beans.setE_time(rs.getString(12));
				beans.setS_date(rs.getString(13));
				beans.setE_date(rs.getString(14));
				beans.setInst_id(rs.getString(15));
				o[0] = beans;
				o[1] = beanc;
				
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
