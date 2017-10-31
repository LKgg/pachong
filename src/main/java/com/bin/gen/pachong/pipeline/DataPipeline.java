package com.bin.gen.pachong.pipeline;

import com.bin.gen.pachong.entity.Context;
import com.bin.gen.pachong.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by mogo on 2017/10/23 0023.
 */
@Repository
public class DataPipeline implements Pipeline{

    @Autowired
    private ContextService mContextService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Context mContext = resultItems.get("mContext");
        System.out.println(mContext.getText());
        mContextService.insert(mContext);
    }
}
