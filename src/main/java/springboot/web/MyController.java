package springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import springboot.model.AllTimeTable;


@Controller
@RequestMapping("/api/")
public class MyController {

    //вывод расписания движения
    @RequestMapping("/getTime")
    @ResponseBody
    public AllTimeTable getStrArr() {
        return AllTimeTable.getInstance();
    }

    @RequestMapping("/hello")
    public String showHelloWorld(){
        return "hello-world";
    }

}
