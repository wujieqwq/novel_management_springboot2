package com.wujie.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wujie.project.mapper.ChapterMapper;
import com.wujie.project.pojo.Chapter;
import com.wujie.project.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public Integer countChapter(String bid) {
        return chapterMapper.countChapter(bid);

    }

    @Override
    public int addOrUpdateChapter(Chapter chapter) {
        if (chapter.getCid()==null){
            return chapterMapper.insert(chapter);
        }
        return chapterMapper.updateById(chapter);
    }

    @Override
    public int deleteChapter(String cid) {
        return chapterMapper.deleteById(cid);
    }

    @Override
    public List<Chapter> selectChapterByBid(String bid) {
        QueryWrapper<Chapter> qw = new QueryWrapper<>();
        qw.eq("bid",bid);
        List<Chapter> res = chapterMapper.selectList(qw);
        return res;
    }

    @Override
    public Integer selectPreChapterStatus(String c) {
        return chapterMapper.selectPreChapterStatus(c);
    }


}
