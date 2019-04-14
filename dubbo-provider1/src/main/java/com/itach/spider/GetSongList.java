package com.itach.spider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itach.entity.Album;
import com.itach.entity.Song;
import com.itach.inf.AlbumDaoService;
import com.itach.inf.SongDaoService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * wqy
 * 2019/4/13
 **/
@Component
public class GetSongList {

    @Reference
    AlbumDaoService albumDaoService;

    @Reference
    SongDaoService songDaoService;


    public void getSingleSingerMessage(ChromeDriver driver, String url) throws ParseException {
        ArrayList<String> AlbumIdList=new ArrayList<String>();
        driver.get(url);

        //获取iframe中的页面。
        WebElement iframe = driver.findElementById("g_iframe");
        driver.switchTo().frame(iframe);

        String html=driver.getPageSource();
        Document document= Jsoup.parse(html);
        Elements elements=document.select("ul[id=m-song-module]").select("li");

        Elements albumPage=document.select("a[class~=(zpgi)]");
        int i;

        for(i=0;i<elements.size();i++)
        {
            //String albumName=elements.get(i).select("div").attr("title");
            // String albumImg=elements.get(i).select("img").attr("src");
            String albumId=elements.get(i).select("a[data-res-id]").attr("data-res-id");
            //String albumTime=elements.get(i).select("span[class=s-fc3]").text();
            //System.out.println(albumName+" "+albumId +" "+ albumTime);
            AlbumIdList.add(albumId);
        }
        int albumPageNum=albumPage.size();
        for(int a=1;a<albumPageNum;a++)
        {
            String _url=url;
            _url=_url+"&limit=12&offset="+12*a;
            driver.get(_url);

            //获取iframe中的页面。
            iframe = driver.findElementById("g_iframe");
            driver.switchTo().frame(iframe);

            html=driver.getPageSource();
            document= Jsoup.parse(html);
            elements=document.select("ul[id=m-song-module]").select("li");
            int elementsSize=elements.size();
            for(i=0;i<elementsSize;i++)
            {
                // String albumName=elements.get(i).select("div").attr("title");
                //String albumImg=elements.get(i).select("img").attr("src");
                String albumId=elements.get(i).select("a[data-res-id]").attr("data-res-id");
                //String albumTime=elements.get(i).select("span[class=s-fc3]").text();
                //System.out.println(albumName+" "+albumId +" "+ albumTime);
                AlbumIdList.add(albumId);
            }
        }
        int AlbumIdListSize=AlbumIdList.size();
        for(i=0;i<AlbumIdListSize;i++)
        {
            String albumId=AlbumIdList.get(i);
            String albumUrl="https://music.163.com/#/album?id="+albumId;

            //System.out.println(albumUrl);
            driver.get(albumUrl);
            //获取iframe中的页面。
            iframe = driver.findElementById("g_iframe");
            driver.switchTo().frame(iframe);
            html=driver.getPageSource();
            document= Jsoup.parse(html);

            elements=document.select("div[class=topblk]");
            String albumName=elements.select("h2[class=f-ff2]").text();
            String messages=elements.select("p").text();
            String messagess[]=messages.replace("歌手：","a")
                    .replace("发行时间：","a")
                    .replace("发行公司：","a")
                    .split("a");
            String albumSinger=messagess[1];
            String albumTime=null;
            String albumCompany=null;
            if(messagess.length==4)
            {
                albumTime=messagess[2];
                albumCompany=messagess[3];
            }
            //System.out.println(albumName+"  "+albumSinger+" "+albumTime+" "+albumCompany);

            String albumDescribe=document.select("div[id=album-desc-dot]").text();
            //System.out.println(albumDescribe);

            Album album=new Album();
            album.setAlbumName(albumName);
            album.setAlbumSinger(albumSinger);
            album.setAlbumHash(Long.valueOf(albumId));
            album.setAlbumDescribe(albumDescribe);
           // album.setAlbumPublishTime(new SimpleDateFormat("YY-MM-DD").parse(albumTime));
            album.setAlbumPublishCompany(albumCompany);
            System.out.println(album);
            albumDaoService.CreateAlbum(album);

            elements=document.select("tbody").select("tr");
            int j;
            int elementsSize=elements.size();
            for(j=0;j<elementsSize;j++)
            {
                String songName=elements.get(j).select("span[class=txt]").select("b").attr("title");
                String songId=elements.get(j).select("span[class=txt]").select("a[href~=(song(\\?)id=)]").attr("href");
                String songTime=elements.get(j).select("td[class=s-fc3]").select("span[class=u-dur]").text();
                //System.out.println(songName+" "+songId+" "+songTime);
                Song song =new Song();
                song.setSongName(songName);
                song.setSongTime(new SimpleDateFormat("mm:ss").parse(songTime));
                song.setAlbumId(Integer.valueOf(albumId));

                songDaoService.CreateSong(song);
               /* Song song=new Song();
                song.setSongName(songName);
                song.setSongSinger(albumSinger);
                song.setSongTime(songTime);
                song.setSongId(songId);
                song.setSongAlbumName(albumName);
                song.setSongAlbumId(albumId);
                song.setSongDescribe(albumDescribe);
                song.setSongCompany(albumCompany);
                song.setSongPublishTime(albumTime);
*/

            }
        }
    }


}
