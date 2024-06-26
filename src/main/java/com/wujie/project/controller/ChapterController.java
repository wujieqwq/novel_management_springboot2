package com.wujie.project.controller;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Chapter;
import com.wujie.project.pojo.ChapterReview;
import com.wujie.project.service.ChapterService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapter")
@CrossOrigin
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    /*
    创建章节
    删除章节
    查询章节
     */
    @RequestMapping("/countChapter")
    public ResultInfo countChapter(Integer bid){
        Integer res = chapterService.countChapter(bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/addOrUpdateChapter")
    public ResultInfo addOrUpdateChapter(@RequestBody Chapter chapter){
        chapter.setChapterDate(DateUtil.date());
        chapterService.addOrUpdateChapter(chapter);
        return new ResultInfo(200,"操作成功");
    }

    @RequestMapping("/selectChapterByBid")
    public ResultInfo selectChapterByBid(Integer pageNum,Integer pageSize,String bid){
        PageInfo<Chapter> res = chapterService.selectChapterByBid(pageNum,pageSize,bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/deleteChapter")
    public ResultInfo deleteChapter(Integer cid){
        chapterService.deleteChapter(cid);
        return new ResultInfo(200,"删除成功");
    }

    @RequestMapping("/selectSubPermission")
    public ResultInfo selectPreChapterStatus(Integer bid){
        Integer res = chapterService.selectSubPermission(bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/selectChapterByCid")
    public ResultInfo selectChapterByCid(Integer cid){
        Chapter res = chapterService.selectChapterByCid(cid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/selectAllChapterNumber")
    public ResultInfo selectAllChapterNumber(Integer bid){
        List<Chapter> res = chapterService.selectAllChapterNumber(bid);
        return new ResultInfo(200,"查询成功",res);
    }
}
