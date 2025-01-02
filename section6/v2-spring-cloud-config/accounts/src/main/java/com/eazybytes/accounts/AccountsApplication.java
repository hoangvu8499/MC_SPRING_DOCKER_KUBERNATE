package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info =  @Info(
				title = "Accounts Microservice API Document",
				description = "Account API",
				version = "v1",
				contact = @Contact(
						name = "Ton That Hoang Vu",
						email = "hoangvu8499@gmail.com"
				),
				license = @License(
						name = "Apache2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Accounts Microservice API Document"
		)
)
//OpenAPIDefinition: add description for swagger overview
@EnableConfigurationProperties(value = {AccountContactInfoDto.class})
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
