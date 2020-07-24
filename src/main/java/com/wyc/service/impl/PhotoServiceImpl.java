package com.wyc.service.impl;


import com.wyc.NotFoundException;
import com.wyc.dao.PhotoRepository;
import com.wyc.model.Photo;
import com.wyc.model.Tag;
import com.wyc.service.PhotoService;
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
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;
    @Transactional
    @Override
    public Photo savePhoto(Photo photo) {
        photo.setCreateTime(new Date());
        return photoRepository.save(photo);
    }
    @Transactional
    @Override
    public Photo getPhoto(Long id) {
        return photoRepository.findOne(id);
    }

    @Override
    public Photo getPhotoByName(String name) {
        return photoRepository.findByDz(name);
    }

    @Override
    public List<Photo> listPhoto() {
        return photoRepository.findAll();
    }

    @Override
    public List<Photo> listPhoto(String ids) {
        return photoRepository.findAll(convertToList(ids));
    }

    @Override
    public List<Photo> listPhotoTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(0, size, sort);
        return photoRepository.findTop(pageable);
    }
    @Transactional
    @Override
    public Photo updatePhoto(Long id, Photo photo) {
        Photo t = photoRepository.findOne(id);
        photo.setCreateTime(new Date());
        if (t == null) {
            throw new NotFoundException("不存在该图片");
        }
        BeanUtils.copyProperties(photo,t);
        return photoRepository.save(t);
    }
    @Transactional
    @Override
    public Page<Photo> listPhoto(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }

    @Override
    public void deletePh(Long id) {
        photoRepository.delete(id);
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
