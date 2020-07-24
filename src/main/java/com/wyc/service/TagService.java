package com.wyc.service;

import com.wyc.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);
    List<Tag>listTag();
    List<Tag>listTag(String ids);
    List<Tag> listTagTop(Integer size);
    Tag updateTag(Long id, Tag type);

    void deleteTag(Long id);
}
