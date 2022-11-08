package com.jinho.hellospring;

import com.jinho.hellospring.aop.TimeTraceAop;
import com.jinho.hellospring.repositiory.*;
import com.jinho.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//@Configuration
//public class SpringConfig {
//
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
//
//
//
//
////    private DataSource dataSource;
////    @Autowired
////    public SpringConfig(DataSource dataSource) {
////        this.dataSource = dataSource;
////    }
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    /*@Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }*/
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
//}

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 스프링 데이터 JPA가 SpringDataJpaMemberRepository를 스프링 빈으로 자동으로 등록해준다

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

}