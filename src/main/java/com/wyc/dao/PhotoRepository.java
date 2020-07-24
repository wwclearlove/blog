package com.wyc.dao;


import com.wyc.model.Photo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo,Long> {
    @Query("select t from Photo t where  t.dz=?1")
    Photo findByDz(String dz);
    @Query("select t from Photo t")
    List<Photo> findTop(Pageable pageable);
}
