package com.wujie.project.controller;

import com.wujie.project.pojo.Tag;
import com.wujie.project.service.TagService;
import com.wujie.project.utils.ResultInfo;
import com.wujie.project.utils.vo.TagSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/selectAllTags")
    public ResultInfo selectAllTags(){
        List<Tag> tags = tagService.selectAllTags();
        return new ResultInfo(200,"查询成功",tags);
    }

    @RequestMapping("/setTags")
    public ResultInfo setTags(@RequestBody TagSet tagSet){
        tagService.setTags(tagSet);
        return new ResultInfo(200,"设置成功");
    }

    @RequestMapping("selectTagByBid")
    public ResultInfo selectTagByBid(String bid){
      List<String> res = tagService.selectTagByBid(bid);
      return new ResultInfo(200,"查询成功",res);
    }
}
