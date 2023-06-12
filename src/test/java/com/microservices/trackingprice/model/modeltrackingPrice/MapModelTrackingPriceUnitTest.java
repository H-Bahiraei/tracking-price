package com.microservices.trackingprice.model.modeltrackingPrice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/12/2023
 * @project tracking-price
 * &
 */
class MapModelTrackingPriceUnitTest {


    MapModelTrackingPrice mapModelTrackingPrice;

    List<List<Object>> inputList = new ArrayList<>();

    @BeforeEach
    public void setUp() throws Exception {
        mapModelTrackingPrice = new MapModelTrackingPrice();

        Collections.addAll(inputList, Arrays.asList(new Instrument("Bitcoin"), 234234L, new Price("55000")));
        Collections.addAll(inputList, Arrays.asList(new Instrument("Ethereum"), 678788L, new Price("60000")));
        Collections.addAll(inputList, Arrays.asList(new Instrument("Bitcoin"), 234234L, new Price("56000")));

    }


    @Test
    void insertNewRecordToHashMap() {
        //given
        mapModelTrackingPrice.insertNewRecordToHashMap((Instrument) inputList.get(0).get(0),
                (Long) inputList.get(0).get(1), (Price) inputList.get(0).get(2));
        // then
        assertEquals(mapModelTrackingPrice.size(), 1);
    }

    @Test
    public void hasK1() {
        //given
        Instrument instrument_not_having = new Instrument("not_having");
        Instrument instrument_bitcoin = new Instrument("Bitcoin");
        // then
        assertEquals(mapModelTrackingPrice.hasK1(instrument_not_having), false);


        //given
        mapModelTrackingPrice.insertNewRecordToHashMap((Instrument) inputList.get(0).get(0),
                (Long) inputList.get(0).get(1), (Price) inputList.get(0).get(2));
        // then
        assertEquals(mapModelTrackingPrice.hasK1(instrument_bitcoin), true);
        assertEquals(mapModelTrackingPrice.hasK1(instrument_not_having), false);
    }

    @Test
    public void createNewLinkedListWithValue() {
        // given
        List<Price> linkedList = mapModelTrackingPrice.createNewLinkedListWithValue(
                (Price) inputList.get(0).get(2));
        //then
        assertEquals(1, linkedList.size());
    }

    @Test
    void createNewLinkedHashMapWithKeyAndValue() {
        // given
        Map<Long, List<Price>> linkedHashMap = mapModelTrackingPrice.createNewLinkedHashMapWithKeyAndValue(
                (Long) inputList.get(0).get(1), mapModelTrackingPrice.createNewLinkedListWithValue(
                        (Price) inputList.get(0).get(2)));

        //then
        assertEquals(1, linkedHashMap.size());

    }


    @Test
    void putNewRecordToHashMap() {
        // given
        mapModelTrackingPrice.putNewRecordToHashMap((Instrument) inputList.get(0).get(0),
                mapModelTrackingPrice.createNewLinkedHashMapWithKeyAndValue(
                        (Long) inputList.get(0).get(1), mapModelTrackingPrice.createNewLinkedListWithValue(
                                (Price) inputList.get(0).get(2))));
        // then
        assertEquals(1, mapModelTrackingPrice.size());
        assertEquals((Price) inputList.get(0).get(2),
                mapModelTrackingPrice.get((Instrument) inputList.get(0).get(0)).
                        get((Long) inputList.get(0).get(1)).get(0));
    }


    @Test
    void hasK1K2() {
        //given
        mapModelTrackingPrice.insertNewRecordToHashMap((Instrument) inputList.get(0).get(0),
                (Long) inputList.get(0).get(1), (Price) inputList.get(0).get(2));

        // then
        assertEquals(mapModelTrackingPrice.hasK1K2((Instrument) inputList.get(1).get(0), (Long) inputList.get(1).get(1)).
                size(), 0);
        assertEquals(mapModelTrackingPrice.hasK1K2((Instrument) inputList.get(0).get(0), (Long) inputList.get(1).get(1)).
                size(), 0);
        assertEquals(mapModelTrackingPrice.hasK1K2((Instrument) inputList.get(1).get(0), (Long) inputList.get(0).get(1)).
                size(), 0);
        assertEquals(mapModelTrackingPrice.hasK1K2((Instrument) inputList.get(0).get(0), (Long) inputList.get(0).get(1)).
                size(), 1);


    }

    @Test
    void addingNewVToLinkedList() {
        //given
        mapModelTrackingPrice.insertNewRecordToHashMap((Instrument) inputList.get(0).get(0),
                (Long) inputList.get(0).get(1), (Price) inputList.get(0).get(2));
        List<Price> prices = mapModelTrackingPrice.hasK1K2((Instrument) inputList.get(0).get(0),
                (Long) inputList.get(0).get(1));
        // then
        assertEquals((mapModelTrackingPrice.get((Instrument) inputList.get(0).get(0)).get((Long) inputList.get(0).get(1))
                .size()), 1);


        //given
        mapModelTrackingPrice.addingNewVToLinkedList(prices, (Price) inputList.get(2).get(2));


        // then
        assertEquals((mapModelTrackingPrice.get((Instrument) inputList.get(0).get(0)).get((Long) inputList.get(0).get(1))
                .size()), 2);

    }
}