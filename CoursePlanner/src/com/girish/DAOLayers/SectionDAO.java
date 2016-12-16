package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface SectionDAO 
{
	public List<SectionBean> read() throws ClassNotFoundException, SQLException;
	public void write(SectionBean bean) throws ClassNotFoundException, SQLException;
	public void update(SectionBean bean) throws ClassNotFoundException, SQLException;
	public void delete(SectionBean bean) throws ClassNotFoundException, SQLException;
	public List<Object []> customSelect(String s, int year) throws ClassNotFoundException, SQLException;
	public List<Object []> customSelectTerm(String cid, String term, int year) throws ClassNotFoundException, SQLException;
	public List<Object []> customSelect() throws ClassNotFoundException, SQLException;
}
