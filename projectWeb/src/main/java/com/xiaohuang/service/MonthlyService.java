package com.xiaohuang.service;

import com.xiaohuang.pojo.Monthly;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.HistoricalmenuQuery;
import com.xiaohuang.vo.PeicanQuery;

import java.util.List;

/**
* @author changle
* @description 针对表【c_monthly】的数据库操作Service
* @createDate 2023-12-12 15:16:18
*/
public interface MonthlyService extends IService<Monthly> {

    Result monthlyList(HistoricalmenuQuery historicalmenuQuery);

    List<Monthly> empmonthlist(Integer uid, String creatime);

    Result getempmonthlyList(PeicanQuery peicanQuery);
}
