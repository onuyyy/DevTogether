package com.BE_13.DevTogether.dto.response;

/**
 * 게시글(board), 댓글(comment) 작성자 dto 레코드(record) 클래스.
 *
 * @param id   작성자 아이디
 * @param username 작성자 이름
 * @param role 작성자 권한
 * @author chan
 */
public record AuthorResponse(Long id, String username, RoleResponse role) {

}
