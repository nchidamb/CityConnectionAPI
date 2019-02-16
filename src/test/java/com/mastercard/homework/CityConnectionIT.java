package com.mastercard.homework;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityConnectionIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/connected");
    }

    @Test
    public void isConnected() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString() + "?origin=Boston&destination=Newark",
                String.class);
        assertThat(response.getBody(), equalTo("Yes"));
        
        response = template.getForEntity(base.toString() + "?origin=Boston&destination=Philadelphia", String.class);
        assertThat(response.getBody(), equalTo("Yes"));
        
        response = template.getForEntity(base.toString() + "?origin=Philadelphia&destination=Albany", String.class);
        assertThat(response.getBody(), equalTo("No"));
        
        response = template.getForEntity(base.toString() + "?origin=Boston&destination=Dallas", String.class);
        assertThat(response.getBody(), equalTo("No"));
        
    }
    
}
