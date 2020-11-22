package com.mhelper.entity;

import javax.persistence.*;

@Entity
public class Question extends BaseTimeEntity{

    // 문제ID
    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    // 질문
    private String question;

    // 답변
    private String answer;

    // 힌트
    private String hint;

    // 비고
    private String remark;

    //유저와 문제의 양방향 연관관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //주제와 문제의 양방향 연관관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
