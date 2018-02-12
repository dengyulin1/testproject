package com.dyl.dao;

import com.dyl.entity.VideoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVideoDetailDao extends JpaRepository<VideoDetail,Long>{

    List<VideoDetail> findByCaseNameContaining(String caseName);

    List<VideoDetail> findByCaseNameLike(String caseName);

    @Query(value = "select * from t_uploaded_vedio_detail where case_name LIKE CONCAT('%',:caseName,'%')",nativeQuery = true)
    List<VideoDetail> findByCaseName(@Param("caseName") String caseName);
}
