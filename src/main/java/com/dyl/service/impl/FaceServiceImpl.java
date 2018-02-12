package com.dyl.service.impl;

import com.dyl.dao.impl.FaceDaoImpl;
import com.dyl.entity.FaceInfo;
import com.dyl.service.IFaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceServiceImpl implements IFaceService {

    @Autowired
    private FaceDaoImpl faceDao;

    @Override
    public List<FaceInfo> findByIds(List<Long> idList) {
        return faceDao.findByIds(idList);
    }
}
