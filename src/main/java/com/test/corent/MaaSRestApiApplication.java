package com.test.corent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaaSRestApiApplication {

public static void main(String[] args) {
SpringApplication.run(MaaSRestApiApplication.class, args);
System.out.println(java.lang.Runtime.getRuntime().maxMemory());
}

}
