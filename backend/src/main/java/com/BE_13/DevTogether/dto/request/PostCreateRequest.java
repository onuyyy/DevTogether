package com.BE_13.DevTogether.dto.request;

/**
 * 사용자 작성글 요청(request) DTO 레코드(record) 클래스.
 *
 * @param id      작성글 아이디
 * @param author  작성자
 * @param title   글 제목
 * @param code    사용자 작성 코드
 * @param content 본문
 * @author chan
 */
public record PostCreateRequest(Long id,
                                String title,
                                String code,
                                String content,
                                AuthorPostRequest author) {
}


