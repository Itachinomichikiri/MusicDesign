package com.itach.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itach.entity.Song;
import com.itach.inf.SongDaoService;
import com.itach.mapper.SingerDaoMapper;
import com.itach.mapper.SongDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * wqy
 * 2019/4/13
 **/
@Service
public class SongServiceImp implements SongDaoService {
    @Autowired
    SongDaoMapper songDaoMapper;

    @Override
    public int CreateSong(Song song) {
        return songDaoMapper.CreateSong(song);
    }

    @Override
    public int CreateSongs(ArrayList<Song> songs) {
        return 0;
    }

    @Override
    public List<Song> RetrieveSong() {
        return null;
    }

    @Override
    public List<Song> RetrieveSong(String SongName) {
        return null;
    }

    @Override
    public List<Song> RetrieveSong(int SongId) {
        return null;
    }

    @Override
    public void UpdateSong() {

    }

    @Override
    public void DeleteSong() {

    }
}
