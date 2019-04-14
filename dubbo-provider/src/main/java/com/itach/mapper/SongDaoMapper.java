package com.itach.mapper;

import com.itach.entity.Song;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface SongDaoMapper {
    //插入数据库
    public int CreateSong(@Param("song") Song song);
    public int CreateSongs(ArrayList<Song> songs);

    //查询数据库
    public List<Song> RetrieveSong();
    public List<Song> RetrieveSong(String SongName);
    public List<Song> RetrieveSong(int SongId);

    //修改数据库
    public void UpdateSong();

    //删除歌手
    public void DeleteSong();
}
