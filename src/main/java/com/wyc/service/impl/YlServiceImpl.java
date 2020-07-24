package com.wyc.service.impl;


import com.wyc.NotFoundException;
import com.wyc.dao.PhotoRepository;
import com.wyc.dao.YlRepository;
import com.wyc.model.Photo;
import com.wyc.model.Yl;
import com.wyc.service.PhotoService;
import com.wyc.service.YlService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class YlServiceImpl implements YlService {
    @Autowired
    private YlRepository ylRepository;
    @Transactional
    @Override
    public Yl saveYl(Yl yl) {
        return ylRepository.save(yl);
    }
    @Transactional
    @Override
    public Yl getYl(Long id) {
        return ylRepository.findOne(id);
    }



    @Override
    public List<Yl> listYl() {
        return ylRepository.findAll();
    }

    @Override
    public List<Yl> listYl(String ids) {
        return ylRepository.findAll(convertToList(ids));
    }

    @Override
    public List<Yl> listYlTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, size, sort);
        return ylRepository.findTop(pageable);
    }
    @Transactional
    @Override
    public Yl updateYl(Long id, Yl yl) {
        Yl one = ylRepository.findOne(id);

        if (one == null) {
            throw new NotFoundException("不存在该图片");
        }
        BeanUtils.copyProperties(yl,one);
        return ylRepository.save(one);
    }
    @Transactional
    @Override
    public Page<Yl> listYl(Pageable pageable) {
        return ylRepository.findAll(pageable);
    }

    @Override
    public void deletePh(Long id) {
        ylRepository.delete(id);
    }
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
}
