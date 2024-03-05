package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Monthly;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.vo.EmpMonthly;
import com.xiaohuang.vo.HistoricalmenuQuery;
import com.xiaohuang.vo.PeicanQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author changle
* @description 针对表【c_monthly】的数据库操作Mapper
* @createDate 2023-12-12 15:16:17
* @Entity com.xiaohuang.pojo.Monthly
*/
public interface MonthlyMapper extends BaseMapper<Monthly> {

    List<Monthly> getmonthlyList(HistoricalmenuQuery historicalmenuQuery,String creatime);

    List<Monthly> getList();

    int insertMonthly(List<Monthly> monthlies);

    double selectSumSomeprice(Integer uid, String creatime1);

    int setSumprice(Integer uid, String creatime1,double sumprice);

    List<Monthly> empmonthlist(Integer uid, String creatime);

    List<EmpMonthly> getempmonthlyList(@Param("peicanQuery") PeicanQuery peicanQuery, String creatime);
}




