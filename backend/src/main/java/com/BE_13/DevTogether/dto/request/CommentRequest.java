package com.BE_13.DevTogether.dto.request;

/**
 * 댓글(comment) 요청(request) DTO 레코드(record) 클래스이다.
 *
 * @param author 댓글 작성자
 * @param content 작성한 댓글
 * @param parent 대댓글
 *
 * @author chan
 */
// TODO: author의 타입이 User 관련이 아니라 String이여도 괜찮은가?
public record CommentRequest(String author,
                             String content,
                             Long parent) {
}
