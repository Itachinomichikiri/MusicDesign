package com.itach.inf;

import com.itach.entity.Song;
import java.util.ArrayList;
import java.util.List;

public interface SongDaoService {
    //插入数据库
    public int CreateSong(Song song);
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
