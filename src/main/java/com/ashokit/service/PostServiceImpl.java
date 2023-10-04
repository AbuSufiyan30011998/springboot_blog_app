package com.ashokit.service;

import com.ashokit.entities.Category;
import com.ashokit.entities.Post;
import com.ashokit.entities.User;
import com.ashokit.exceptions.ResourceNotFoundException;
import com.ashokit.payload.PostDto;
import com.ashokit.repository.CategoryRepo;
import com.ashokit.repository.PostRepository;
import com.ashokit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;


    @Override
    public PostDto createPostDto(PostDto postDto, Long userId, Long categoryId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "category id", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post savePost = postRepository.save(post);
        return modelMapper.map(savePost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));

        Category category = categoryRepo.findById(postDto.getCategory().getCategoryId()).get();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        post.setCategory(category);

        Post updatedPost = this.postRepository.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

        this.postRepository.delete(post);
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        List<Post> posts = postRepository.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
        List<Post> posts = this.postRepository.findByUser(user);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
