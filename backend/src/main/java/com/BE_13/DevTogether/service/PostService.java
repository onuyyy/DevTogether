package com.BE_13.DevTogether.service;

import com.BE_13.DevTogether.dto.PostCreateRequest;
import com.BE_13.DevTogether.dto.PostResponse;
import com.BE_13.DevTogether.entity.posts.Post;
import com.BE_13.DevTogether.entity.posts.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 게시판(Board) 서비스(Service) 클래스이다.
 *
 * @author chan
 */
@Service
public class PostService {

    private final PostRepository postsRepository;

    public PostService(PostRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    // TODO: Post.Builder를 어디에 작성하는게 좋을까? 서비스? 아니면 dto? 아니면 아에 빌드 하는 클래스?
    // -> 팩토리 메서드 패턴을 사용해보자
    public PostResponse createPost(PostCreateRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .code(request.getCode())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();

        Post savedPost = postsRepository.save(post);
        return new PostResponse(savedPost);
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
    public Page<PostResponse> findAll(int page, int limit) {

        // 페이지에 표시할 데이터와 개수
        Pageable pageable = PageRequest.of(page - 1, limit); // 페이지는 0부터 시작

        // DB에서 pageable 만큼 반복하여 DTO를 생성하여 반환한다.
        return postsRepository.findAll(pageable)
                .map(PostResponse::new);
    }

    /**
     * 게시글 아이디(postId)로 특정 게시글을 조회한다.
     *
     * @param postId 게시글 아이디
     * @return postId 게시글
     */
    // 특정 게시글 조회
    public PostResponse findById(Long postId) {

        // 아이디 조회
        Post post = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 : " + postId));

        return new PostResponse(post);
    }
}
