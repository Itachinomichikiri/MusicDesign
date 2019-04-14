package com.itach.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itach.entity.Album;
import com.itach.inf.AlbumDaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

/**
 * wqy
 * 2019/4/12
 **/

@RestController
public class TestController {
    @Reference
    AlbumDaoService daoService;

    @RequestMapping("/test")
    public void test()
    {
      /*  Album album=new Album(2,"albumname",new Date(2015,3,4),"describe",
                435345,"d:\\music",new Long(234232));
        daoService.CreateAlbum(album);*/
    }
}
