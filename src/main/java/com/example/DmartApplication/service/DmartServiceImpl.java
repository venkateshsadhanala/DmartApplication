package com.example.DmartApplication.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DmartApplication.Entity.DmartEntity;
import com.example.DmartApplication.repo.DmartRepo;

@Service
public class DmartServiceImpl implements DmartService {

	@Autowired
	private DmartRepo repo;

	@Override
	public DmartEntity createData(DmartEntity entity) {
		DmartEntity save = repo.save(entity);
		return save;
	}

	@Override
	public DmartEntity getData(int id) {
		Optional<DmartEntity> byId = repo.findById(id);
		if (byId.isEmpty()) {
			throw new RuntimeException("data not found");
		}
		DmartEntity dmartEntity = byId.get();
		return dmartEntity;
	}

	@Override
	public List<DmartEntity> getallData() {
		List<DmartEntity> all = repo.findAll();
		return all;
	}

	@Override
	public DmartEntity updateData(DmartEntity entity, int id) {
		Optional<DmartEntity> byId = repo.findById(id);

		if (byId.isPresent()) {
			DmartEntity dmartEntity = byId.get();

			if (entity.getName() != null && !(entity.getName().isEmpty())) {
				dmartEntity.setName(entity.getName());
			}
			if (entity.getAddress() != null && !(entity.getAddress().isEmpty())) {
				dmartEntity.setAddress(entity.getAddress());
			}
			if (entity.getEmail() != null && !(entity.getEmail().isEmpty())) {
				dmartEntity.setEmail(entity.getEmail());
			}
			if (entity.getVillage() != null && !(entity.getVillage().isEmpty())) {
				dmartEntity.setVillage(entity.getVillage());
			}
			if (entity.getPhno() != null && !(entity.getPhno().isEmpty())) {
				dmartEntity.setPhno(entity.getPhno());
			}
			return repo.save(dmartEntity);
		} 
		else {
			throw new RuntimeException("Data not found");
		}

	}

	@Override
	public void DeleteData(int id) {
		repo.deleteById(id);
	}

}
