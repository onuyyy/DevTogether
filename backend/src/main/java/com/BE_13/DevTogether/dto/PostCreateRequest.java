package com.BE_13.DevTogether.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * 게시글 작성 시 요청(Request) DTO 클래스이다.
 *
 * @author chan
 */
@Getter
@Setter
@NoArgsConstructor
public class PostCreateRequest {

    private String title; // 게시글 제목
    private String code; // 게시글 코드
    private String content; // 게시글 본문
    private String author; // 작성자

}
