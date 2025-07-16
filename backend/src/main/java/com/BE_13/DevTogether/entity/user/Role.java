package com.BE_13.DevTogether.entity.user;

/**
 * 사용자 역활 정의 열거형(Role) 클래스.
 *
 * @author chan
 */
public enum Role {

    USER("USER", "일반사용자"),

    ADMIN("ADMIN", "관리자");

    private final String key;

    private final String Description;

    Role(String key, String description) {
        this.key = key;
        this.Description = description;
    }

    // Getter
    public String getKey() {
        return key;
    }

    public String getDescription() {
        return Description;
    }
}
