package com.kh.semi.user.member.encrypt;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		// getParameter로 들어오는 요청 중 
		// 비밀번호를 요청할 경우 
		// 암호화 하여 전달한다.
		
		String value = "";
		
		if(name != null && name.equals("password")){
			// if라면 암호화된 비밀번호를 전달한다.
			value = getSHA512(super.getParameter(name));
			
		} else {
			// 아니라면 원래의 값을 전달한다.
			value = super.getParameter(name);
		}
		
		return value;
	}
	private static String getSHA512(String password){// 나혼자쓰는 하나만 있어도 되는 결과값으로 string을 반환하는 getSHA512메소드
		String result = null;
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = password.getBytes(Charset.forName("UTF-8"));
			System.out.println("비밀번호 : "+password);
			md.update(bytes);
			
			result = Base64.getEncoder().encodeToString(md.digest());// byte단위로 쪼개져있는걸 문자단위로 바꾸겠다.
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	

}
