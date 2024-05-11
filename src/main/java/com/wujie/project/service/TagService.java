package com.wujie.project.service;

import com.wujie.project.pojo.Tag;
import com.wujie.project.utils.vo.TagSet;

import java.util.List;

public interface TagService {
    List<Tag> selectAllTags();

    void setTags(TagSet tagSet);

    List<String> selectTagByBid(String bid);
}
