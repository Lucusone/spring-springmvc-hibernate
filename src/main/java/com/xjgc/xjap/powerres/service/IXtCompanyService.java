package com.xjgc.xjap.powerres.service;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Company;

public interface IXtCompanyService {
	
	public Company getCompanyById(Integer companyId);
	
	public List<Company> findCompaniesByPage(int pageNum, int rows, Page page);
	
	public List<Company> findCompanies();
	
	public long getCompanyTotal();
	
}
