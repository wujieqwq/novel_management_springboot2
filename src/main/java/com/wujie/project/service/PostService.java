package com.wujie.project.service;

import com.github.pagehelper.PageInfo;
import com.wujie.project.pojo.Post;

public interface PostService{
    PageInfo<Post> selectPostPage(Integer pageNum, Integer pageSize, Integer bid);

    int deletePostByPid(Integer pid);

    int insertPost(Post post);

    int updatePost(Post post);
}
