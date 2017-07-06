package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ilyaros on 06.07.2017.
 */

@Controller
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }


    @RequestMapping("/hello")
    public String showHelloWorld(){
        return "hello-world";
    }

}
