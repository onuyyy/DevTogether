package com.BE_13.DevTogether.dto;

import com.BE_13.DevTogether.entity.posts.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String code;
    private final String content;
    private final String author;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.code = post.getCode();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createAt =  post.getCreateDate();
        this.updateAt = post.getUpdateDate();
    }
}
