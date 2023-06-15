package moadda.moazzi;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

class WebClientTest {

	@Test
	void test() {
		WebClient client = WebClient.create();
		ResponseSpec responseSpec = client.get().uri("https://www.naver.com").retrieve();
		String responseBody = responseSpec.bodyToMono(String.class).block();
		System.out.println(responseBody);
	}

}
