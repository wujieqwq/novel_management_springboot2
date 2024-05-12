package com.wujie.project.service;

import com.wujie.project.pojo.Chapter;

import java.util.List;

public interface ChapterService {
    Integer countChapter(String bid);

    int addOrUpdateChapter(Chapter chapter);

    int deleteChapter(String cid);

    List<Chapter> selectChapterByBid(String bid);

    Integer selectPreChapterStatus(String c);
}
