package com.BE_13.DevTogether.dto.response;

import com.BE_13.DevTogether.entity.posts.Post;

import java.time.LocalDateTime;

/**
 * 작성글 조회 응답(Response) DTO 레코드(record) 클래스.
 *
 * @param id         게시글 아이디
 * @param title      게시글 제목
 * @param code       사용자 작성 코드
 * @param content    게시글 본문
 * @param author     작성자
 * @param createDate 작성일
 * @author chan
 */
public record PostSummaryResponse(Long id,
                                  String title,
                                  String code,
                                  String content,
                                  AuthorResponse author,
                                  LocalDateTime createDate) {

}
