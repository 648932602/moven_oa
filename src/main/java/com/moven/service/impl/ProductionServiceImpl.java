package com.moven.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.moven.configration.DataOperation;
import com.moven.model.Production;
import com.moven.service.ProductionService;

@Service("productionService")
public class ProductionServiceImpl extends BaseServiceImpl implements ProductionService {

	@Override
	public List<Production> getProductionList() {
//		return genericDao.getObject(DataOperation.GET_PRODUCTION_LIST, null, List.class);
		return Collections.emptyList();
	}

	@Override
	public Production getProductionById(Integer id) {
		return genericDao.getObject(DataOperation.GET_PRODUCTION_BY_ID, id, Production.class);
	}
	
	@Override
	public void addProduction(Production production) {
		genericDao.saveObject(DataOperation.ADD_PRODUCTION, production);
	}
	
	@Override
	public void updateProduction(Production production) {
		genericDao.updateObject(DataOperation.UPDATE_PRODUCTION, production);
	}
	
	@Override
	public void deleteProduction(Integer id) {
		genericDao.updateObject(DataOperation.DELETE_PRODUCTION, id);
	}
	
}

