package com.mhelper.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject extends BaseTimeEntity{

    // 주제ID
    @Id @GeneratedValue
    @Column(name = "subject_id")
    private Long id;

    // 주제명
    private String subjectNm;

    //1:N(한개의 주제는 여러개의 문제를 가질 수 있음)
    @OneToMany(mappedBy = "subject")
    private List<Question> questions = new ArrayList<>();

}
