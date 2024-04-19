package org.example.graphqltest.repository;

import org.example.graphqltest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
