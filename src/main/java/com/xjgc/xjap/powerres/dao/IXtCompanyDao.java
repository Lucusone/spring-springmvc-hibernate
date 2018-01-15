package com.xjgc.xjap.powerres.dao;

import java.util.List;
import com.xjgc.xjap.powerres.entity.Company;

public interface IXtCompanyDao {
	
	public Company GetCompanyById(Integer companyId);
	
	public List<Company> findByPage(int pagenum,int rows);
	
	public List<Company> listCompany();

	public long getTotal();
}
