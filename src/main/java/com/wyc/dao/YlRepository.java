package com.wyc.dao;


import com.wyc.model.Photo;
import com.wyc.model.Yl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YlRepository extends JpaRepository<Yl,Long> {
    @Query("select y from Yl y")
    List<Yl> findTop(Pageable pageable);
}
