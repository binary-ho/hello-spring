package com.jinho.hellospring.service;

import com.jinho.hellospring.domain.Member;
import com.jinho.hellospring.repositiory.MemberRepository;
import com.jinho.hellospring.repositiory.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

//@Transactional
//@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복 회원 검증. 있을 경우 save 실행하지 않는건가?
        memberRepository.save(member);
        return member.getId();
    }
    @Resource
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
