package com.itach.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itach.entity.Album;
import com.itach.inf.AlbumDaoService;
import com.itach.mapper.AlbumDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * wqy
 * 2019/4/12
 **/
@Service
public class AlbumServiceImp implements AlbumDaoService {

    @Autowired
    AlbumDaoMapper mapper;

    @Override
    public int CreateAlbum(Album album) {
        return mapper.CreateAlbum(album);
    }

    @Override
    public int CreateAlbums(ArrayList<Album> albums) {
        return 0;
    }

    @Override
    public List<Album> RetrieveAlbum() {
        return null;
    }

    @Override
    public List<Album> RetrieveAlbum(String AlbumName) {
        return null;
    }

    @Override
    public List<Album> RetrieveAlbum(int AlbumId) {
        return null;
    }

    @Override
    public void UpdateAlbum() {

    }

    @Override
    public void DeleteAlbum() {

    }
}
