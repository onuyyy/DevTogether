package com.BE_13.DevTogether.dto.response;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 작성글(PostResponse) 리스트 응답(response) DTO 레코드(response) 클래스.
 *
 * @param posts    등록된 작성글 리스트
 * @param pageInfo 게시판 페이지
 * @author chan
 */
public record PostListResponse(List<PostSummaryResponse> posts, PageInfo pageInfo) {

}
