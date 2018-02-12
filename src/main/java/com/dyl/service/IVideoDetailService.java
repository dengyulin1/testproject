package com.dyl.service;

import com.dyl.entity.VideoDetail;

import java.util.List;

public interface IVideoDetailService {

    List<VideoDetail> getVideoByCaseName(String caseName);

    List<VideoDetail> getVideoByCaseNameWithQuery(String caseName);

    List<VideoDetail> getVideoByCaseNameWithJDBCTemplate(String caseName);
}
