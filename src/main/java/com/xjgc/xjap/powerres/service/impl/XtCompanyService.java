package com.xjgc.xjap.powerres.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Company;
import com.xjgc.xjap.powerres.service.IXtCompanyService;

@Service("xtCompanyService")
@Scope(value="prototype")
@Transactional
public class XtCompanyService extends BaseService implements IXtCompanyService{
	
	@Override
	public Company getCompanyById(Integer companyId){
		return xtCompanyDao.GetCompanyById(companyId);
	};
	
	@Override
	public List<Company> findCompaniesByPage(int pageNum, int rows, Page page){
		return xtCompanyDao.findByPage(pageNum,rows);
	}

	@Override
	public List<Company> findCompanies() {
		return xtCompanyDao.listCompany();
	}

	@Override
	public long getCompanyTotal() {
		return xtCompanyDao.getTotal();
	}

}
