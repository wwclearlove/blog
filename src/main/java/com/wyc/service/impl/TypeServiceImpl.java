package com.wyc.service.impl;

import com.wyc.NotFoundException;
import com.wyc.dao.TypeRepository;
import com.wyc.model.Type;
import com.wyc.service.TypeService;
import com.wyc.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }
//    分页查询
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }
//大小由大到小排序
    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort=new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return typeRepository.findTop(pageable);
    }



    //    更新
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type one = typeRepository.findOne(id);
        if(one==null){
            throw  new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,one);
        return typeRepository.save(one);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }
}
