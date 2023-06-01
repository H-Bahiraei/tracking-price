package com.microservices.trackingprice.model.modeltrackingPrice;

import com.microservices.trackingprice.model.MapData;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class MapModelTrackingPrice extends MapData {


    public static void main(String[] args) {
        MapModelTrackingPrice m = new MapModelTrackingPrice(); // TODO create obj by Spring Framework (IOC,DI)
        String o = "Dollar";
        Long d = 234234L;
        String c = "55000";
        String o2 = "Euro";
        Long d2 = 234234L;
        String c2 = "66000";

        if (!m.hasP(o)) {
            m.createNewPDC(o, d, c);
//            System.out.printf(m.mapData.toString());
        }
        if (!m.hasP(o2)) {
            m.createNewPDC(o2, d2, c2);
            System.out.printf(m.mapData.toString());
        }


    }


    @Override
    protected String putNewRecordToHashMap(Object o, LinkedHashMap mapValue) {
        mapData.put(o, mapValue);
        return "Done";
    }

    @Override
    protected Boolean hasP(Object o) {
        return mapData.containsKey(o);
    }

    @Override
    protected LinkedList createNewListValue(Object o) {
        LinkedList<Object> tempListValue = new LinkedList();
        tempListValue.add(o);
        return tempListValue;
    }

    @Override
    protected LinkedHashMap createNewMapValue(Long aLong, LinkedList listValue) {
        LinkedHashMap<Long, LinkedList<Object>> tempMapValue = new LinkedHashMap<>();
        tempMapValue.put(aLong, listValue);
        return tempMapValue;
    }


}
