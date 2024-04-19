package org.example.graphqltest.controller;

import lombok.RequiredArgsConstructor;
import org.example.graphqltest.entity.Member;
import org.example.graphqltest.repository.MemberRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @QueryMapping
    public Member getMember(@Argument Long id) {
        return memberRepository.findById(id).get();
    }

    @QueryMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @MutationMapping
    public Member alter(@Argument Long id, @Argument String name) {
        return memberRepository.save(
                Member.builder()
                        .id(id)
                        .name(name)
                        .build()
        );
    }

    @MutationMapping
    public Member save(@Argument String name){
        return memberRepository.save(
                Member.builder()
                        .name(name)
                        .build()
        );
    }
}
