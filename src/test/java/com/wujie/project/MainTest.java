package com.wujie.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.wujie.project.mapper.*;
import com.wujie.project.pojo.Adaptation;
import com.wujie.project.pojo.BookReview;
import com.wujie.project.pojo.Sign;
import com.wujie.project.pojo.Tag;
import com.wujie.project.service.AdaptationService;
import com.wujie.project.service.impl.AdaptationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MainTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OperatorMapper operatorMapper;
    
    @Autowired
    private ViolationRecordMapper violationRecordMapper;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private SignMapper signMapper;

    @Autowired
    private BookReviewMapper bookReviewMapper;

    @Autowired
    private AdaptationMapper adaptationMapper;

    @Test
    public void test(){
        List<Adaptation> adaptations = adaptationMapper.selectAdaptationByBid("1",null);
    }
}
