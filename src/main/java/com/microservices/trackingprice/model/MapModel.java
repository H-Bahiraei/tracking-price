package com.microservices.trackingprice.model;

import com.microservices.trackingprice.model.modeltrackingPrice.Price;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 6/5/2023
 * @project tracking-price
 * &
 */

/**
 * link to architect data structure file
 *
 * @param <K1>
 * @param <K2>
 * @param <V>
 */
public abstract class MapModel<K1 extends BaseEntity, K2 extends Long, V extends BaseEntity> implements Serializable {

    protected Map<K1, Map<Long, List<Price>>> mapData = new HashMap<>(); // diamond operator // Scope IOC: one obj


    // new record to HashMap
    protected abstract Boolean hasK1(K1 k1);

    public void insertNewRecordToHashMap(K1 k1, K2 k2, V v) {
        this.putNewRecordToHashMap(k1, this.createNewLinkedHashMapWithKeyAndValue(
                k2, this.createNewLinkedListWithValue(v)));
    }

    protected abstract List<V> createNewLinkedListWithValue(V v);

    protected abstract Map<K2, List<V>> createNewLinkedHashMapWithKeyAndValue(
            K2 alongKey, List<V> linkedListValue);

    protected abstract void putNewRecordToHashMap(K1 k1, Map<K2, List<V>> linkedHashMapValue);


    // New Price
    protected abstract List<V> hasK1K2(K1 k1, K2 k2);

    protected abstract void addingNewVToLinkedList(List<V> linkedListValue, V v);


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

    public Map<Long, List<Price>> get(Object key) {
        return mapData.get(key);
    }

    public Map<Long, List<Price>> put(K1 key, Map<Long, List<Price>> value) {
        return mapData.put(key, value);
    }

    public Map<Long, List<Price>> remove(Object key) {
        return mapData.remove(key);
    }

//    public void putAll(@org.jetbrains.annotations.NotNull Map<? extends K1, ? extends LinkedHashMap<K2, LinkedList<V>>> m) {
//        mapData.putAll(m);
//    }

    public void clear() {
        mapData.clear();
    }

    public Set<K1> keySet() {
        return mapData.keySet();
    }

    public Collection<Map<Long, List<Price>>> values() {
        return mapData.values();
    }

    public Set<Map.Entry<K1, Map<Long, List<Price>>>> entrySet() {
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

    public Map<Long, List<Price>> getOrDefault(Object key, LinkedHashMap<Long, List<Price>> defaultValue) {
        return mapData.getOrDefault(key, defaultValue);
    }

    public void forEach(BiConsumer<K1, Map<Long, List<Price>>> action) {
        mapData.forEach(action);
    }

    public void replaceAll(BiFunction<K1, Map<Long, List<Price>>, Map<Long, List<Price>>> function) {
        mapData.replaceAll(function);
    }

    public Map<Long, List<Price>> putIfAbsent(K1 key, LinkedHashMap<Long, List<Price>> value) {
        return mapData.putIfAbsent(key, value);
    }

    public boolean remove(Object key, Object value) {
        return mapData.remove(key, value);
    }

    public boolean replace(K1 key, LinkedHashMap<Long, List<Price>> oldValue, LinkedHashMap<Long, List<Price>> newValue) {
        return mapData.replace(key, oldValue, newValue);
    }

    public Map<Long, List<Price>> replace(K1 key, LinkedHashMap<Long, List<Price>> value) {
        return mapData.replace(key, value);
    }

//    public LinkedHashMap<K2, LinkedList<V>> computeIfAbsent(K1 key, @org.jetbrains.annotations.NotNull Function<? super K1, ? extends LinkedHashMap<K2, LinkedList<V>>> mappingFunction) {
//        return mapData.computeIfAbsent(key, mappingFunction);
//    }
//
//    public LinkedHashMap<K2, LinkedList<V>> computeIfPresent(K1 key, @org.jetbrains.annotations.NotNull BiFunction<? super K1, ? super LinkedHashMap<K2, LinkedList<V>>, ? extends LinkedHashMap<K2, LinkedList<V>>> remappingFunction) {
//        return mapData.computeIfPresent(key, remappingFunction);
//    }
//
//    public LinkedHashMap<K2, LinkedList<V>> compute(K1 key, @org.jetbrains.annotations.NotNull BiFunction<? super K1, ? super LinkedHashMap<K2, LinkedList<V>>, ? extends LinkedHashMap<K2, LinkedList<V>>> remappingFunction) {
//        return mapData.compute(key, remappingFunction);
//    }
//
//    public LinkedHashMap<K2, LinkedList<V>> merge(K1 key, @org.jetbrains.annotations.NotNull LinkedHashMap<K2, LinkedList<V>> value, @org.jetbrains.annotations.NotNull BiFunction<? super LinkedHashMap<K2, LinkedList<V>>, ? super LinkedHashMap<K2, LinkedList<V>>, ? extends LinkedHashMap<K2, LinkedList<V>>> remappingFunction) {
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
