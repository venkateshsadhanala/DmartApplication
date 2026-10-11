package com.example.DmartApplication.service;

import java.util.List;

import com.example.DmartApplication.Entity.DmartEntity;

public interface DmartService {

	public DmartEntity createData(DmartEntity entity);

	public DmartEntity getData(int id);

	public List<DmartEntity> getallData();

	public DmartEntity updateData(DmartEntity entity, int id);

	public void DeleteData(int id);
}
