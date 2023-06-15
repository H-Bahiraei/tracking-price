package com.microservices.trackingprice.controller;

import com.microservices.trackingprice.model.modeltrackingPrice.Instrument;
import com.microservices.trackingprice.model.modeltrackingPrice.MapModelTrackingPrice;
import com.microservices.trackingprice.model.modeltrackingPrice.Price;
import com.microservices.trackingprice.services.TrackingPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/14/2023
 * @project tracking-price
 * &
 */

@Controller
@RequestMapping("/trackingprice")
public class TrackingPriceController {

    private final TrackingPriceService trackingPriceService;

    public TrackingPriceController(TrackingPriceService trackingPriceService) {
        this.trackingPriceService = trackingPriceService;
    }

//    @RequestMapping("/adding")
//    public ResponseEntity<String> addNewRecordInstrumentDatePriceGetJson() {
////        trackingPriceService.insertNewRecord("");
//        return new ResponseEntity<>("added", HttpStatus.OK); //TODO use case?
//    }

    @PostMapping("/write")
    @ResponseBody
    public Map<Instrument, Map<Long, List<Price>>> gettingData(@RequestBody MapModelTrackingPrice mapModelTrackingPrice) {
        return trackingPriceService.analyzeToWriting(mapModelTrackingPrice); // TODO just added
    }


    //TODO getAll
}
