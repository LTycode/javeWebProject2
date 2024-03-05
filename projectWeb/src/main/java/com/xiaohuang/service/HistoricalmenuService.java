package com.xiaohuang.service;

import com.xiaohuang.pojo.Historicalmenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.HistoricalmenuQuery;

/**
* @author changle
* @description 针对表【c_historicalmenu】的数据库操作Service
* @createDate 2023-12-06 03:11:41
*/
public interface HistoricalmenuService extends IService<Historicalmenu> {

    Result historicalmenuList(HistoricalmenuQuery historicalmenuQuery);
}
