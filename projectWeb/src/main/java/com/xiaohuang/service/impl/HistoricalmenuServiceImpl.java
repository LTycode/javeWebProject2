package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.pojo.Historicalmenu;
import com.xiaohuang.service.HistoricalmenuService;
import com.xiaohuang.mapper.HistoricalmenuMapper;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.HistoricalmenuAndMenu;
import com.xiaohuang.vo.HistoricalmenuQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author changle
* @description 针对表【c_historicalmenu】的数据库操作Service实现
* @createDate 2023-12-06 03:11:41
*/
@Service
public class HistoricalmenuServiceImpl extends ServiceImpl<HistoricalmenuMapper, Historicalmenu>
    implements HistoricalmenuService{

    @Autowired
    private HistoricalmenuMapper historicalmenuMapper;
    @Override
    public Result historicalmenuList(HistoricalmenuQuery historicalmenuQuery) {
        List<HistoricalmenuAndMenu> historicalmenuAndMenus= historicalmenuMapper.historicalmenuList(historicalmenuQuery);
        int size = historicalmenuAndMenus.size();
        return Result.success(historicalmenuAndMenus, (long) size);
    }
}




