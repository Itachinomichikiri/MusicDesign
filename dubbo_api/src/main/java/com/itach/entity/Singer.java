package com.itach.entity;

import java.io.Serializable;

/**
 * wqy
 * 2019/4/11
 **/
public class Singer implements Serializable {
    //歌手id
    private int id;
    //歌手名称
    private String singerName;
    //歌手hash值
    private int singerHash;
    //歌手简介
    private String singerDescribe;
    //歌手图片
    private String singerImg;
    //歌手分类
    private String singerClassify;

    public Singer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getSingerHash() {
        return singerHash;
    }

    public void setSingerHash(int singerHash) {
        this.singerHash = singerHash;
    }

    public String getSingerDescribe() {
        return singerDescribe;
    }

    public void setSingerDescribe(String singerDescribe) {
        this.singerDescribe = singerDescribe;
    }

    public String getSingerImg() {
        return singerImg;
    }

    public void setSingerImg(String singerImg) {
        this.singerImg = singerImg;
    }

    public String getSingerClassify() {
        return singerClassify;
    }

    public void setSingerClassify(String singerClassify) {
        this.singerClassify = singerClassify;
    }

    public Singer(int id, String singerName, int singerHash, String singerDescribe, String singerImg, String singerClassify) {
        this.id = id;
        this.singerName = singerName;
        this.singerHash = singerHash;
        this.singerDescribe = singerDescribe;
        this.singerImg = singerImg;
        this.singerClassify = singerClassify;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", singerName='" + singerName + '\'' +
                ", singerHash=" + singerHash +
                ", singerDescribe='" + singerDescribe + '\'' +
                ", singerImg='" + singerImg + '\'' +
                ", singerClassify='" + singerClassify + '\'' +
                '}';
    }
}
