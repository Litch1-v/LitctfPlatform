package com.litchi.litchi_ctf.mapper;

import com.litchi.litchi_ctf.pojo.Challenge;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *Type类型解释：Web-1 Pwn-2 Misc-3 Cypto-4 Code-5 Re-6
 *
 */
@Mapper
public interface Solvemapper {
    @Select("Select Count(cid) From solve where uid =#{uid}")
    public int SelectCountSolvedByUser(int uid);
    @Select("Select cid From solve where uid=#{uid}")
    public int[] SelectAllSolvedByUser(int uid);
    @Select("SELECT challenge.cid from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=1 " +
            "and solve.uid=#{uid}")
    public int[] SelectWebSolvedByUser(int uid);
    @Select("SELECT challenge.cid from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=2 " +
            "and solve.uid=#{uid}")
    public int[] SelectPwnSolvedByUser(int uid);
    @Select("SELECT challenge.cid from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=3 " +
            "and solve.uid=#{uid}")
    public int[] SelectMiscSolvedByUser(int uid);
    @Select("SELECT challenge.cid from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=4 " +
            "and solve.uid=#{uid}")
    public int[] SelectCyptoSolvedByUser(int uid);
    @Select("SELECT challenge.cid from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=5 " +
            "and solve.uid=#{uid}")
    public int[] SelectCodeSolvedByUser(int uid);
    @Select("SELECT challenge.cid from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=6 " +
            "and solve.uid=#{uid}")
    public int[] SelectReSolvedByUser(int uid);
    @Select("SELECT count(1) from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=1 " +
            "and solve.uid=#{uid}")
    public int SelectWebSolvedNumberByUser(int uid);
    @Select("SELECT count(1) from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=2 " +
            "and solve.uid=#{uid}")
    public int SelectPwnSolvedNumberByUser(int uid);
    @Select("SELECT count(1) from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=3 " +
            "and solve.uid=#{uid}")
    public int SelectMiscSolvedNumberByUser(int uid);
    @Select("SELECT count(1) from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=4 " +
            "and solve.uid=#{uid}")
    public int SelectCodeSolvedNumberByUser(int uid);
    @Select("SELECT count(1) from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=5 " +
            "and solve.uid=#{uid}")
    public int SelectCyptoSolvedNumberByUser(int uid);
    @Select("SELECT count(1) from challenge INNER JOIN solve where solve.cid=challenge.cid and challenge.type=6 " +
            "and solve.uid=#{uid}")
    public int SelectReSolvedNumberByUser(int uid);
    @Insert("INSERT INTO solve(cid,uid) VALUES (#{cid},#{uid})")
    public int insertNewSolve(@Param("cid") int cid,@Param("uid") int uid);
    @Select("SELECT count(1) from solve where cid=#{cid}")
    public int selectSolvedNumberByChallenge(int cid);
    @Update("UPDATE challenge set solved_number=solved_number+1 where cid=#{cid}")
    public int addOneSolvedNumber(int cid);
    @Update("UPDATE user set solved_number=solved_number+1 where uid=#{uid}")
    public int addOneUserSolvedNumber(int uid);
}
