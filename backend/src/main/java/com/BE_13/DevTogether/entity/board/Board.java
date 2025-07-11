package com.BE_13.DevTogether.entity.board;

import com.BE_13.DevTogether.entity.posts.Post;
import com.BE_13.DevTogether.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시판(Board)의 엔티티(Entity) 클래스.
 *
 * @author chan
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Board")
public class Board {

    // TODO: private BoardId id
    @Id
    private long id; // 게시판 아이디

    private String title; // 게시판 제목

    private String description; // 게시판 설명

    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>(); // 게시글 리스트

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager; // 게시판 관리자

    /**
     * DTO로 바꾸어 view에 보여줄 엔티티 정보들이다.
     *
     * @param posts       게시글 객체
     * @param title       게시판 이름
     * @param description 게시판 설명
     */
    @Builder
    public Board(List<Post> posts, String title, String description) {
        this.posts = posts;
        this.title = title;
        this.description = description;
    }
}
