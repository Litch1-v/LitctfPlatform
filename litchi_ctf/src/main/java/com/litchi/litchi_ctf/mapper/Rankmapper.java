package com.litchi.litchi_ctf.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Rankmapper {
    @Select("SELECT * FROM(SELECT uid FROM solve GROUP BY uid ORDER BY count(cid) DESC) a union (select uid from user)")
    public int[] getRanklist();
}
