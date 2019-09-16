package com.ntechi.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntechi.webservice.dto.posts.PostsSaveRequestDto;
import com.ntechi.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	

	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsService.save(dto);
	}
}
