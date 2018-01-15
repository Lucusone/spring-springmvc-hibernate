package com.xjgc.xjap.powerres.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.powerres.dao.IXtCompanyDao;
import com.xjgc.xjap.powerres.entity.Company;

@Repository("xtCompanyDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtCompanyDao extends PowerResBaseDao implements IXtCompanyDao{
	
	@Override
	public Company GetCompanyById(Integer companyId){
		return this.getHibernateDaoHelper().getEntityByKey(Company.class, companyId);
	}
	
	@Override
	public List<Company> findByPage(int page,int rows){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Company.class);
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}

	@Override
	public List<Company> listCompany() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Company.class);
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public long getTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Company.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}
}
