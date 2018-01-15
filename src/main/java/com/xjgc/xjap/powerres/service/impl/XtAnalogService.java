package com.xjgc.xjap.powerres.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.powerres.service.IXtAnalogService;

@Service("xtAnalogService")
@Transactional
public class XtAnalogService extends BaseService implements IXtAnalogService{

	@Override
	public Integer getIDByBreakerID(Integer breakId, Integer meastypeid) {
		// TODO Auto-generated method stub
		return xtAnalogDao.getIDByBreakerID(breakId, meastypeid);
	}

}
