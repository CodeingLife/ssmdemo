package com.ssmdemo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssmdemo.service.PersonService;
import com.ssmdemo.vo.PersonVo;


@Controller
@RequestMapping("/person")
public class PersonController {
	 
    @Autowired
    PersonService personService;
    
    /**
     * ����return���ַ���"mvc"����ǰ��Spring MVC�����ļ�����ͼ�������õ�ǰ׺"/WEB-INF/views/"�ͺ�׺".jsp",
     * ������Ҫ����ת��Ҫ��ת����ҳ��·�����Ӹ�·��webapp�¿�ʼ����Ϊ/WEB-INF/views/mvc.jsp
     * */
    @RequestMapping(value="/mvc")
    public String testMvc() {
        return "index";//
    }
    
    /**
     * ����@ResponseBody��������ֱ�ӷ���һ��json���ݻ�ǰ�ˣ�
     * ע��Spring mvc�����ļ��в�Ҫ©��<mvc:annotation-driven/>
     * */
    @RequestMapping(value="/list")
    @ResponseBody
    public List<PersonVo> findAll() {
        List<PersonVo> list = personService.selectAll();
        return list;//����ͨ��ǰ�˷��ص�json���ݲ鿴����������
    } 
    
    /**
     * ����@PathVariable�����������url�еĶ�̬����
     * */
    @RequestMapping(value="/one/{id}")
    @ResponseBody
    public PersonVo findOne(@PathVariable("id") String id) {
        return personService.selectById(id);
    }
    
}
