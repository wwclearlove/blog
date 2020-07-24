package com.wyc.util;

import com.wyc.model.Tag;
import com.wyc.model.Type;

import java.util.List;

public class FbUtil {
    public static List<Type> qc(List<Type> types){
        for (int i = 0; i <types.size() ; i++) {
            for (int j = 0; j <types.get(i).getBlogs().size() ; j++) {
                if (types.get(i).getBlogs().get(j).isPublished() != true) {
                    types.get(i).getBlogs().remove(j);
                    j--;
                }
            }
        }
        return  types;
    }
    public static List<Tag> tag(List<Tag> tags){
        for (int i = 0; i <tags.size() ; i++) {
            for (int j = 0; j <tags.get(i).getBlogs().size() ; j++) {
                if (tags.get(i).getBlogs().get(j).isPublished() != true) {
                    tags.get(i).getBlogs().remove(j);
                    j--;
                }
            }
        }
        return  tags;
    }
}
