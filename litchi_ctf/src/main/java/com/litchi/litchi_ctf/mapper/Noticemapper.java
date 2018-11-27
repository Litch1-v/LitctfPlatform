package com.litchi.litchi_ctf.mapper;

import com.litchi.litchi_ctf.pojo.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Noticemapper {
    /**
     * @return 返回按时间排序后的通知列表（最新的排在最前面）
     */
    @Select("SELECT * FROM notice ORDER BY date DESC")
    public List<Notice> selectNoticeList();
    @Insert("INSERT INTO notice(date,description) values (CURRENT_TIME,#{description})")
    public int insertNotice(String description);
    @Delete("Delete  from notice where nid=#{nid}")
    public  int deleteNotice(int Nid);
}
