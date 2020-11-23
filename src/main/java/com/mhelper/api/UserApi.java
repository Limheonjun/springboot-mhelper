package com.mhelper.api;

import com.mhelper.dto.UserDto;
import com.mhelper.entity.User;
import com.mhelper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usr")
public class UserApi {

    @Autowired
    UserRepository userRepository;

    //example
    @GetMapping("/")
    public String test() {
        return "hello";
    }

    //로그인 api
    @PostMapping("/login")
    public Map<String, Object> login(UserDto userDto, BindingResult result, HttpServletResponse response) {
        Map<String, Object> ret = new HashMap<>();

        if(result.hasErrors()) {
            response.setStatus(403);
            ret.put("status", false);
            ret.put("data", null);
            ret.put("msg", "아이디 또는 비밀번호를 다시 확인해 주세요");
            return ret;
        }

        Optional<User> optional = userRepository.findByEmail(userDto.getEmail());
        if(optional.isEmpty()) {
            response.setStatus(403);
            ret.put("status", false);
            ret.put("data", null);
            ret.put("msg", "존재하지 않는 아이디입니다");
            return ret;
        }

        User user = optional.get();
        if(!user.getPassword().equals(userDto.getPassword())) {
            response.setStatus(403);
            ret.put("status", false);
            ret.put("data", null);
            ret.put("msg", "비밀번호가 일치하지 않습니다");
            return ret;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        ret.put("status", false);
        ret.put("data", new UserDto(user));
        ret.put("msg", null);
        return ret;

    }

    //회원가입 api

    //아이디 중복확인 api

}
