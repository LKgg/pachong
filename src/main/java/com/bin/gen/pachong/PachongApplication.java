package com.bin.gen.pachong;

import com.bin.gen.pachong.controller.JianShuProcessor;
import com.bin.gen.pachong.pipeline.DataPipeline;
import com.bin.gen.pachong.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

@SpringBootApplication
@EnableScheduling
public class PachongApplication {

	public static void main(String[] args) {
		SpringApplication.run(PachongApplication.class, args);
	}

	@Autowired
	private JianShuProcessor mJianShuProcessor;
	@Autowired
	private DataPipeline mDataPipeline;

	@Scheduled(cron = "00 15 15 * * ?") // 每天15：15：00执行
	public void scheduler() {
		Spider.create(mJianShuProcessor)
				.addPipeline(mDataPipeline)
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://www.luoxia.com/zhuxian/2019.htm")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
	}
}
