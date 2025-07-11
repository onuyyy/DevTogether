package com.BE_13.DevTogether.controller.rest;

import com.BE_13.DevTogether.dto.request.PostCreateRequest;
import com.BE_13.DevTogether.dto.PostDetailResponse;
import com.BE_13.DevTogether.dto.response.PageInfo;
import com.BE_13.DevTogether.dto.response.PostCreateResponse;
import com.BE_13.DevTogether.dto.response.PostListResponse;
import com.BE_13.DevTogether.dto.response.PostSummaryResponse;
import com.BE_13.DevTogether.entity.posts.Post;
import com.BE_13.DevTogether.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판(Board) API 컨트롤러 클래스이다.
 *
 * @author chan
 */
@RequestMapping("/api/posts")
@RestController
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    /**
     * 새 게시글 작성
     *
     * @param request 작성한 게시글
     * @return 게시글 등록
     */
    @PostMapping
    public ResponseEntity<PostCreateResponse> createPost(@RequestBody PostCreateRequest request) {

        Long userId = request.author().id();
        Long postId = postService.createPost(request, userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PostCreateResponse(postId));
    }

    /**
     * 전체 게시글 목록 조회
     *
     * @param page  페이지 수
     * @param limit 등록된 게시글
     * @return 등록된 전체 게시글
     */
    @GetMapping
    public ResponseEntity<PostListResponse> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {

        Page<PostSummaryResponse> postPage = postService.findAll(page, limit);

        List<PostSummaryResponse> posts = postPage.getContent();
        PageInfo pageInfo = new PageInfo(postPage.getNumber() + 1, postPage.getTotalPages());

        PostListResponse response = new PostListResponse(posts, pageInfo);
        return ResponseEntity.ok(response);
    }

    /**
     * 특정 게시글 조회
     *
     * @param postId 조회할 게시글
     * @return 해당 게시글 조회
     */
    @GetMapping("/{postId}")
    public ResponseEntity<PostDetailResponse> findById(@PathVariable Long postId) {
        PostDetailResponse response = postService.findById(postId);
        return ResponseEntity.ok(response);
    }

}
