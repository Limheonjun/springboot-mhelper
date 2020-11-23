package com.mhelper.dto;

import com.mhelper.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    // 이메일
    @NotEmpty
    private String email;

    // 비밀번호
    @NotEmpty
    private String password;

    // 이름
    private String name;

    public UserDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }

}
