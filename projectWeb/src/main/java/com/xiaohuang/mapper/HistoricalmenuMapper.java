package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Historicalmenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.vo.HistoricalmenuAndMenu;
import com.xiaohuang.vo.HistoricalmenuQuery;

import java.util.List;

/**
* @author changle
* @description 针对表【c_historicalmenu】的数据库操作Mapper
* @createDate 2023-12-06 03:11:41
* @Entity com.xiaohuang.pojo.Historicalmenu
*/
public interface HistoricalmenuMapper extends BaseMapper<Historicalmenu> {

    int insertBymenu(List<Integer> mids, String creatime);

    List<HistoricalmenuAndMenu> historicalmenuList(HistoricalmenuQuery historicalmenuQuery);
}




