package com.xjgc.xjap.powerres.dao.impl;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.dao.IXtAnalogDao;
import com.xjgc.xjap.powerres.dao.IXtBayDao;
import com.xjgc.xjap.powerres.entity.Analog;
import com.xjgc.xjap.powerres.entity.Bay;

@SuppressWarnings("all")
@Repository("xtAnalogDao")
@Scope(value="prototype")

public class XtAnalogDao extends PowerResBaseDao implements IXtAnalogDao{

	@Override
	public Integer getIDByBreakerID(Integer breakId,Integer meastypeid) {
		// TODO Auto-generated method stub
		String equipObject= "BK_"+breakId;
		String hql = "from Analog where equipObject = ? and meastypeid = ?";
		
		List<Analog> analog =this.getHibernateDaoHelper().findByHql(hql, new Object[]{equipObject,meastypeid});
		if(analog != null && analog.size() != 0)
		{
			return analog.get(0).getId();
		}
		else {
			return -1;
		}
		
		
	}

	

}
