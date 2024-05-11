package com.wujie.project.service.impl;

import com.wujie.project.mapper.TagMapper;
import com.wujie.project.pojo.Tag;
import com.wujie.project.service.TagService;
import com.wujie.project.utils.vo.TagSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> selectAllTags() {
        return tagMapper.selectAll();
    }

    @Override
    public void setTags(TagSet tagSet) {
        List<String> tags = tagSet.getTags();
        String bid = tagSet.getBid();
        for(String i:tags){
            tagMapper.insertBookTag(bid,i);
        }
    }

    @Override
    public List<String> selectTagByBid(String bid) {
        return tagMapper.selectTagByBid(bid);
    }
}
