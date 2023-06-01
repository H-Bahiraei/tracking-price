package com.microservices.trackingprice.model;

import java.util.*;


/**
 * link to architect data structure file
 *
 * @param <P>
 * @param <D>
 * @param <C>
 */
//public abstract class MapData<P extends BaseEntity, N extends Long, C extends BaseEntity> { // ToDo create Base Entity for Product and cost
public abstract class MapData<P, D extends Long, C> {

    protected Map<P, LinkedHashMap<D, LinkedList<C>>> mapData = new HashMap<>(); // diamond operator // Scope IOC: one obj

    protected abstract Boolean hasP(P p);

    // new record
    protected abstract LinkedList<C> createNewListValue(C c);

    protected abstract LinkedHashMap<D, LinkedList<C>> createNewMapValue(D d, LinkedList<C> listValue);

    protected abstract String putNewRecordToHashMap(P p, LinkedHashMap<D, LinkedList<C>> mapValue);

    protected String createNewPDC(P p, D d, C c) {
        return this.putNewRecordToHashMap(p, this.createNewMapValue(d, this.createNewListValue(c)));
    }

}
