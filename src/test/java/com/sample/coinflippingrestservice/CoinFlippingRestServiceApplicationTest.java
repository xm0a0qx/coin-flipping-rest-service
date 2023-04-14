package com.sample.coinflippingrestservice;

import com.sample.coinflippingrestservice.coinflipper.controller.CoinFlipperController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoinFlippingRestServiceApplicationTest {
    private static final Pattern SINGLE_FLIP_PATTERN = Pattern.compile("HEAD|TAILS");
    private static final Pattern TOTAL_DATA_PATTERN = Pattern.compile("\"coinSite\":\"TAILS|HEADS\"(.*)\"tails|heads\":1");
    private static final Pattern MAX_ALLOWED_PATTERN = Pattern.compile("\"id\":100");
    private static final Pattern OVER_LIMIT_ALLOWED_PATTERN = Pattern.compile("\"id\":200");

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CoinFlipperController controller;

    @Test
    void contextLoad() {
        assertThat(controller).isNotNull();
    }

    @Test
    void shouldReturnSingleFlipResult() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/flips/1", String.class))
                .containsPattern(SINGLE_FLIP_PATTERN);
    }

    @Test
    void shouldReturnTotalReport() {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/v1/flips/1/total", String.class);
        assertThat(response).containsPattern(TOTAL_DATA_PATTERN);
    }

    @Test
    void shouldReturnNoMore100Results() {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/v1/flips/1000/total", String.class);
        assertThat(response).containsPattern(MAX_ALLOWED_PATTERN);
    }

    @Test
    void shouldReturnOver100Results() {
        String response = this.restTemplate.getForObject("http://localhost:" + port + "/v1/flips/1000", String.class);
        System.out.println(response);
        assertThat(response).containsPattern(OVER_LIMIT_ALLOWED_PATTERN);
    }
}