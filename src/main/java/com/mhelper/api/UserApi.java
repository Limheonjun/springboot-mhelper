package com.mhelper.api;

import com.mhelper.entity.User;
import com.mhelper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usr")
public class UserApi {
    //example
    @GetMapping("/")
    public String test() {
        return "hello";
    }

    //로그인 api

    //회원가입 api

    //아이디 중복확인 api

}
