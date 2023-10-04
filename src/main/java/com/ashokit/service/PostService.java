package com.ashokit.service;

import com.ashokit.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPostDto(PostDto postDto, Long userId, Long categoryId);

    PostDto updatePost(PostDto postDto, Long postId);

    void deletePost(Long postId);

    PostDto getPostById(Long postId);

    //get all posts by category
    List<PostDto> getPostsByCategory(Long categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Long userId);

    //search posts
    List<PostDto> searchPosts(String keyword);


}
