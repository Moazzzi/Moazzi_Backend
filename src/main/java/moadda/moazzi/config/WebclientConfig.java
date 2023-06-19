package moadda.moazzi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

@Configuration
public class WebclientConfig {
	
	@Bean
	public WebClient webClient() {
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
		uriBuilderFactory.setEncodingMode(EncodingMode.NONE);

		WebClient client = WebClient.builder()
		        .uriBuilderFactory(uriBuilderFactory)
		        .build();
		return client;
	}
}
