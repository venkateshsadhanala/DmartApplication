package com.example.DmartApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DmartApplication.Entity.DmartEntity;
import com.example.DmartApplication.service.DmartServiceImpl;

@RestController
@RequestMapping("/dmart")
public class DmartController {

	@Autowired
	private DmartServiceImpl impl;

	@PostMapping("/posting")
	public ResponseEntity<DmartEntity> createData(@RequestBody DmartEntity entity) {
		DmartEntity data = impl.createData(entity);
		return new ResponseEntity<DmartEntity>(data, HttpStatus.OK);
	}

	@GetMapping("getting/{id}")
	public ResponseEntity<DmartEntity> getData(@PathVariable int id) {
		DmartEntity data = impl.getData(id);
		return new ResponseEntity<DmartEntity>(data, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public List<DmartEntity> getallData() {
		List<DmartEntity> getallData = impl.getallData();
		return getallData;
	}

	@PutMapping("/putting/{id}")
	public ResponseEntity<DmartEntity> updateData(@RequestBody DmartEntity entity, @PathVariable int id) {
		DmartEntity updateData = impl.updateData(entity, id);
		return new ResponseEntity<DmartEntity>(updateData, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void DeleteData(@PathVariable int id) {
		impl.DeleteData(id);
	}
}
