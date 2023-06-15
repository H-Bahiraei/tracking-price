package com.microservices.trackingprice.services.map;

import com.microservices.trackingprice.model.MapModel;
import com.microservices.trackingprice.model.modeltrackingPrice.Instrument;
import com.microservices.trackingprice.model.modeltrackingPrice.MapModelTrackingPrice;
import com.microservices.trackingprice.model.modeltrackingPrice.Price;
import com.microservices.trackingprice.services.TrackingPriceService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/14/2023
 * @project tracking-price
 * &
 */
@Service
@Primary
public class MapTrackingPriceService implements TrackingPriceService {


    private final MapModelTrackingPrice mapModelTrackingPrice;

    public MapTrackingPriceService(MapModelTrackingPrice mapModelTrackingPrice) {
        this.mapModelTrackingPrice = mapModelTrackingPrice;
    }

    @Override
    public Map<Instrument, Map<Long, List<Price>>> analyzeData(MapModel<Instrument, Long, Price> mapModel) {
        for (Map.Entry<Instrument, Map<Long, List<Price>>> entry : mapModel.mapData.entrySet()) {
            Map<Long, List<Price>> linkedHashMap = mapModelTrackingPrice.hasK1AndGetLinkedHashMap(entry.getKey());
            if (!(linkedHashMap.size() > 0)) { // first instrument
                for (Map.Entry<Long, List<Price>> innerEntry : entry.getValue().entrySet()) {
                    int i = 1;
                    for (Price price : innerEntry.getValue()) { //TODO 3 loop!
                        if (i == 1) { // first instrument, first date, first price
                            mapModelTrackingPrice.insertNewRecordToHashMap(entry.getKey(), innerEntry.getKey(), price);
                            i++;
                        } else { // new price
                            mapModelTrackingPrice.addingNewVToLinkedList(
                                    mapModelTrackingPrice.hasK1K2AndGetLinkedList(entry.getKey(), innerEntry.getKey()),
                                    price);
                        }
                    }
                }
            } else {
                for (Map.Entry<Long, List<Price>> innerEntry : entry.getValue().entrySet()) {
                    List<Price> prices = mapModelTrackingPrice.hasK1K2AndGetLinkedList(entry.getKey(),
                            innerEntry.getKey());
                    if (!(prices.size() > 0)) { // first date
                        int i = 1;
                        for (Price price : innerEntry.getValue()) {
                            if (i == 1) { // first date, first price
                                prices = mapModelTrackingPrice.addingNewRecordToExistingLinkedHashMap(
                                        linkedHashMap, innerEntry.getKey(), innerEntry.getValue().get(0));
                                i++;
                            } else { // new price
                                mapModelTrackingPrice.addingNewVToLinkedList(
                                        prices, price);
                            }
                        }
                    } else { // just new price
                        for (Price price : innerEntry.getValue()) { //TODO 3 loop!
                            mapModelTrackingPrice.addingNewVToLinkedList(prices, price);
                        }
                    }
                }
            }
        }
        return mapModelTrackingPrice.mapData;
    }

    @Override
    public void addingNewPriceToLinkedList(List<Price> prices, Price price) {
        mapModelTrackingPrice.addingNewVToLinkedList(prices, price);
    }

    @Override
    public List<Price> hasInstrumentDateKeysAndGetLinkedList(Instrument instrument, Long date) {
        return mapModelTrackingPrice.hasK1K2AndGetLinkedList(instrument, date);
    }

    @Override
    public List<Price> addingNewRecordToExistingLinkedHashMap(Map<Long, List<Price>> linkedHashMap, Long date, Price price) {
        return mapModelTrackingPrice.addingNewRecordToExistingLinkedHashMap(linkedHashMap, date, price);
    }

    @Override
    public void insertNewRecordInsDatePriceToHashMap(Instrument key, Long date, Price price) {
        mapModelTrackingPrice.insertNewRecordToHashMap(key, date, price);
    }

    @Override
    public Map<Long, List<Price>> hasInstrumentAndGetLinkedHashMap(Instrument key) {
        return mapModelTrackingPrice.hasK1AndGetLinkedHashMap(key);
    }

    @Override
    public Map<Instrument, Map<Long, List<Price>>> getReturn() {
        return mapModelTrackingPrice.mapData;
    }
}
