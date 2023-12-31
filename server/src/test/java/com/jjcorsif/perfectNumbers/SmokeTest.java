package com.jjcorsif.perfectNumbers;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {

	@Autowired
	private PerfectNumberController perfectNumberController;

	@Test
	void contextLoads() throws Exception {
		assertThat(perfectNumberController).isNotNull();
	}

}
