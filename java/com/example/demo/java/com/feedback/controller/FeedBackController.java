package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.models.FeedBack;
import com.feedback.service.FeedBackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin("*")
public class FeedBackController {

	
	@Autowired
	private FeedBackService fservice;
	
	@PostMapping("/addf")
	public FeedBack AddFeedback(@RequestBody FeedBack feedback) {
		return fservice.addFeedback(feedback);
	}
	@GetMapping("/allf")
    public List<FeedBack> getAllFeedback() {
        return fservice.getAllFeedback();
    }
}
