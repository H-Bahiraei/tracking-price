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
        Collections.addAll(inputList, Arrays.asList(new Instrument("Bitcoin"), 234234L, new Price("55000")));
        Collections.addAll(inputList, Arrays.asList(new Instrument("Ethereum"), 234234L, new Price("60000")));
        Collections.addAll(inputList, Arrays.asList(new Instrument("Bitcoin"), 234234L, new Price("56000")));

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
        this.put(instrument, linkedHashMapValue);

    }


    @Override
    protected List<Price> hasK1K2(Instrument instrument, Long date) {
        Optional<Map<Long, List<Price>>> linkedHashMapValue = Optional.ofNullable(this.get(instrument));
        if (linkedHashMapValue.isPresent() && linkedHashMapValue.get().containsKey(date)) { // TODO ifPresent?
            return linkedHashMapValue.get().get(date);
        }
        return new LinkedList<>();


    }


    @Override
    protected Boolean hasK1(Instrument instrument) {
        return this.containsKey(instrument);
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
