package com.microservices.trackingprice.model.modeltrackingPrice;

import com.microservices.trackingprice.model.MapData;

import java.util.*;

public class MapModelTrackingPrice extends MapData {


    public static void main(String[] args) {
        MapModelTrackingPrice modelMap = new MapModelTrackingPrice(); // TODO create obj by Spring Framework (IOC,DI)
        System.out.println(modelMap.test(modelMap));
    }


    @Override
    protected String putNewRecordToHashMap(Object o, LinkedHashMap mapValue) {
        mapData.put(o, mapValue);
        return "Done";
    }


    @Override
    public LinkedList hasPDReturnLL(Object p, Long date) {
        LinkedHashMap lhm = this.get(p);
        return lhm.containsKey(date) ? (LinkedList) lhm.get(date) : new LinkedList();
    }

    @Override
    protected LinkedList createNewListValue(Object o) {
        LinkedList<Object> tempListValue = new LinkedList<>();
        tempListValue.add(o);
        return tempListValue;
    }

    @Override
    protected LinkedHashMap createNewMapValue(Long aLong, LinkedList listValue) {
        LinkedHashMap<Long, LinkedList<Object>> tempMapValue = new LinkedHashMap<>();
        tempMapValue.put(aLong, listValue);
        return tempMapValue;
    }


    @Override
    public String addingNewCToLinkedList(LinkedList ll, Object c) {
        ll.add(c);
        return ll.toString();
    }


}
