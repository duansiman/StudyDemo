package com.devin.java.restful;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by devin on 2016/12/23.
 */
public class RestTemplateTest {

    public static void main(String[] args) {

        String uri = "http://localhost:8080/greeting?name=User";

        RestTemplate restTemplate = new RestTemplate();
        Greeting greeting = restTemplate.getForObject(uri, Greeting.class);
        System.out.println(greeting);

        Greeting devin = restTemplate.getForObject("http://localhost:8080/hello/{name}", Greeting.class, "devin");
        System.out.println(devin);

        //使用HttpClient发起请求
        HttpClient httpClient = HttpClientBuilder.create().build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate rest = new RestTemplate(requestFactory);
        Greeting jack = rest.getForObject("http://localhost:8080/hello/{name}", Greeting.class, "Jack");
        System.out.println(jack);
    }
}
