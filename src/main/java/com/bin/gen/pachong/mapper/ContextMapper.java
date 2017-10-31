package com.bin.gen.pachong.mapper;

import com.bin.gen.pachong.entity.Context;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by mogo on 2017/10/23 0023.
 */
@Mapper
public interface ContextMapper {

    @Insert("INSERT INTO context(title,text) VALUES(#{title}, #{text})")
    void insert(@Param("title") String title,@Param("text")  String text);

}
