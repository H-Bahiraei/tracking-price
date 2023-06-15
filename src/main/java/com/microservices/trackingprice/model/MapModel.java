package com.microservices.trackingprice.model;

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

    public Map<K1, Map<K2, List<V>>> mapData = new HashMap<>(); // diamond operator // Scope IOC: one obj //ToDo get all // TODO ConcurrentHashMap

    /*
     Adding new record to HashMap
     */
    protected abstract Map<K2, List<V>> hasK1AndGetLinkedHashMap(K1 k1);

    public void insertNewRecordToHashMap(K1 k1, K2 k2, V v) {
        this.putNewRecordToHashMap(k1, this.createNewLinkedHashMapWithKeyAndValue(
                k2, this.createNewLinkedListWithValue(v)));
    }

    protected abstract List<V> createNewLinkedListWithValue(V v);

    public abstract Map<K2, List<V>> createNewLinkedHashMapWithKeyAndValue(K2 alongKey, List<V> linkedListValue);

    protected abstract void putNewRecordToHashMap(K1 k1, Map<K2, List<V>> linkedHashMapValue);


    /*
    For adding new price
    */
    protected abstract List<V> hasK1K2AndGetLinkedList(K1 k1, K2 k2);

    protected abstract void addingNewVToLinkedList(List<V> linkedListValue, V v);

    /*
     For adding new date-price
     */
    public abstract List<V> addingNewRecordToExistingLinkedHashMap(Map<K2, List<V>> linkedHashMap, K2 k2, V v);

    /*
     * Dandelion Map
     * @return
     */
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

    public Map<K2, List<V>> get(Object key) {
        return mapData.get(key);
    }

    public Map<K2, List<V>> put(K1 key, Map<K2, List<V>> value) {
        return mapData.put(key, value);
    }

    public Map<K2, List<V>> remove(Object key) {
        return mapData.remove(key);
    }

//    public void putAll(@org.jetbrains.annotations.NotNull Map<? extends K1, ? extends Map<K2, List<V>>> m) {
//        mapData.putAll(m);
//    }

    public void clear() {
        mapData.clear();
    }

    public Set<K1> keySet() {
        return mapData.keySet();
    }

    public Collection<Map<K2, List<V>>> values() {
        return mapData.values();
    }

    public Set<Map.Entry<K1, Map<K2, List<V>>>> entrySet() {
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

    public Map<K2, List<V>> getOrDefault(Object key, Map<K2, List<V>> defaultValue) {
        return mapData.getOrDefault(key, defaultValue);
    }

    public void forEach(BiConsumer<? super K1, ? super Map<K2, List<V>>> action) {
        mapData.forEach(action);
    }

    public void replaceAll(BiFunction<? super K1, ? super Map<K2, List<V>>, ? extends Map<K2, List<V>>> function) {
        mapData.replaceAll(function);
    }

    public Map<K2, List<V>> putIfAbsent(K1 key, Map<K2, List<V>> value) {
        return mapData.putIfAbsent(key, value);
    }

    public boolean remove(Object key, Object value) {
        return mapData.remove(key, value);
    }

    public boolean replace(K1 key, Map<K2, List<V>> oldValue, Map<K2, List<V>> newValue) {
        return mapData.replace(key, oldValue, newValue);
    }

    public Map<K2, List<V>> replace(K1 key, Map<K2, List<V>> value) {
        return mapData.replace(key, value);
    }


//    public Map<K2, List<V>> computeIfAbsent(K1 key, @org.jetbrains.annotations.NotNull Function<? super K1, ? extends Map<K2, List<V>>> mappingFunction) {
//        return mapData.computeIfAbsent(key, mappingFunction);
//    }
//
//    public Map<K2, List<V>> computeIfPresent(K1 key, @org.jetbrains.annotations.NotNull BiFunction<? super K1, ? super Map<K2, List<V>>, ? extends Map<K2, List<V>>> remappingFunction) {
//        return mapData.computeIfPresent(key, remappingFunction);
//    }
//
//    public Map<K2, List<V>> compute(K1 key, @org.jetbrains.annotations.NotNull BiFunction<? super K1, ? super Map<K2, List<V>>, ? extends Map<K2, List<V>>> remappingFunction) {
//        return mapData.compute(key, remappingFunction);
//    }
//
//    public Map<K2, List<V>> merge(K1 key, @org.jetbrains.annotations.NotNull Map<K2, List<V>> value, @org.jetbrains.annotations.NotNull BiFunction<? super Map<K2, List<V>>, ? super Map<K2, List<V>>, ? extends Map<K2, List<V>>> remappingFunction) {
//        return mapData.merge(key, value, remappingFunction);
//    }
}
