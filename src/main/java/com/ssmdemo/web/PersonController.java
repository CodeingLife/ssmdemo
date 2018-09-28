package com.ssmdemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssmdemo.resolver.exception.CustomException;
import com.ssmdemo.service.PersonService;
import com.ssmdemo.vo.PersonVo;


@Controller
@RequestMapping("/person")
public class PersonController {
	 
    @Autowired
    PersonService personService;
    
    /**
     * 这里return的字符串"mvc"加上前面Spring MVC配置文件中视图解析配置的前缀"/WEB-INF/views/"和后缀".jsp",
     * 构成了要请求转发要跳转到的页面路径，从根路径webapp下开始，即为/WEB-INF/views/mvc.jsp
     * */
    @RequestMapping(value="/mvc")
    public String testMvc(String a) {
        return "index";//
    }
    
    /**
     * 这里@ResponseBody代表方法是直接返回一个json数据回前端，
     * 注意Spring mvc配置文件中不要漏掉<mvc:annotation-driven/>
     * @throws CustomException 
     * */
    @RequestMapping(value="/list")
    @ResponseBody
    public List<PersonVo> findAll() throws CustomException {
        List<PersonVo> list = personService.selectAll();
        return list;//这里通过前端返回的json数据查看到完整数据
    } 
    
    /**
     * 其中@PathVariable用来获得请求url中的动态参数
     * */
    @RequestMapping(value="/one/{id}")
    @ResponseBody
    public PersonVo findOne(@PathVariable("id") String id) {
        return personService.selectById(id);
    }
    
}
