package com.moven.service;

import java.util.List;

import com.moven.model.Production;

public interface ProductionService {

	public abstract List<Production> getProductionList();

	public abstract void addProduction(Production production);

	public abstract Production getProductionById(Integer id);

	public abstract void updateProduction(Production production);

	public abstract void deleteProduction(Integer id);
	
}