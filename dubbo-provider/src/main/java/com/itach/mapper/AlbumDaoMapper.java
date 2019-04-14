package com.itach.mapper;

import com.itach.entity.Album;
import com.itach.inf.AlbumDaoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface AlbumDaoMapper{

    public int CreateAlbum(@Param("album") Album album);


    //int CreateAlbums(@Param("albums")ArrayList<Album> Albums);

}
