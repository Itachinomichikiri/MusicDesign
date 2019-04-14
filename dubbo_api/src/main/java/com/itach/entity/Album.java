package com.itach.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * wqy
 * 2019/4/11
 **/
public class Album implements Serializable {
    //专辑id
    private int id;
    //专辑名称
    private String albumName;
    //专辑发行时间
    private Date albumPublishTime;
    //专辑描述
    private String albumDescribe;
    //专辑歌手
    private String albumSinger;
    //专辑图片
    private String albumImg;
    //专辑hash
    private Long albumHash;
    //专辑发行公司
    private String albumPublishCompany;


    public String getAlbumSinger() {
        return albumSinger;
    }

    public void setAlbumSinger(String albumSinger) {
        this.albumSinger = albumSinger;
    }

    public String getAlbumPublishCompany() {
        return albumPublishCompany;
    }

    public void setAlbumPublishCompany(String albumPublishCompany) {
        this.albumPublishCompany = albumPublishCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getAlbumPublishTime() {
        return albumPublishTime;
    }

    public void setAlbumPublishTime(Date albumPublishTime) {
        this.albumPublishTime = albumPublishTime;
    }

    public String getAlbumDescribe() {
        return albumDescribe;
    }

    public void setAlbumDescribe(String albumDescribe) {
        this.albumDescribe = albumDescribe;
    }

    public String getAlbumImg() {
        return albumImg;
    }

    public void setAlbumImg(String albumImg) {
        this.albumImg = albumImg;
    }

    public Long getAlbumHash() {
        return albumHash;
    }

    public void setAlbumHash(Long albumHash) {
        this.albumHash = albumHash;
    }

    public Album(int id, String albumName, Date albumPublishTime, String albumDescribe, String albumSinger, String albumImg, Long albumHash,String albumPublishCompany) {
        this.id = id;
        this.albumName = albumName;
        this.albumPublishTime = albumPublishTime;
        this.albumDescribe = albumDescribe;
        this.albumSinger = albumSinger;
        this.albumImg = albumImg;
        this.albumHash = albumHash;
        this.albumPublishCompany=albumPublishCompany;
    }

    public Album() {
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", albumPublishTime=" + albumPublishTime +
                ", albumDescribe='" + albumDescribe + '\'' +
                ", albumSinger='" + albumSinger + '\'' +
                ", albumImg='" + albumImg + '\'' +
                ", albumHash=" + albumHash +
                ", albumPublishCompany=" + albumPublishCompany +
                '}';
    }
}
