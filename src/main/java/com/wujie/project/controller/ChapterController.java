package com.wujie.project.controller;

import com.wujie.project.service.ChapterService;
import com.wujie.project.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("countChapter")
    public ResultInfo countChapter(String bid){
        Integer res = chapterService.countChapter(bid);
        return new ResultInfo(200,"查询成功",res);
    }

}
