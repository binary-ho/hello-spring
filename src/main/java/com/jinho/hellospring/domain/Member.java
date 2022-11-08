package com.jinho.hellospring.domain;

import javax.persistence.*;


@Entity
public class Member {

    // id 같은걸 내가 지정해주는 것이 아니라 알아서 만들어주는거면
    // Identity 전략이라고 부름
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
