package ltbyz.practice_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("ltbyz.practice_demo.wisdom_block.mapper")
@ServletComponentScan
public class PracticeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeDemoApplication.class, args);
	}

}
