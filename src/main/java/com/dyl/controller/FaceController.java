package com.dyl.controller;

import com.dyl.entity.FaceInfo;
import com.dyl.service.IFaceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FaceController {

    @Autowired
    private IFaceService faceService;

    @ApiOperation(httpMethod = "POST",value = "根据ID查询人脸图片信息")
    @RequestMapping("/face/list")
    public List<FaceInfo> getFaceByIds(@RequestParam long id){

        return faceService.findByIds(Arrays.asList(id));

    }


}
