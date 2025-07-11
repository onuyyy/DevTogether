package com.BE_13.DevTogether.controller.rest;

import com.BE_13.DevTogether.dto.PostCreateRequest;
import com.BE_13.DevTogether.entity.posts.Post;
import com.BE_13.DevTogether.entity.posts.PostRepository;
import com.BE_13.DevTogether.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * DecTogether API 컨트롤러 테스트 클래스이다.
 *
 * @author chan
 */
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PostRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @DisplayName("새로운 게시글을 생성한다.")
    @Test
    void createPost() throws Exception {

        //  given
        PostCreateRequest request = new PostCreateRequest();

        // 테스트 데이터
        request.setTitle("테스트 제목");
        request.setAuthor("테스트 작성자");
        request.setCode("테스트 작성 코드");
        request.setContent("테스트 작성 본문");

        // 테스트 데이터 -> JSON 변환
        String json = objectMapper.writeValueAsString(request);

        // when & then
        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("테스트 제목"))
                .andExpect(jsonPath("$.author").value("테스트 작성자"));
    }

    @DisplayName("게시글 목록을 페이지로 조회한다.")
    @Test
    void findAll() throws Exception {

        // given
        for (int i = 0; i < 20; i++) {
            postRepository.save(Post.builder()
                    .title("제목 : " + i)
                    .author("작성자 : " + i)
                    .content("본문 : " + i)
                    .build()
            );

        }

        // when & then
        mockMvc.perform(get("/api/posts")
                        .param("page", "1")
                        .param("limit", "5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(5))
                .andExpect(jsonPath("$.totalPages").value(4));
    }


    @DisplayName("특정 ID의 게시글을 조회한다.")
    @Test
    void findById() throws Exception {

        // given
        Post post = postRepository.save(Post.builder()
                .title("조회용 제목")
                .author("조회용 작성자")
                .content("내용")
                .build());

        // when & then
        mockMvc.perform(get("/api/posts/{postId}", post.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post.getId()))
                .andExpect(jsonPath("$.title").value("조회용 제목"));
    }


}