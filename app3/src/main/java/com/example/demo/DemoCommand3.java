package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @author hwshin
 */
@Component
public class DemoCommand3 {
    @Autowired
    RestTemplate restTemplate;

    String APP_NAME_PREFIX = "demo-app";

    @Value("${spring.application.name}")
    String applicationName; // demo-app1

    String source;
    String response;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        restTemplate = new RestTemplate();
        return restTemplate;
    }

    String[] func = {"a", "b", "c"};

    @HystrixCommand(fallbackMethod = "fallback3")
    public String invoke3(Integer number, Integer maxIter, String message, String invoked) {
//        int len = applicationName.length();
//        int my = Integer.parseInt(applicationName.substring(len-1, len));
//        boolean b = Boolean.parseBoolean(invoked);

//        try {
            StringBuffer sb = new StringBuffer();

            sb.append("Hi, I'm " + applicationName + ".<br>");
            sb.append("My Message is " + message + ".<br>");
//            sb.append("invoked is " + invoked + ". b = " + b + ".<br>");
/*
            if (b) {
                sb.append("IF########### invoked is " + invoked + ". b = " + b + ".<br>");
                //int rand = new Random().nextInt(number) + 1;
                //if (Math.abs(rand - my) > 0) {
                //source = "https://" + APP_NAME_PREFIX + rand + "/start?invoked=false";
                source = "https://demo-app1/start?invoked=false&number=2";
                response = restTemplate.getForObject(source, String.class) + "<br>";
                sb.append(response);
                //}
            }
*/
            return sb.toString();

            //return restTemplate.getForObject("https://demo-app1/hello", String.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
    }

    public String fallback3(Integer number, Integer maxIter, String message, String invoked) {
        StringBuffer sb = new StringBuffer();

        sb.append("This is fallback message. number: " + number + ", maxIter: " + maxIter + "<br>");
        sb.append("Error from : " + source + "<br>");
        sb.append("Message : " + message + "<br>");
        sb.append("invoked : " + invoked + "<br>");

        return sb.toString();
    }

}
