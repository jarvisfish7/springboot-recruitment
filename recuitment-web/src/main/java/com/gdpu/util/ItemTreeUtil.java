package com.gdpu.util;


import com.gdpu.model.FirstType;
import com.gdpu.model.Position;
import com.gdpu.model.SecondType;
import com.gdpu.service.SecondTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


public class ItemTreeUtil {
    //职位转成map
    public static Map<Integer, List<ItemTreeRoot>> ItemP(List<Position> list){
        Map<Integer, List<ItemTreeRoot>> PMap = new HashMap<>();
        for (Position p : list){
            ItemTreeRoot item = new ItemTreeRoot();
            Integer pid = p.getSecondTypeId();
            item.setId(p.getPositionId());
            item.setName(p.getPositionName());
//            如果存在
            if (PMap.containsKey(pid)){
                PMap.get(pid).add(item);
            }else {
                //如果不存在
                List<ItemTreeRoot> l = new ArrayList<>();
                l.add(item);
                PMap.put(pid,l);
            }
        }
        return PMap;
    }

    //二类转成map
    public static Map<Integer, List<ItemTreeRoot>> ItemS(Map<Integer, List<ItemTreeRoot>> PMap,List<SecondType> list){
        Map<Integer, List<ItemTreeRoot>> SMap = new HashMap<>();
        for (SecondType s : list){
            ItemTreeRoot item = new ItemTreeRoot();
            Integer pid = s.getFirstId();
            Integer id = s.getSecondId();
            item.setId(id);
            item.setName(s.getSecondName());
            item.setChildren(PMap.get(id));
            if (SMap.containsKey(pid)){
                SMap.get(pid).add(item);
            }else {
                List<ItemTreeRoot> l = new ArrayList<>();
                l.add(item);
                SMap.put(pid,l);
            }
        }
        return SMap;
    }

    //一类转成list
    public static List<ItemTreeRoot> ItemF(Map<Integer, List<ItemTreeRoot>> SMap,List<FirstType> list){
        List<ItemTreeRoot> allList =new ArrayList<>();
        for (FirstType f : list){
            ItemTreeRoot item = new ItemTreeRoot();
            Integer id = f.getFirstId();
            item.setId(id);
            item.setName(f.getFirstName());
            item.setChildren(SMap.get(id));
            allList.add(item);

//            System.out.println(item);
        }
        return allList;
    }
}
