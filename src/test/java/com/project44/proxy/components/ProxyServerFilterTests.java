package com.project44.proxy.components;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProxyServerFilterTests {

    @LocalServerPort
    int port;
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String urlPart = "/search?q=project44";

    @Test
    public void forwardedPatternGood() {
        String url = "http://localhost:" + this.port + "/google" + urlPart;
        String redirect = "https://www.google.com" + urlPart;
        ResponseEntity<String> result = this.restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.MOVED_PERMANENTLY, result.getStatusCode());
        assertTrue(result.getBody().contains(redirect));
    }
}
