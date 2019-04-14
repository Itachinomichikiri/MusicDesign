package com.itach.inf;

import com.itach.entity.Singer;

import java.util.ArrayList;
import java.util.List;

public interface SingerDaoService {
    //插入数据库
    public int CreateSinger(Singer singer);
    public int CreateSingers(ArrayList<Singer> singers);

    //查询数据库
    public List<Singer> RetrieveSinger();

    public List<Singer> RetrieveSinger(String singerName);
    public List<Singer> RetrieveSinger(int singerId);

    //修改数据库
    public void UpdateSinger();

    //删除歌手
    public void DeleteSinger();
}
