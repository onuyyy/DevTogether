package com.BE_13.DevTogether.dto.response;

import com.BE_13.DevTogether.entity.user.Role;

/**
 * 유저 권한(Role) DTO 레코드(record) 클래스.
 *
 * @param key         유저 권한
 * @param description 권한 설명
 * @author chan
 */
public record RoleResponse(String key, String description) {

}
