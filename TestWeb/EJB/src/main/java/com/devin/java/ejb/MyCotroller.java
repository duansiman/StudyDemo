package com.devin.java.ejb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by devin on 2016/12/23.
 */
@Controller
public class MyCotroller {

    @Autowired
    MyComponent myComponent;

}
