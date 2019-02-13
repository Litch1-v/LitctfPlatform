package com.litchi.litchi_ctf.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.ResultHandler;

import java.util.Map;

/**
 *Type类型解释：Web-1 Pwn-2 Misc-3 Cypto-4 Code-5 Re-6
 */
@Mapper
public interface Solvemapper {

    @Select("SELECT cid,type FROM challenge where cid in(SELECT cid FROM solve where uid=#{uid})")
    @ResultType(Map.class)
    void listTypeGroupSolvedByUserId(@Param("uid")Integer uid,ResultHandler resultHandler);
    int insertNewSolve(@Param("cid") int cid,@Param("uid") int uid);
    @Update("UPDATE challenge set solved_number=solved_number+1 where cid=#{cid}")
    int addOneSolvedNumber(int cid);
    @Update("UPDATE user set solved_number=solved_number+1 where uid=#{uid}")
    int addOneUserSolvedNumber(int uid);
    @Delete("DELETE from solve where cid=#{cid}")
    int deleteSolvedByCid(int cid);
}
