package com.litchi.litchi_ctf.util;

import com.litchi.litchi_ctf.pojo.ChallengeType;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TypeChallengeResultHandler implements ResultHandler {
    private Map<Integer, List<Integer>> results=new HashMap<>();
    public TypeChallengeResultHandler(){
        List<Integer> webList=new LinkedList<>();
        List<Integer> pwnList=new LinkedList<>();
        List<Integer> miscList=new LinkedList<>();
        List<Integer> cyptoList=new LinkedList<>();
        List<Integer> codeList=new LinkedList<>();
        List<Integer> reList=new LinkedList<>();
        this.results.put(ChallengeType.WEB.getTypecode(),webList);
        this.results.put(ChallengeType.PWN.getTypecode(),pwnList);
        this.results.put(ChallengeType.MISC.getTypecode(),miscList);
        this.results.put(ChallengeType.CYPTO.getTypecode(),cyptoList);
        this.results.put(ChallengeType.CODE.getTypecode(),codeList);
        this.results.put(ChallengeType.RE.getTypecode(),reList);
    }
    @Override
    public void handleResult(ResultContext resultContext) {

        Map<String,Object> resultObject=(Map<String,Object>)resultContext.getResultObject();
        results.get((Integer) resultObject.get("type")).add((Integer) resultObject.get("cid"));
    }

    public Map<Integer, List<Integer>> getResults() {
        return results;
    }

    public void setResults(Map<Integer, List<Integer>> results) {
        this.results = results;
    }
}
