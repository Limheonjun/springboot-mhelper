package com.mhelper.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseTimeEntity{

    // 유저ID
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    // 이메일
    private String email;

    // 비밀번호
    private String password;

    // 이름
    private String name;

    //1:N(한명의 유저는 여러개의 문제를 가질 수 있음)
    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();


}
