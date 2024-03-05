package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.mapper.HistoricalmenuMapper;
import com.xiaohuang.pojo.Monthly;
import com.xiaohuang.service.MonthlyService;
import com.xiaohuang.mapper.MonthlyMapper;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.EmpMonthly;
import com.xiaohuang.vo.HistoricalmenuQuery;
import com.xiaohuang.vo.PeicanQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
* @author changle
* @description 针对表【c_monthly】的数据库操作Service实现
* @createDate 2023-12-12 15:16:17
*/
@Service
public class MonthlyServiceImpl extends ServiceImpl<MonthlyMapper, Monthly>
    implements MonthlyService{

    @Autowired
    private MonthlyMapper monthlyMapper;

    @Override
    public Result monthlyList(HistoricalmenuQuery historicalmenuQuery) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String creatime = localDate.format(formatter);
        List<Monthly> monthlies= monthlyMapper.getmonthlyList(historicalmenuQuery,creatime);

        int size = monthlies.size();
        if(monthlies.isEmpty())
        {
            return Result.success(null,0L);
        }
        for(Monthly monthly:monthlies)
        {
            monthly.setCreatime(creatime);
        }
        return Result.success(monthlies, (long) size);
    }

    @Override
    public List<Monthly> empmonthlist(Integer uid, String creatime) {
        List<Monthly> monthlies= monthlyMapper.empmonthlist(uid,creatime);
        return monthlies;
    }

    @Override
    public Result getempmonthlyList(PeicanQuery peicanQuery) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String creatime = localDate.format(formatter);
        List<EmpMonthly> empMonthlies= monthlyMapper.getempmonthlyList(peicanQuery,creatime);

        int size = empMonthlies.size();
        if(empMonthlies.isEmpty())
        {
            return Result.success(null,0L);
        }
        return Result.success(empMonthlies, (long) size);
    }
}




