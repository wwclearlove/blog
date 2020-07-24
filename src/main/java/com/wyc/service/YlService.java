package com.wyc.service;

import com.wyc.model.Blog;
import com.wyc.model.Photo;
import com.wyc.model.Yl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface YlService {
    Yl saveYl(Yl yl);

    Yl getYl(Long id);



    List<Yl>listYl();
    List<Yl>listYl(String ids);
    List<Yl> listYlTop(Integer size);
    Yl updateYl(Long id, Yl yl);
    Page<Yl> listYl(Pageable pageable);
    void deletePh(Long id);
}
