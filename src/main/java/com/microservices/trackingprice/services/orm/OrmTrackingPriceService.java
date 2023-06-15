package com.microservices.trackingprice.services.orm;

import com.microservices.trackingprice.model.MapModel;
import com.microservices.trackingprice.model.modeltrackingPrice.Instrument;
import com.microservices.trackingprice.model.modeltrackingPrice.Price;
import com.microservices.trackingprice.services.TrackingPriceService;
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
public class OrmTrackingPriceService implements TrackingPriceService { // TODO use Qualifier


    @Override
    public void addingNewPriceToLinkedList(List<Price> prices, Price price) {

    }

    @Override
    public List<Price> hasInstrumentDateKeysAndGetLinkedList(Instrument key, Long key1) {
        return null;
    }

    @Override
    public List<Price> addingNewRecordToExistingLinkedHashMap(Map<Long, List<Price>> linkedHashMap, Long date, Price price) {
        return null;
    }

    @Override
    public void insertNewRecordInsDatePriceToHashMap(Instrument key, Long key1, Price price) {

    }

    @Override
    public Map<Long, List<Price>> hasInstrumentAndGetLinkedHashMap(Instrument key) {
        return null;
    }

    @Override
    public Map analyzeData(MapModel<Instrument, Long, Price> mapModel) {
        return null;
    }

    @Override
    public Map<Instrument, Map<Long, List<Price>>> getReturn() {
        return null;
    }
}
