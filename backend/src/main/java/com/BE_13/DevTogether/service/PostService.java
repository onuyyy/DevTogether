package com.BE_13.DevTogether.service;

import com.BE_13.DevTogether.dto.request.PostCreateRequest;
import com.BE_13.DevTogether.dto.PostDetailResponse;
import com.BE_13.DevTogether.dto.response.AuthorResponse;
import com.BE_13.DevTogether.dto.response.PostSummaryResponse;
import com.BE_13.DevTogether.entity.posts.Post;
import com.BE_13.DevTogether.entity.posts.PostRepository;
import com.BE_13.DevTogether.entity.user.User;
import com.BE_13.DevTogether.entity.user.UserRepository;
import com.BE_13.DevTogether.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 게시판(Board) 서비스(Service) 클래스이다.
 *
 * @author chan
 */
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postsRepository;
    private final UserRepository userRepository;

    public Long createPost(PostCreateRequest request, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Post post = PostMapper.toEntity(request, user);

        Post savedPost = postsRepository.save(post);
        return savedPost.getId();
    }

    /**
     * 게시글 전체 조회.
     * 페이지는 0부터 시작한다.
     *
     * @param page  페이지 수
     * @param limit 표시할 게시글 개수
     * @return 게시글
     */
    // 게시글 전체 조회
    public Page<PostSummaryResponse> findAll(int page, int limit) {

        // 페이지에 표시할 데이터와 개수
        Pageable pageable = PageRequest.of(page - 1, limit); // 페이지는 0부터 시작

        Page<Post> postPage = postsRepository.findAll(pageable);

        return postPage.map(PostMapper::toSummaryResponse);
    }

    /**
     * 게시글 아이디(postId)로 특정 게시글을 조회한다.
     *
     * @param postId 게시글 아이디
     * @return postId 게시글
     */
    // 특정 게시글 조회
    public PostDetailResponse findById(Long postId) {

        // 아이디 조회
        Post post = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 : " + postId));

        return PostMapper.toDetailResponse(post);
    }
}
