package com.ssmdemo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssmdemo.mapper.PersonMapper;
import com.ssmdemo.vo.PersonVo;

@Service
public class PersonServiceImpl implements PersonService {
	 
    @Resource
    PersonMapper personMapper;

    @Override
    public void insert(PersonVo p) {
        personMapper.insert(p);
    }

    @Override
    public void deleteById(String id) {
        personMapper.deleteById(id);
    }

    @Override
    public void update(PersonVo p) {
        personMapper.update(p);
    }

    @Override
    public PersonVo selectById(String id) {
        return personMapper.selectById(id);
    }

    @Override
    public List<PersonVo> selectAll() {
        return personMapper.selectAll();
    }
    
}
