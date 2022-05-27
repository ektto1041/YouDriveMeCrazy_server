package kr.ac.Ajou.YMMC_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class YmmcAuthApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(YmmcAuthApplication.class, args);
		GameUserRepository gur = ctx.getBean(GameUserRepository.class);
		
		//gameuser player1 = gur.save(new gameuser("ahnsihun9208@gmail.com","aaa"));
	}

}
