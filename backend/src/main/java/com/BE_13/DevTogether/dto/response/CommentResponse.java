package com.BE_13.DevTogether.dto.response;

import com.BE_13.DevTogether.entity.comment.Comment;

import java.time.LocalDateTime;

/**
 * 게시글(Board) 상세 페이지 댓글(comment) 응답(Response) DTO 레코드(record) 클래스.
 *
 * @param id         댓글 아이디
 * @param postId     게시글 아이디
 * @param comment    댓글 내용
 * @param author     작성자
 * @param parent     대댓글
 * @param createDate 작성일
 * @author chan
 */
public record CommentResponse(Long id,
                              Long postId,
                              AuthorResponse author,
                              String comment,
                              Long parent,
                              LocalDateTime createDate) {


}
