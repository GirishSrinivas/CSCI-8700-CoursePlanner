package com.girish.DAOLayers;

import java.util.List;

public interface LoginDAO 
{
	public List<LoginBean> read();
	public void write(LoginBean bean);
	public void update(LoginBean bean);
	public void delete(LoginBean bean);
}
