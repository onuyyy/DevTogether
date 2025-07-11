package com.BE_13.DevTogether.entity.posts;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 게시글(Posts) 엔티티(Entity) 클래스.
 *
 * @author chan
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "Posts")
public class Post {

    // TODO: private PostsId id 으로 바뀔 수 있다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 게시글 아이디

    private String title; // 게시글 제목

    private String username; // 작성자

    private String code; // 작성 코드

    private String content; // 작성글

    private String author; // 작성자

    @CreatedDate
    private LocalDateTime createDate; // 생성일

    @LastModifiedDate
    private LocalDateTime updateDate; // 수정일

    // 기본 생성자
    @Builder
    public Post(String title, String code, String username, String content, String author) {
        this.title = title;
        this.code = code;
        this.username = username;
        this.content = content;
        this.author = author;
    }
}
