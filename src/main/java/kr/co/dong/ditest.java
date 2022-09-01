package kr.co.dong;

import org.springframework.beans.factory.annotation.Autowired;

public class ditest {
	@Autowired
	dione dio;
	
}

class dione{
	String hello1="hello";
	
	String hellomethod() {
		return "hello";
	}
}
