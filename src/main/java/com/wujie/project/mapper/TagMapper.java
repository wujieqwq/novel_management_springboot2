package com.wujie.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wujie.project.pojo.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    @Select("select * from tag")
    ArrayList<Tag> selectAll();

    @Insert("insert into book_has_tag (bid,tid) values (#{bid},#{tid})")
    void insertBookTag(Integer bid, Integer tid);

    @Select("select tag.tid from book_has_tag bht,tag where bht.tid=tag.tid and bht.bid = #{bid}")
    List<String> selectTagByBid(Integer bid);
}
