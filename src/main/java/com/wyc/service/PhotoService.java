package com.wyc.service;

import com.wyc.model.Blog;
import com.wyc.model.Photo;
import com.wyc.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoService {
    Photo savePhoto(Photo photo);

    Photo getPhoto(Long id);

    Photo getPhotoByName(String name);

    List<Photo>listPhoto();
    List<Photo>listPhoto(String ids);
    List<Photo> listPhotoTop(Integer size);
    Photo updatePhoto(Long id, Photo photo);
    Page<Photo> listPhoto(Pageable pageable);
    void deletePh(Long id);
}
