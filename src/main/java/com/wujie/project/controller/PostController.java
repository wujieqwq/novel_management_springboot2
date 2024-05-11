package com.wujie.project.controller;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Post;
import com.wujie.project.service.PostService;
import com.wujie.project.utils.ResultInfo;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/selectAllPost")
    private ResultInfo selectAllPost(Integer pageNum,Integer pageSize,String bid){
        PageInfo<Post> res = postService.selectPostPage(pageNum,pageSize,bid);
        return new ResultInfo(200,"查询成功",res);
    }

    @RequestMapping(value = "/{pid}",method = RequestMethod.DELETE)
    private ResultInfo deletePostByPid(@PathVariable String pid){
        postService.deletePostByPid(pid);
        return new ResultInfo(200,"删除成功");
    }

    @RequestMapping("/insertPost")
    private ResultInfo insertPost(Post post,HttpSession session){
        String uid = (String) session.getAttribute("uid");
        post.setUid(uid);
        postService.insertPost(post);
        return new ResultInfo(200,"创建成功");
    }

    @RequestMapping("/updatePost")
    public ResultInfo updatePost(String pid,Integer topStatus){
        Post post = new Post();
        post.setPid(pid);
        post.setTopStatus(topStatus);
        postService.updatePost(post);
        return new ResultInfo(200,"修改成功");
    }

}
