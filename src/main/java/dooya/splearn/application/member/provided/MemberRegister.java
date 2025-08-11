package dooya.splearn.application.member.provided;

import dooya.splearn.domain.member.Member;
import dooya.splearn.domain.member.MemberRegisterRequest;
import jakarta.validation.Valid;

/**
 * 회원의 등록과 관련된 기능을 제공한다
 * */
public interface MemberRegister {
    Member register(@Valid MemberRegisterRequest registerRequest);

    Member activate(Long memberId);
}
