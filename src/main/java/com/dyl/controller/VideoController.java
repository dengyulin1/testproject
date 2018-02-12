package com.dyl.controller;

import com.dyl.entity.VideoDetail;
import com.dyl.service.IVideoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private IVideoDetailService videoDetailService;

    @RequestMapping("/video/details/list")
    public List<VideoDetail> getVideoListByCaseName(@RequestParam String caseName){

        return videoDetailService.getVideoByCaseNameWithQuery(caseName);

    }
}
