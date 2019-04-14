package com.itach.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itach.entity.Singer;
import com.itach.inf.SingerDaoService;
import com.itach.mapper.SingerDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * wqy
 * 2019/4/13
 **/
//将服务所在包注册到dubbo服务中
@Service
public class SingerServiceImp implements SingerDaoService {
    @Autowired
    SingerDaoMapper mapper;

    @Override
    public int CreateSinger(Singer singer) {
        int result = mapper.CreateSinger(singer);
        return result;
    }

    @Override
    public int CreateSingers(ArrayList<Singer> singers) {
        return 0;
    }

    @Override
    public List<Singer> RetrieveSinger() {
        return mapper.RetrieveSinger();
    }

    @Override
    public List<Singer> RetrieveSinger(String singerName) {
        return null;
    }

    @Override
    public List<Singer> RetrieveSinger(int singerId) {
        return null;
    }

    @Override
    public void UpdateSinger() {
        System.out.println("RPC_Success");
    }

    @Override
    public void DeleteSinger() {

    }
}
