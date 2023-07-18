package com.example.common.util;

import java.util.Collection;


/**
 * Provide many helper methods to verify objects state
 */
/**
 * Creator: Nguyen Ngoc Tri
 * Date: 6/26/2023
 * Time: 11:14 PM
 */
public final class States {

    /**
     * Determine whether string is null or empty.
     * Return true if string is null or empty
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(String obj){
        return isNull(obj) || obj.isEmpty();
    }

    /**
     * Determine whether object is null.
     * Return true if object is null
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj){
        return obj == null;
    }

    /**
     * Determine whether object is NOT null.
     * Return true if object is NOT null
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    /**
     * Determine whether two possibly-null objects are equal.
     * Return true if objects are equal
     * @param first
     * @param second
     * @return
     */
    public static boolean equal(Object first, Object second){
        return first.equals(second);
    }

    /**
     * Determine whether two possibly-null objects are NOT equal.
     * Return true if objects are NOT equal
     * @param first
     * @param second
     * @return
     */
    public static boolean notEqual(Object first, Object second){
        return !equal(first, second);
    }

    /**
     * Determine whether collection is null or empty
     *
     * @param collection
     * @return
     */
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return isNull(collection) || collection.isEmpty();
    }
}
