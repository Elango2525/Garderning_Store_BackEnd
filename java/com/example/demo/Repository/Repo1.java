package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Model1;
@Repository
public interface Repo1 extends JpaRepository<Model1,Long>{

}