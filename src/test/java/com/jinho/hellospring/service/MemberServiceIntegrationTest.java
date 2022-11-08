package com.jinho.hellospring.service;

import com.jinho.hellospring.domain.Member;
import com.jinho.hellospring.repositiory.MemberRepository;
import com.jinho.hellospring.repositiory.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    //= new MemoryMemberRepository();


    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("jinho");
        member.setAge(30);

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void joinTest2() {
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("jinho2");
        member1.setAge(10);
        member2.setName("jinho2");
        member2.setAge(15);

        memberService.join(member1);
        //memberService.join(member2);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}