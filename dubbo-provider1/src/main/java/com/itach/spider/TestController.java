package com.itach.spider;

import com.itach.entity.Album;
import com.itach.entity.Singer;
import com.itach.inf.AlbumDaoService;
import com.itach.inf.SingerDaoService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * wqy
 * 2019/4/12
 **/
@RestController
public class TestController {

    @Autowired
    GetSingerList singerList;

    @Autowired
    GetSongList songList;


    @RequestMapping("/")
    public void tsst()
    {

        //singerList.RPCtest();
        //填充singer数据库
        //singerList.getAllSingerClassity("https://music.163.com/#/discover/artist/");


/*
        ArrayList<Singer> list= (ArrayList) singerList.getSigerFromDB();
        System.out.println(list.size());
        for(int i=0;i<list.size();i++)
        {
            System.setProperty("webdriver.chrome.driver","G:/Tools/ChromeDriver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            ChromeDriver driver = new ChromeDriver(chromeOptions);
            String url="https://music.163.com/#/artist/album?id="+list.get(i).getSingerHash();
            try {
                songList.getSingleSingerMessage(driver,url);
            } catch (ParseException e) {
                System.out.println("000000aaaaaaaaaaaaaaaaaaa");
                e.printStackTrace();
            }
            driver.close();
        }*/

        ArrayList<Singer> list= (ArrayList) singerList.getSigerFromDB();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++)
                {
                    System.setProperty("webdriver.chrome.driver", "G:/Tools/ChromeDriver/chromedriver.exe");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    ChromeDriver driver = new ChromeDriver(chromeOptions);
                    try {
                        songList.getSingleSingerMessage(driver,"https://music.163.com/#/artist/album?id="+list.get(i).getSingerHash());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    driver.quit();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1001;i<2000;i++)
                {
                    System.setProperty("webdriver.chrome.driver", "G:/Tools/ChromeDriver/chromedriver.exe");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    ChromeDriver driver = new ChromeDriver(chromeOptions);
                    try {
                        songList.getSingleSingerMessage(driver,"https://music.163.com/#/artist/album?id="+list.get(i).getSingerHash());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    driver.quit();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=2001;i<3000;i++)
                {
                    System.setProperty("webdriver.chrome.driver", "G:/Tools/ChromeDriver/chromedriver.exe");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    ChromeDriver driver = new ChromeDriver(chromeOptions);
                    try {
                        songList.getSingleSingerMessage(driver,"https://music.163.com/#/artist/album?id="+list.get(i).getSingerHash());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    driver.quit();
                }
            }
        }).start();


/*        int index[]=new int[9];
        for(int i=0;i<9;i++)
        {
            index[i]=list.size()/9*(i+1);
        }


        //获取歌曲信息的线程池
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        GetMessageThread thread=null;

        for(int i=0;i<8;i++) {
            if (i == 0) {
                thread = new GetMessageThread(0, index[i], list);
            } else {
                thread = new GetMessageThread(index[i], index[i + 1], list);
            }

            poolExecutor.execute(thread);
            System.out.println("线程池中线程数目："+poolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    poolExecutor.getQueue().size()+"，已执行玩别的任务数目："+poolExecutor.getCompletedTaskCount());
        }*/

    }

   /* class GetMessageThread implements Runnable {

        private int index;
        private int endindex;
        private  ArrayList<Singer> list;

        public GetMessageThread(int index, int endindex,ArrayList<Singer> list) {
            this.index = index;
            this.endindex = endindex;
            this.list=list;
        }
        public void run() {
            System.setProperty("webdriver.chrome.driver", "G:/Tools/ChromeDriver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            for (int i=index;i<endindex;i++) {
                ChromeDriver driver = new ChromeDriver(chromeOptions);
                try {
                    songList.getSingleSingerMessage(driver,"https://music.163.com/#/artist/album?id="+list.get(index).getSingerHash());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                driver.quit();
            }
        }
    }*/
}
