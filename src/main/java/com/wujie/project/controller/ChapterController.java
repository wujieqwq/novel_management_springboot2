package com.wujie.project.controller;

import com.wujie.project.pojo.Chapter;
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
    public ResultInfo countChapter(String bid){
        Integer res = chapterService.countChapter(bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping("/addOrUpdateChapter")
    public ResultInfo addOrUpdateChapter(@RequestBody Chapter chapter){
        chapterService.addOrUpdateChapter(chapter);
        return new ResultInfo(200,"操作成功");
    }

    @RequestMapping("/selectChapterByBid")
    public ResultInfo selectChapterByBid(String bid){
        List<Chapter> chapters = chapterService.selectChapterByBid(bid);
        return new ResultInfo(200,"查询成功",chapters);
    }

    @RequestMapping("/deleteChapter")
    public ResultInfo deleteChapter(String cid){
        chapterService.deleteChapter(cid);
        return new ResultInfo(200,"删除成功");
    }

    @RequestMapping("/selectPreChapterStatus")
    public ResultInfo selectPreChapterStatus(Integer cid){
        if(cid==1){
          return new ResultInfo(200,"为查询到前一章",-1);
        }
        String c = String.valueOf(cid-1);
        Integer s = chapterService.selectPreChapterStatus(c);
        return new ResultInfo(200,"查询成功",s);
    }
}
