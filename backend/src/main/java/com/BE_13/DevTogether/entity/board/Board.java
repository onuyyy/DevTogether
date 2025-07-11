//package com.BE_13.DevTogether.entity.board;
//
//import com.BE_13.DevTogether.entity.posts.Posts;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
///**
// * 게시판(Board) 엔티티(Entity) 클래스.
// *
// * @author chan
// */
//@Entity(name = "Board")
//public class Board {
//
//    // TODO: private BoardId id
//    @Id
//    private long id; // 게시판 아이디
//
//    private String title; // 게시판 제목
//
//    // TODO: 게시판에 Posts가 필요할까요?
//    private Posts posts; // 게시글
//
//    // for hibernate
//    public Board() {
//    }
//
//    // Getter
//    public long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}
