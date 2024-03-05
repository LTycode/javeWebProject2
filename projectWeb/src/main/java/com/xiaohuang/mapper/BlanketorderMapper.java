package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Blanketorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.vo.BlanketorderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author changle
* @description 针对表【c_blanketorder】的数据库操作Mapper
* @createDate 2023-12-11 00:16:47
* @Entity com.xiaohuang.pojo.Blanketorder
*/
public interface BlanketorderMapper extends BaseMapper<Blanketorder> {

    List<Blanketorder> selectBycreatime(String creatime);

    int getcountBycreatime(String creatime);

    int insertByList(List<Blanketorder> blanketorderList);

    List<Blanketorder> getblanketorderList(BlanketorderQuery blanketorderQuery,@Param("creatime") String creatime);

    Long getCount(BlanketorderQuery blanketorderQuery,@Param("creatime")String creatime);
}




