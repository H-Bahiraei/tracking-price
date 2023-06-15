package com.microservices.trackingprice.services;

import com.microservices.trackingprice.model.MapModel;
import com.microservices.trackingprice.model.modeltrackingPrice.Instrument;
import com.microservices.trackingprice.model.modeltrackingPrice.Price;

import java.util.List;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/14/2023
 * @project tracking-price
 * &
 */
public interface TrackingPriceService {
    Map<Instrument, Map<Long, List<Price>>> analyzeData(MapModel<Instrument, Long, Price> mapModel); // TODO delete

    default Map<Instrument, Map<Long, List<Price>>> analyzeToWriting(MapModel<Instrument, Long, Price> mapModel) {
        for (Map.Entry<Instrument, Map<Long, List<Price>>> entry : mapModel.mapData.entrySet()) {
            Map<Long, List<Price>> linkedHashMap = this.hasInstrumentAndGetLinkedHashMap(entry.getKey());
            if (!(linkedHashMap.size() > 0)) { // first instrument
                this.writingInstrumentForFirstDatePrice(entry);
            } else {
                this.writingDatePriceForExistingInstrument(entry, linkedHashMap);
            }
        }
        return this.getReturn();
    } // TODO return just added


    default void writingInstrumentForFirstDatePrice(Map.Entry<Instrument, Map<Long, List<Price>>> entry) {
        for (Map.Entry<Long, List<Price>> innerEntry : entry.getValue().entrySet()) {
            int i = 1;
            for (Price price : innerEntry.getValue()) { //TODO 3 loop!
                if (i == 1) { // first instrument, first date, first price
                    this.insertNewRecordInsDatePriceToHashMap(entry.getKey(), innerEntry.getKey(), price);
                    i++;
                } else { // new price
                    this.addingNewPriceToLinkedList(this.hasInstrumentDateKeysAndGetLinkedList(entry.getKey(), innerEntry.getKey())
                            , price);
                }
            }
        }
    }

    default void writingDatePriceForExistingInstrument(Map.Entry<Instrument, Map<Long, List<Price>>> entry,
                                                       Map<Long, List<Price>> linkedHashMap) {
        for (Map.Entry<Long, List<Price>> innerEntry : entry.getValue().entrySet()) {
            List<Price> prices = this.hasInstrumentDateKeysAndGetLinkedList(entry.getKey(),
                    innerEntry.getKey());
            if (!(prices.size() > 0)) { // first date
                int i = 1;
                for (Price price : innerEntry.getValue()) {
                    if (i == 1) { // first date, first price
                        prices = this.addingNewRecordToExistingLinkedHashMap(linkedHashMap, innerEntry.getKey(),
                                innerEntry.getValue().get(0));
                        i++;
                    } else { // new price
                        this.addingNewPriceToLinkedList(
                                prices, price);
                    }
                }
            } else { // just new price
                this.justAddingPriceForExistingInstrumentDate(innerEntry, prices);
            }
        }
    }

    default void justAddingPriceForExistingInstrumentDate(Map.Entry<Long, List<Price>> innerEntry, List<Price> prices) {
        for (Price price : innerEntry.getValue()) { //TODO 3 loop!
            this.addingNewPriceToLinkedList(prices, price);
        }
    }

    void addingNewPriceToLinkedList(List<Price> prices, Price price);

    List<Price> hasInstrumentDateKeysAndGetLinkedList(Instrument key, Long key1);

    List<Price> addingNewRecordToExistingLinkedHashMap(Map<Long, List<Price>> linkedHashMap, Long date, Price price);

    void insertNewRecordInsDatePriceToHashMap(Instrument key, Long key1, Price price);

    Map<Long, List<Price>> hasInstrumentAndGetLinkedHashMap(Instrument key);

    Map<Instrument, Map<Long, List<Price>>> getReturn();

}