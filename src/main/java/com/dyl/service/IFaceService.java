package com.dyl.service;

import com.dyl.entity.FaceInfo;

import java.util.List;

public interface IFaceService {

    List<FaceInfo> findByIds(List<Long> idList);


}
