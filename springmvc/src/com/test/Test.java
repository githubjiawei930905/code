package com.test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class Test {
	@RequestMapping(value = "/t", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String test() {
		System.out.println(12);
		return "ÄãºÃ";
	}
}
