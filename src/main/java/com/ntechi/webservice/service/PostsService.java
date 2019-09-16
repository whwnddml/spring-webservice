package com.ntechi.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntechi.webservice.domain.posts.PostsRepository;
import com.ntechi.webservice.dto.posts.PostsMainResponseDto;
import com.ntechi.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
