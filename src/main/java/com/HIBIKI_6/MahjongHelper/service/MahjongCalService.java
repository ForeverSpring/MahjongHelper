package com.HIBIKI_6.MahjongHelper.service;

import com.HIBIKI_6.MahjongHelper.utils.MahjongCalUtils;
import org.springframework.stereotype.Service;

@Service
public class MahjongCalService {
    public static String CalTeHai(String tehai) {
        if(MahjongCalUtils.IsValidTeHai(tehai)){
            return MahjongCalUtils.CalShanten(tehai);
        }
        else{
            return "手牌输入错误！";
        }
    }
}
