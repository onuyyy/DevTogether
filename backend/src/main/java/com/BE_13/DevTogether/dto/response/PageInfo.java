package com.BE_13.DevTogether.dto.response;

import org.springframework.data.domain.Page;

/**
 * 게시판(Board)의 페이지 응답(Response) DTO 레코드(record) 클래스.
 *
 * @param currentPage 게시판의 현재 페이지
 * @param totalPage   게시판의 모든 페이지
 * @author chan
 */
public record PageInfo(int currentPage, int totalPage) {

}
