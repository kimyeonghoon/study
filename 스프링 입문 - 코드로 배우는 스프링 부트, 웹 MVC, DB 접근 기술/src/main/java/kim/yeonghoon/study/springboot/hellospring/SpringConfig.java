package kim.yeonghoon.study.springboot.hellospring;

import kim.yeonghoon.study.springboot.hellospring.domain.Member;
import kim.yeonghoon.study.springboot.hellospring.repository.MemberRepository;
import kim.yeonghoon.study.springboot.hellospring.repository.MemoryMemberRepository;
import kim.yeonghoon.study.springboot.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
