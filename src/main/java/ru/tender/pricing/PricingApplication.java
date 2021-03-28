package ru.tender.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import ru.tender.pricing.util.ApplicationUtil;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PricingApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PricingApplication.class);
		ApplicationUtil.addDefaultProfile(app);
		Environment environment = app.run(args).getEnvironment();
		ApplicationUtil.logApplicationStartup(environment);
	}

}
