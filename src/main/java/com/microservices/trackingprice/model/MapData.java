package com.microservices.trackingprice.model;

import com.microservices.trackingprice.model.modeltrackingPrice.MapModelTrackingPrice;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;


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

// ToDo replacement P D C with better Class Name


    protected String test(MapModelTrackingPrice modelMap) {


        List<List<String>> inputList = new ArrayList<>();
        Collections.addAll(inputList, Arrays.asList("Dollar", "234234", "55000"));
        Collections.addAll(inputList, Arrays.asList("Euro", "234234", "60000"));
        Collections.addAll(inputList, Arrays.asList("Dollar", "234234", "56000"));

//        inputList.stream().forEach(a -> modelMap.hasP(a.get(0)) );

        for (List<String> inner : inputList) {
            if (!modelMap.hasP(inner.get(0))) {
                modelMap.createNewPDC(inner.get(0), Long.parseLong(inner.get(1)), inner.get(2));
            } else {
                LinkedList ll = modelMap.hasPDReturnLL(inner.get(0), Long.parseLong(inner.get(1)));
                if (ll.size() > 0) {
                    modelMap.addingNewCToLinkedList(ll, inner.get(2));
                }
            }
        }
        return mapData.toString();
    }

    // new record
    protected Boolean hasP(P p) {
        return this.containsKey(p);
    }

    protected String createNewPDC(P p, D d, C c) {
        return this.putNewRecordToHashMap(p, this.createNewMapValue(d, this.createNewListValue(c)));
    }

    protected abstract LinkedList<C> createNewListValue(C c);

    protected abstract LinkedHashMap<D, LinkedList<C>> createNewMapValue(D d, LinkedList<C> listValue);

    protected abstract String putNewRecordToHashMap(P p, LinkedHashMap<D, LinkedList<C>> mapValue);


    // New Cost

    protected abstract LinkedList hasPDReturnLL(P p, D d);

    protected abstract String addingNewCToLinkedList(LinkedList listOfC, C c);


///////////// MAP

    public int size() {
        return mapData.size();
    }

    public boolean isEmpty() {
        return mapData.isEmpty();
    }

    public boolean containsKey(Object key) {
        return mapData.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return mapData.containsValue(value);
    }

    public LinkedHashMap<D, LinkedList<C>> get(Object key) {
        return mapData.get(key);
    }

    public LinkedHashMap<D, LinkedList<C>> put(P key, LinkedHashMap<D, LinkedList<C>> value) {
        return mapData.put(key, value);
    }

    public LinkedHashMap<D, LinkedList<C>> remove(Object key) {
        return mapData.remove(key);
    }

//    public void putAll(@org.jetbrains.annotations.NotNull Map<? extends P, ? extends LinkedHashMap<D, LinkedList<C>>> m) {
//        mapData.putAll(m);
//    }

    public void clear() {
        mapData.clear();
    }

    public Set<P> keySet() {
        return mapData.keySet();
    }

    public Collection<LinkedHashMap<D, LinkedList<C>>> values() {
        return mapData.values();
    }

    public Set<Map.Entry<P, LinkedHashMap<D, LinkedList<C>>>> entrySet() {
        return mapData.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        return mapData.equals(o);
    }

    @Override
    public int hashCode() {
        return mapData.hashCode();
    }

    public LinkedHashMap<D, LinkedList<C>> getOrDefault(Object key, LinkedHashMap<D, LinkedList<C>> defaultValue) {
        return mapData.getOrDefault(key, defaultValue);
    }

    public void forEach(BiConsumer<? super P, ? super LinkedHashMap<D, LinkedList<C>>> action) {
        mapData.forEach(action);
    }

    public void replaceAll(BiFunction<? super P, ? super LinkedHashMap<D, LinkedList<C>>, ? extends LinkedHashMap<D, LinkedList<C>>> function) {
        mapData.replaceAll(function);
    }

    public LinkedHashMap<D, LinkedList<C>> putIfAbsent(P key, LinkedHashMap<D, LinkedList<C>> value) {
        return mapData.putIfAbsent(key, value);
    }

    public boolean remove(Object key, Object value) {
        return mapData.remove(key, value);
    }

    public boolean replace(P key, LinkedHashMap<D, LinkedList<C>> oldValue, LinkedHashMap<D, LinkedList<C>> newValue) {
        return mapData.replace(key, oldValue, newValue);
    }

    public LinkedHashMap<D, LinkedList<C>> replace(P key, LinkedHashMap<D, LinkedList<C>> value) {
        return mapData.replace(key, value);
    }

//    public LinkedHashMap<D, LinkedList<C>> computeIfAbsent(P key, @org.jetbrains.annotations.NotNull Function<? super P, ? extends LinkedHashMap<D, LinkedList<C>>> mappingFunction) {
//        return mapData.computeIfAbsent(key, mappingFunction);
//    }
//
//    public LinkedHashMap<D, LinkedList<C>> computeIfPresent(P key, @org.jetbrains.annotations.NotNull BiFunction<? super P, ? super LinkedHashMap<D, LinkedList<C>>, ? extends LinkedHashMap<D, LinkedList<C>>> remappingFunction) {
//        return mapData.computeIfPresent(key, remappingFunction);
//    }
//
//    public LinkedHashMap<D, LinkedList<C>> compute(P key, @org.jetbrains.annotations.NotNull BiFunction<? super P, ? super LinkedHashMap<D, LinkedList<C>>, ? extends LinkedHashMap<D, LinkedList<C>>> remappingFunction) {
//        return mapData.compute(key, remappingFunction);
//    }
//
//    public LinkedHashMap<D, LinkedList<C>> merge(P key, @org.jetbrains.annotations.NotNull LinkedHashMap<D, LinkedList<C>> value, @org.jetbrains.annotations.NotNull BiFunction<? super LinkedHashMap<D, LinkedList<C>>, ? super LinkedHashMap<D, LinkedList<C>>, ? extends LinkedHashMap<D, LinkedList<C>>> remappingFunction) {
//        return mapData.merge(key, value, remappingFunction);
//    }

    public static <K, V> Map<K, V> of() {
        return Map.of();
    }

    public static <K, V> Map<K, V> of(K k1, V v1) {
        return Map.of(k1, v1);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
        return Map.of(k1, v1, k2, v2);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return Map.of(k1, v1, k2, v2, k3, v3);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9);
    }

    public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10);
    }

    @SafeVarargs
    public static <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        return Map.ofEntries(entries);
    }

    public static <K, V> Map.Entry<K, V> entry(K k, V v) {
        return Map.entry(k, v);
    }

    public static <K, V> Map<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return Map.copyOf(map);
    }
}
