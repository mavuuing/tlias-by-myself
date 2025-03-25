package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //开启了对Servlet的支持
@SpringBootApplication
public class TliasWebBymyselfApplication {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebBymyselfApplication.class, args);
	}

}
