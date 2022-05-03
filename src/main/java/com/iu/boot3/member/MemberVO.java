package com.iu.boot3.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberVO {
	@NotBlank
	private String id;
	@Size(min=3, max=12)
	private String pw;
	private String checkPw;
	@NotBlank(message = "이름을 입력해주세요.")
	private String name;
	@Email(message = "이메일 형식이 맞지 않습니다")
	@NotBlank(message="이메일을 입력해주세요.")
	private String email;
	private String phone;
	
	private MemberFilesVO memberFilesVO;
	private List<RoleVO> roleVOs;
}
