package com.BE_13.DevTogether.entity.user;

import com.BE_13.DevTogether.entity.comment.Comment;
import com.BE_13.DevTogether.entity.posts.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 유저(User) 엔티티(Entity) 클래스이다.
 *
 * @author chan
 */
@Getter
@Table(name = "Users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User implements UserDetails {
    // TODO: private UserId id 로 바뀔 수 있다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 아이디

    private String password;

    private String username; // 작성자

    @Enumerated(EnumType.STRING)
    private Role role; // 유저 권한

    private Long loginFailCount;

    @OneToMany(mappedBy = "author")
    private List<Post> uploadedPosts = new ArrayList<>(); // 유저가 작성한 포스트 리스트

    @OneToMany(mappedBy = "author")
    private List<Comment> uploadedComment = new ArrayList<>(); // 유저가 작성한 댓글 리스트

    @CreatedDate
    private LocalDateTime createDate; // 생성일자

    @Builder
    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Builder
    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getKey()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
