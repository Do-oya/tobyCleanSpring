package dooya.splearn.application;

import dooya.splearn.application.provided.MemberRegister;
import dooya.splearn.application.required.EmailSender;
import dooya.splearn.application.required.MemberRepository;
import dooya.splearn.domain.Member;
import dooya.splearn.domain.MemberRegisterRequest;
import dooya.splearn.domain.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberRegister {
    private final MemberRepository memberRepository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberRegisterRequest registerRequest) {
        // check

        Member member = Member.register(registerRequest, passwordEncoder);

        memberRepository.save(member);

        emailSender.send(member.getEmail(), "등록을 완료해주세요", "아래 링크를 클릭해서 등록을 완료해주세요");

        return member;
    }
}
