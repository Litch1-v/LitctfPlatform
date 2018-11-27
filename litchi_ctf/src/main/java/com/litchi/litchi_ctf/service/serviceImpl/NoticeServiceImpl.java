package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.mapper.Noticemapper;
import com.litchi.litchi_ctf.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private Noticemapper noticemapper;
    @Override
    public int saveNotice(String description) {
        return noticemapper.insertNotice(description);
    }

    @Override
    public int deleteNotice(int nid) {
        return noticemapper.deleteNotice(nid);
    }
}
