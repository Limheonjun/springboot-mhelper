package com.mhelper.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhelper.dto.UserDto;
import com.mhelper.entity.User;
import com.mhelper.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void init(@Autowired UserRepository userRepository, @Autowired EntityManager em){
        User user = new User(null, "test@naver.com", "1234", "임헌준", null);
        userRepository.save(user);
        //em.flush();
        //em.clear();
    }

    @Test
    @DisplayName("로그인api - 빈값 검증")
    void loginApi01() throws Exception{

        UserDto userDto = new UserDto(null, "1234", null);
        String param = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/usr/login")
                .content(param)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }



}