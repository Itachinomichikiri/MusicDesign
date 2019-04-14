package com.itach.mapper;

import com.itach.entity.Singer;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface SingerDaoMapper {
    //插入数据库
    public int CreateSinger(@Param("singer") Singer singer);
    public int CreateSingers(@Param("singers") ArrayList<Singer> singers);

    //查询数据库
    public List<Singer> RetrieveSinger();

    public List<Singer> RetrieveSinger(String singerName);
    public List<Singer> RetrieveSinger(int singerId);

    //修改数据库
    public void UpdateSinger();

    //删除歌手
    public void DeleteSinger();
}
