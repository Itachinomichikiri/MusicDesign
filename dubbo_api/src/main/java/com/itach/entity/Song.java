package com.itach.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * wqy
 * 2019/4/11
 **/
public class Song  implements Serializable{
    //歌曲id
    private int id;
    //专辑id
    private int albumId;
    //歌曲名称
    private String songName;
    //歌手id
    private int singerId;
    //歌曲时长
    private Date songTime;
    //歌曲歌词
    private String songLyric;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public Date getSongTime() {
        return songTime;
    }

    public void setSongTime(Date songTime) {
        this.songTime = songTime;
    }

    public String getSongLyric() {
        return songLyric;
    }

    public void setSongLyric(String songLyric) {
        this.songLyric = songLyric;
    }



    public Song(int id, int albumId, String songName, int singerId, Date songTime, String songLyric) {
        this.id = id;
        this.albumId = albumId;
        this.songName = songName;
        this.singerId = singerId;
        this.songTime = songTime;
        this.songLyric = songLyric;
    }

    public Song() {
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", songName='" + songName + '\'' +
                ", singerId=" + singerId +
                ", songTime=" + songTime +
                ", songLyric='" + songLyric + '\'' +

                '}';
    }
}
