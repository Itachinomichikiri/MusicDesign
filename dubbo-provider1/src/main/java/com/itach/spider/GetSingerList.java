package com.itach.spider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itach.entity.Singer;
import com.itach.inf.SingerDaoService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 王前银
 * 2019/4/12
 **/
//网易网站中歌手列表页，获取所有歌手的名称，歌手的hash。

 @Component
public class GetSingerList {

    @Reference
    SingerDaoService singerDaoService;

    public void RPCtest()
    {
         singerDaoService.UpdateSinger();
    }

    public  void  getAllSingerClassity(final String url) {

        long startTime=System.currentTimeMillis();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(8,12,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        GetSingerListThread thread;
        int ClassifyId[]={1001,1002,1003,2001,2001,2003,6001,6002,6003,7001,7002,7003,4001,4002,4003};
        for(int i=0;i<15;i++)
        {
            thread=new GetSingerListThread(ClassifyId[i], url);
            threadPoolExecutor.execute(thread);
        }

        threadPoolExecutor.shutdown();
        while (true) {//等待所有任务都执行结束
            if (threadPoolExecutor.isTerminated()) {//所有的子线程都结束了
                System.out.println("共耗时:"+(System.currentTimeMillis()-startTime)/1000.0+"s");
                break;
            }
        }
    }

    public List<Singer> getSigerFromDB()
    {
        return singerDaoService.RetrieveSinger();
    }

    class GetSingerListThread implements Runnable
    {
        private  int num;
        private String url;

        public GetSingerListThread() { }
        public GetSingerListThread(int num,String url)
        {
            this.num=num;
            this.url=url;
        }
        @Override
        public void run() {

            String SingerUrl = url + "cat?id=" + num + "&initial=";

            System.setProperty("webdriver.chrome.driver", "G:/Tools/ChromeDriver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            ChromeDriver driver = new ChromeDriver(chromeOptions);

            for(int initial=65;initial<=90;initial++)
            {

                String url_=SingerUrl;
                url_+=initial;
                driver.get(url_);
                //获取iframe中的页面。
                WebElement iframe = driver.findElementById("g_iframe");
                driver.switchTo().frame(iframe);

                String html=driver.getPageSource();
                Document document= Jsoup.parse(html);

                Elements elements=document.select("a[href~=(artist(\\?)id=)]").select("a[class~=(nm)]");

                for(int i=0;i<elements.size();i++)
                {
                    Singer singer=new Singer();
                    String singerName=elements.get(i).text();
                    String singerHash=elements.get(i).attr("href").trim().replace("/artist?id=","");

                    singer.setSingerName(singerName);
                    singer.setSingerHash(Integer.valueOf(singerHash));
                    singer.setSingerClassify(num+"");
                    System.out.println(singerName+" "+singerHash);
                    singerDaoService.CreateSinger(singer);
                }
            }
            driver.quit();
        }
    }
}
