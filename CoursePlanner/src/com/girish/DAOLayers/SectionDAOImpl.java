package com.girish.DAOLayers;

import java.sql.*;
import java.util.ArrayList;
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
				bean.setS_date(rs.getDate(10));
				bean.setE_date(rs.getDate(11));
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
			ps.setDate(10, bean.getS_date());
			ps.setDate(11, bean.getE_date());
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
			ps.setDate(8, bean.getS_date());
			ps.setDate(9, bean.getE_date());
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

}
