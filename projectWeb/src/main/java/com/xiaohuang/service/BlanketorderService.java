package com.xiaohuang.service;

import com.xiaohuang.pojo.Blanketorder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.BlanketorderQuery;

/**
* @author changle
* @description 针对表【c_blanketorder】的数据库操作Service
* @createDate 2023-12-11 00:16:47
*/
public interface BlanketorderService extends IService<Blanketorder> {

    Result getBlanketorderList(BlanketorderQuery blanketorderQuery);
}
