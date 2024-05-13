package com.wujie.project.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.OperationRecordMapper;
import com.wujie.project.mapper.PostMapper;
import com.wujie.project.pojo.OperationRecord;
import com.wujie.project.pojo.Post;
import com.wujie.project.service.OperationRecordService;
import com.wujie.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private OperationRecordMapper operationRecordMapper;
    @Override
    public PageInfo<Post> selectPostPage(Integer pageNum, Integer pageSize, Integer bid) {
        PageHelper.startPage(pageNum,pageSize);
        List<Post> lp = postMapper.selectAllPostByBid(bid);
        return new PageInfo<>(lp);
    }

    @Override
    public int deletePostByPid(Integer pid) {
        return postMapper.deleteById(pid);
    }

    @Override
    public int insertPost(Post post) {
        int value = postMapper.insert(post);
        OperationRecord or = new OperationRecord();
        or.setOrDate(DateUtil.date());
        Integer l = postMapper.selectCount(new QueryWrapper<>());
        or.setPid(l);
        or.setUid(post.getUid());
        or.setOrContent("发布动态");
        operationRecordMapper.insert(or);
        return value;
    }

    @Override
    public int updatePost(Post post) {
        OperationRecord or = new OperationRecord();
        or.setOrDate(DateUtil.date());
        or.setPid(post.getPid());
        or.setUid(post.getUid());
        if (post.getTopStatus() == 1){
            or.setOrContent("设置置顶");
        }else{
            or.setOrContent("取消置顶");
        }
        operationRecordMapper.insert(or);
        return postMapper.updateById(post);
    }

}
