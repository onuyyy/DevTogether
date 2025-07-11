package com.BE_13.DevTogether.dto;

import com.BE_13.DevTogether.dto.response.AuthorResponse;
import com.BE_13.DevTogether.dto.response.CommentResponse;
import com.BE_13.DevTogether.entity.board.Board;
import com.BE_13.DevTogether.entity.posts.Post;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 게시글(Post) 상세 목록 조회 응답(response) DTO 레코드(record) 클래스.
 *
 * @param id         게시글 아이디
 * @param title      게시글 제목
 * @param code       사용자 작성 코드
 * @param content    게시글 본문
 * @param author     작성자
 * @param comments   댓글
 * @param createDate 작성일
 * @author chan
 */
public record PostDetailResponse(
        Long id,
        String title,
        String code,
        String content,
        AuthorResponse author,
        List<CommentResponse> comments,
        LocalDateTime createDate
) {
}
