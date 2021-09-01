package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplicaiton 어노테이션을쓰면 안에 내장된 @ComponentScan을 통해 어노테이션이 자동적으로 빈 과 의존성주입을 관리해준다..
@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
