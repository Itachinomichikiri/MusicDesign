package com.itach.inf;

import com.itach.entity.Album;

import java.util.ArrayList;
import java.util.List;

public interface AlbumDaoService {
    //插入数据库
    public int CreateAlbum(Album Album);
    public int CreateAlbums(ArrayList<Album> Albums);

    //查询数据库
    public List<Album> RetrieveAlbum();
    public List<Album> RetrieveAlbum(String AlbumName);
    public List<Album> RetrieveAlbum(int AlbumId);

    //修改数据库
    public void UpdateAlbum();

    //删除歌手
    public void DeleteAlbum();
}
