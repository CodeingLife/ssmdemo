package com.ssmdemo.service;

import java.util.List;

import com.ssmdemo.vo.PersonVo;

public interface PersonService {
	 
    //新增一个Person对象
    void insert(PersonVo p);
    
    //根据主键id删除Person对象
    void deleteById(String id);
    
    //修改一个person对象
    void update(PersonVo p);
    
    //根据主键id查找Person对象
    PersonVo selectById(String id);
    
    //查找所有Person对象，返回集合类型
    List<PersonVo> selectAll();
}
