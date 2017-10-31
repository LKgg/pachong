package com.bin.gen.pachong.controller;

import com.bin.gen.pachong.entity.Context;
import com.bin.gen.pachong.pipeline.DataPipeline;
import com.bin.gen.pachong.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by mogo on 2017/10/17 0017.
 */
@Component
public class JianShuProcessor implements PageProcessor{
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        String title = page.getHtml().xpath("//h1[@class='post-title']/text()").toString();
        String text = page.getHtml().xpath("//article[@class='post clearfix']/p/text()").all().toString();
        Context mContext = new Context();
        mContext.setTitle(title);
        mContext.setText(text);
        page.putField("mContext",mContext);
        String next = page.getHtml().xpath("//li[@class='next']/a/@href").toString();
        page.addTargetRequest(next);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new JianShuProcessor())
                .addPipeline(new DataPipeline())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.luoxia.com/zhuxian/2019.htm")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();


    }

}
