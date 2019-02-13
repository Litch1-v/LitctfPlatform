package com.litchi.litchi_ctf.service;

import com.litchi.litchi_ctf.pojo.Notice;

import java.util.List;

public interface NoticeService {
     int saveNotice(String description);
     int deleteNotice(int nid);
      List<Notice> getNoticeList();

}
