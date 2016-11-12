// DAO template

// DAO Interface

	public List<JavaBean> read() throws ClassNotFoundException, SQLException;
	public void write(JavaBean bean) throws ClassNotFoundException, SQLException;
	public void update(JavaBean bean) throws ClassNotFoundException, SQLException;
	public void delete(JavaBean bean) throws ClassNotFoundException, SQLException;


// DAOImpl

// 1. read()

	public List<LoginBean> read() throws ClassNotFoundException, SQLException 
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


// 2. write()
	
	public void write(LoginBean bean) throws ClassNotFoundException, SQLException 
	{
		Connection con = null;
		
		try {
			con = MySqlUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?,?,.....)");
			ps.setString(1, bean.getFname());
			ps.setString(//get the bean object to be set...);
			
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


// 3. modify 

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

// 4. delete

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
