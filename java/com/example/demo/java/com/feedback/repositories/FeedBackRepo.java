package com.feedback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedback.models.FeedBack;

public interface FeedBackRepo extends JpaRepository <FeedBack,Integer>{

}
