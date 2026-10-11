package com.example.DmartApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DmartApplication.Entity.DmartEntity;

@Repository
public interface DmartRepo extends JpaRepository<DmartEntity, Integer> {

}
