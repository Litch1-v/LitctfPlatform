package com.litchi.litchi_ctf.mapper;

import com.litchi.litchi_ctf.pojo.RankList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Rankmapper {
    @Select("SELECT uid FROM(SELECT uid FROM solve GROUP BY uid ORDER BY count(cid) DESC) a union (select uid from user)")
    public int[] getRanklist();
    @Select("SELECT user_number from rank order by rid")
    public int[] listCountSolvedUserNumber();
    @Select("SELECT solved_number,user_number from rankview ORDER BY solved_number desc")
    RankList[] countUserNumberOfSolvedNumber();
}
