package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Chapter;
import com.wujie.project.pojo.ChapterReview;

import java.util.List;

public interface ChapterService {
    Integer countChapter(Integer bid);

    int addOrUpdateChapter(Chapter chapter);

    int deleteChapter(Integer cid);

    PageInfo<Chapter> selectChapterByBid(Integer pageNum, Integer pageSize, String bid);

    Integer selectSubPermission(Integer bid);

    Chapter selectChapterByCid(Integer cid);

    List<Chapter> selectAllChapterNumber(Integer bid);
}
