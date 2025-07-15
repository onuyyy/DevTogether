package com.BE_13.DevTogether.dto.response;

import com.BE_13.DevTogether.entity.posts.Post;

/**
 * 작성글 요청 응답(response) DTO 레코드(record) 클래스.
 *
 * @param id 작성한 게시글 아이디
 * @author chan
 */
public record PostCreateResponse(Long id) {
}
