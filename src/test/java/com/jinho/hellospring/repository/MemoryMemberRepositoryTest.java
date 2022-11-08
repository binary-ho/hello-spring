package com.jinho.hellospring.repository;

import com.jinho.hellospring.domain.Member;
import com.jinho.hellospring.repositiory.MemberRepository;
import com.jinho.hellospring.repositiory.MemoryMemberRepository;
import org.apache.juli.logging.Log;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    // 이제 세이브 함수가 작동하는지 확인할거야
    //ㅓunit의 @Test 호출
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(member);
        Member result2 = repository.findByName("spring").get();
        //System.out.println("result = " + (result == member));
//        assertThat(result2).isEqualTo(member);  // 가장 먼저 찾은 애를 뱉는구나
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
