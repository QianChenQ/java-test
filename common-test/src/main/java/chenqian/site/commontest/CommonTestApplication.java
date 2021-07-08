package chenqian.site.commontest;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class CommonTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonTestApplication.class, args);
    }
    @Bean
	public Logger.Level feignLoggerLevel() {
		//这里记录所有，根据实际情况选择合适的日志level
		return Logger.Level.FULL;
	}
}
