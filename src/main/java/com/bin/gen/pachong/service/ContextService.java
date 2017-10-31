package com.bin.gen.pachong.service;

import com.bin.gen.pachong.entity.Context;
import com.bin.gen.pachong.mapper.ContextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mogo on 2017/10/23 0023.
 */
@Service
public class ContextService implements IContextService{

    @Autowired(required = false)
    private ContextMapper contextMapper;
    @Override
    public void insert(Context context) {
        contextMapper.insert(context.getTitle(),context.getText());
    }

    @Override
    public Context selectTitleList() {
        return null;
    }
}
