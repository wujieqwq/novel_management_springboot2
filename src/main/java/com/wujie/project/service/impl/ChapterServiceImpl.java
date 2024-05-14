package com.wujie.project.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.ChapterMapper;
import com.wujie.project.pojo.Chapter;
import com.wujie.project.pojo.ChapterReview;
import com.wujie.project.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public Integer countChapter(Integer bid) {
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
    public int deleteChapter(Integer cid) {
        return chapterMapper.deleteById(cid);
    }

    @Override
    public PageInfo<Chapter> selectChapterByBid(Integer pageNum,Integer pageSize,String bid) {
        QueryWrapper<Chapter> qw = new QueryWrapper<>();
        qw.eq("bid",bid);
        qw.orderByDesc("cid");
        PageHelper.startPage(pageNum,pageSize);
        List<Chapter> res = chapterMapper.selectList(qw);
        return new PageInfo<>(res);
    }

    @Override
    public Integer selectSubPermission(Integer bid) {
        QueryWrapper<Chapter> qw1 = new QueryWrapper<>();
        QueryWrapper<Chapter> qw2 = new QueryWrapper<>();
        qw1.eq("bid",bid);
        qw1.eq("audit_status",0);
        qw1.le("chapter_date", DateUtil.date());
        qw2.eq("bid",bid);
        qw2.eq("audit_status",3);
        Integer l1 = chapterMapper.selectCount(qw1);
        Integer l2 = chapterMapper.selectCount(qw2);
        if (l2>=1||l1>1){
            return 1;
        }
        return 0;
    }

    @Override
    public Chapter selectChapterByCid(Integer cid) {
        return chapterMapper.selectById(cid);
    }

    @Override
    public List<Chapter> selectAllChapterNumber(Integer bid) {
        return chapterMapper.selectAllChapterNumber(bid);
    }
}
