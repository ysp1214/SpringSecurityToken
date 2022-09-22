package com.ysp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysp.domain.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @auther杨甜
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long userid);
}
