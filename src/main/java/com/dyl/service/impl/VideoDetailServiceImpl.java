package com.dyl.service.impl;

import com.dyl.dao.IVideoDetailDao;
import com.dyl.entity.VideoDetail;
import com.dyl.service.IVideoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VideoDetailServiceImpl implements IVideoDetailService{

    @Autowired
    private IVideoDetailDao videoDetailDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<VideoDetail> getVideoByCaseName(String caseName) {
        List<VideoDetail> videoDetailList = videoDetailDao.findByCaseNameContaining(caseName);
        return videoDetailList;
    }

    @Override
    public List<VideoDetail> getVideoByCaseNameWithQuery(String caseName) {
        String sql = "select * from t_uploaded_vedio_detail where case_name LIKE CONCAT('%',:caseName,'%')";
        Query query = this.entityManager.createNativeQuery(sql, VideoDetail.class);
        query.setParameter("caseName", caseName);
        List<VideoDetail> videoDetailList =  (ArrayList<VideoDetail>)query.getResultList();
        return videoDetailList;
    }

    @Override
    public List<VideoDetail> getVideoByCaseNameWithJDBCTemplate(String caseName) {
        String sql = "select * from t_uploaded_vedio_detail where case_name LIKE CONCAT('%',"+caseName+",'%')";
        List<VideoDetail> videoDetailList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<VideoDetail>(VideoDetail.class));
        return videoDetailList;
    }
}
