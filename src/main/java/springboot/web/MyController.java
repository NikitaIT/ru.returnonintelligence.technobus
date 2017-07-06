package springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/api/")
public class MyController {


    @RequestMapping
    @ResponseBody
    public List<String> getAllApi(){
        List list = new ArrayList<String>();
        list.add("ALL API:");
        list.add("/getTime");

        return list;
    }


    //тест выводимой информации
    @RequestMapping("/getTime")
    @ResponseBody
    public List<String> getStrArr(){
        List list = new ArrayList<String>();
        list.add("8.00");
        list.add("8.15");
        list.add("8.20");
        list.add("8.25");
        list.add("8.30");

        return list;
    }


}
