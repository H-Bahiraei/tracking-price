package com.microservices.trackingprice.model.modeltrackingPrice;

import com.microservices.trackingprice.model.MapModel;

import java.util.*;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/5/2023
 * @project tracking-price
 * &
 */
public class MapModelTrackingPrice extends MapModel<Instrument, Long, Price> {


    public static void main(String[] args) {
        MapModelTrackingPrice mapModelTrackingPrice = new MapModelTrackingPrice(); // TODO create obj by Spring Framework (IOC,DI)
        List<List<Object>> inputList = new ArrayList<>();
        Collections.addAll(inputList, Arrays.asList(new Instrument("Dollar"), 234234L, new Price("55000")));
        Collections.addAll(inputList, Arrays.asList(new Instrument("Euro"), 234234L, new Price("60000")));
        Collections.addAll(inputList, Arrays.asList(new Instrument("Dollar"), 234234L, new Price("56000")));

        for (List<Object> inner : inputList) {
            if (!mapModelTrackingPrice.hasK1((Instrument) inner.get(0))) {
                mapModelTrackingPrice.insertNewRecordToHashMap((Instrument) inner.get(0), (Long) inner.get(1), (Price) inner.get(2));
            } else {
                List<Price> ll = mapModelTrackingPrice.hasK1K2((Instrument) inner.get(0), (Long) inner.get(1));
                if (ll.size() > 0) {
                    mapModelTrackingPrice.addingNewVToLinkedList(ll, (Price) inner.get(2));
                }
            }
        }

        System.out.println(mapModelTrackingPrice.mapData);
    }


    @Override
    protected void putNewRecordToHashMap(Instrument instrument, Map<Long, List<Price>> linkedHashMapValue) {
        this.put(instrument, linkedHashMapValue); //ToDo

    }


    @Override
    protected List<Price> hasK1K2(Instrument instrument, Long date) {
        Map<Long, List<Price>> linkedHashMapValue = this.get(instrument);
        return linkedHashMapValue.containsKey(date) ? linkedHashMapValue.get(date) : new LinkedList<>();
    }


    @Override
    protected List<Price> createNewLinkedListWithValue(Price price) {
        List<Price> prices = new LinkedList<>();
        prices.add(price);
        return prices;
    }


    @Override
    protected Map<Long, List<Price>> createNewLinkedHashMapWithKeyAndValue(Long date, List<Price> linkedListValue) {
        Map<Long, List<Price>> newLinkedHashMap = new LinkedHashMap<>();
        newLinkedHashMap.put(date, linkedListValue);
        return newLinkedHashMap;
    }


    @Override
    protected void addingNewVToLinkedList(List<Price> linkedListValue, Price price) {
        linkedListValue.add(price);

    }
}
