package com.bin.gen.pachong.service;

import com.bin.gen.pachong.entity.Context;

/**
 * Created by mogo on 2017/10/23 0023.
 */
public interface IContextService {
    void insert(Context context);
    Context selectTitleList();
}
