package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface LoginDAO 
{
	public List<LoginBean> read() throws ClassNotFoundException, SQLException;
	public void write(LoginBean bean) throws ClassNotFoundException, SQLException;
	public void update(LoginBean bean) throws ClassNotFoundException, SQLException;
	public void delete(LoginBean bean) throws ClassNotFoundException, SQLException;
	public boolean login(LoginBean bean) throws ClassNotFoundException, SQLException;
}
