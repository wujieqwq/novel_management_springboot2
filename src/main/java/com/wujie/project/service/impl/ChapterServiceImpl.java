package com.wujie.project.service.impl;

import com.wujie.project.mapper.ChapterMapper;
import com.wujie.project.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public Integer countChapter(String bid) {
        return chapterMapper.countChapter(bid);

    }
}
