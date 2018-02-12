package com.dyl.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="t_uploaded_vedio_detail")
public class VideoDetail implements Serializable{

    private static final long serialVersionUID = -6589638207755571638L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Long fromFileId;//来源文件ID

    private String videoName;//视频名称

    private Date recordingDate;//拍摄日期

    private String caseName;//案件名称

    private String videoSource;//视频来源

    private String comment;//备注

    private Long areaId;//区域ID

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFromFileId() {
        return fromFileId;
    }

    public void setFromFileId(Long fromFileId) {
        this.fromFileId = fromFileId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Date getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(Date recordingDate) {
        this.recordingDate = recordingDate;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getVideoSource() {
        return videoSource;
    }

    public void setVideoSource(String videoSource) {
        this.videoSource = videoSource;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}
