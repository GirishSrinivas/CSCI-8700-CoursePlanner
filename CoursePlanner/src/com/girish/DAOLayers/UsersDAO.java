package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO 
{
	public List<UsersBean> read() throws ClassNotFoundException, SQLException;
	public void write(UsersBean bean) throws ClassNotFoundException, SQLException;
	public void update(UsersBean bean) throws ClassNotFoundException, SQLException;
	public void delete(UsersBean bean) throws ClassNotFoundException, SQLException;
}
