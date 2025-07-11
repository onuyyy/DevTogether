package com.BE_13.DevTogether.dto.request;

/**
 * 게시글 작성자 요청(request) DTO 레코드(record) 클래스.
 *
 * @param id 작성자 아이디
 * @param name 작성자 이름
 *
 * @author chan
 */
public record AuthorPostRequest(Long id, String name) {
}
