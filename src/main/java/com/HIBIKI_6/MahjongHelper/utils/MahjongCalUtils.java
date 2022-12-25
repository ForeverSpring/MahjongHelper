package com.HIBIKI_6.MahjongHelper.utils;

import mahjongutils.models.Tile;
import mahjongutils.shanten.ShantenKt;
import mahjongutils.shanten.ShantenResult;
import mahjongutils.shanten.ShantenWithGot;
import mahjongutils.shanten.ShantenWithoutGot;

import java.util.*;

public class MahjongCalUtils {
    public static boolean IsValidTeHai(String TeHai){
        try{
            ShantenResult result = ShantenKt.shanten(
                    Tile.Companion.parseTiles(TeHai),
                    Collections.emptyList(),
                    true,
                    false,
                    false
            );
        }
        catch (Exception e){
            return false;
        }
        return  true;
    }
    public static String CalShanten(String TeHai){
        ShantenResult result = ShantenKt.shanten(
                Tile.Companion.parseTiles(TeHai),
                Collections.emptyList(),  // furo
                true,  // calcAdvanceNum
                true,  // bestShantenOnly
                false
        );
        String ret="";
        ShantenWithGot shantenInfo = (ShantenWithGot) result.getShantenInfo();
        if(shantenInfo.getShantenNum()==0){
            ret+="听牌\n";
        }
        else if(shantenInfo.getShantenNum()==-1){
            ret+="和了\n";
        }
        else{
            ret+="向听数 "+shantenInfo.getShantenNum()+"\n";
        }
        Map<Tile, ShantenWithoutGot> map= shantenInfo.getDiscardToAdvance();
        List<Map.Entry<Tile,ShantenWithoutGot>> list=new ArrayList<Map.Entry<Tile,ShantenWithoutGot>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Tile, ShantenWithoutGot>>() {
            @Override
            public int compare(Map.Entry<Tile, ShantenWithoutGot> o1, Map.Entry<Tile, ShantenWithoutGot> o2) {
                if(o2.getValue().getAdvanceNum().equals(o1.getValue().getAdvanceNum())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().getAdvanceNum().compareTo(o1.getValue().getAdvanceNum());
            }
        });
        for (Map.Entry<Tile,ShantenWithoutGot> entry:list){
            if(shantenInfo.getShantenNum()==0){
                ret += "打" + entry.getKey()+ " 听" + entry.getValue().getAdvance() + " " + entry.getValue().getAdvanceNum() + "张" + "\n";
            }
            else {
                ret += "打" + entry.getKey().toString() + " 摸" + entry.getValue().getAdvance() + " " + entry.getValue().getAdvanceNum() + "张" + "\n";
            }
        }
        System.out.println(ret);
        return ret;
    }
}
