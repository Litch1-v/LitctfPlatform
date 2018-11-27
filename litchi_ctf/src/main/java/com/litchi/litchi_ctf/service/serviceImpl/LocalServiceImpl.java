package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.mapper.Noticemapper;
import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.Notice;
import com.litchi.litchi_ctf.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LocalService")
public class LocalServiceImpl implements LocalService {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Noticemapper noticemapper;
    @Override
    public int getUserNumber() {
        return usermapper.SelectUserNumber();
    }

    @Override
    public List<Notice> getNoticeList() {
        return noticemapper.selectNoticeList();
    }
}
