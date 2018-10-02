package com.elina.demo.viewController;

import com.elina.demo.configs.URLs;
import com.elina.demo.configs.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(name = URLs.URL, method = RequestMethod.GET)
    public String getModel(){
        return Views.VIEW;
    }
}
