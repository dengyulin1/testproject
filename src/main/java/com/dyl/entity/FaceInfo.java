package com.dyl.entity;

import com.dyl.annotation.MultiTablePrefix;
import com.dyl.consts.GlobalConsts;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@MultiTablePrefix(shortName = GlobalConsts.T_NAME_FACE_INFO, schema = GlobalConsts.INTELLIF_FACE)
public class FaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)

    private long id;// 人脸编号

    @JsonIgnore
    private int accessories;// 配饰

    private int race;// 种族

    @JsonIgnore
    private int age;// 年龄

    @JsonIgnore
    @Lob
    @Column
    private byte[] faceFeature;// 人脸特征

    @JsonSerialize(using = ToStringSerializer.class)// 所属图片编号
    private Long fromImageId;

    @JsonIgnore
    private Long fromPersonId;// 所属人物编号

    @JsonIgnore
    private Long fromVideoId;// 所属视频编号

    @JsonIgnore
    private int gender;// 性别

    private String imageData;// 人脸图像数据

    @JsonIgnore
    @Column(nullable = true, columnDefinition = "int(1) default '0'")
    private int indexed;// 是否已经Lire索引

    private long sourceId;// 数据源ID

    private int sourceType;//数据源类型:0 摄像头 1 视频 2 图片

    private Date time;// 录入时间

    @JsonIgnore
    private int version = 0;// 版本号

    private String json;//json

    private BigInteger sequence;//序号

    private Integer quality;//图片质量

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccessories() {
        return accessories;
    }

    public void setAccessories(int accessories) {
        this.accessories = accessories;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getFaceFeature() {
        return faceFeature;
    }

    public void setFaceFeature(byte[] faceFeature) {
        this.faceFeature = faceFeature;
    }

    public Long getFromImageId() {
        return fromImageId;
    }

    public void setFromImageId(Long fromImageId) {
        this.fromImageId = fromImageId;
    }

    public Long getFromPersonId() {
        return fromPersonId;
    }

    public void setFromPersonId(Long fromPersonId) {
        this.fromPersonId = fromPersonId;
    }

    public Long getFromVideoId() {
        return fromVideoId;
    }

    public void setFromVideoId(Long fromVideoId) {
        this.fromVideoId = fromVideoId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public int getIndexed() {
        return indexed;
    }

    public void setIndexed(int indexed) {
        this.indexed = indexed;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public BigInteger getSequence() {
        return sequence;
    }

    public void setSequence(BigInteger sequence) {
        this.sequence = sequence;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }
}
