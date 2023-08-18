package com.flamexander.springsecuritypack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityPackApplication {
	// Для запуска одной из версий безопасности, в Edit Configurations > VM Options
	// указываете: -Dspring.profiles.active=Имя_профиля
	//
	// Варианты профилей: dao, inmemory, jdbc, simplest
	// Spring автоматически подтянет нужный конфиг класс, и если требуется sql скрипты через flyway

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPackApplication.class, args);
	}
}
