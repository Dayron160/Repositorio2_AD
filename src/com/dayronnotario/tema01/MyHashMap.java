package com.dayronnotario.tema01;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {
    private int size;
    private Node<K,V>[][] data;
    private int capacity;
    private Node<K, V>[][] resizedData;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        data = new Node[capacity][capacity];
        size = 0;
    }

    private int hash(K key, Node<K, V>[][] matrix) {
        int hash = key.hashCode();
        hash = hash * 31;
        hash = hash & 0x7FFFFFFF;
        return hash % matrix.length;
    }

    private int hash(K key) {
        return(hash(key, data));
    }

    public V put(K key, V value) {
        return (put(key, value, data));
    }

    private V put(K key, V value, Node<K, V>[][] matrix) {
        int column = hash(key, matrix);
        int row;
        Node<K, V> node = null;
        for (row = 0; row < matrix.length; row++) {
            node = matrix[row][column];
            if (node == null || node.getKey().equals(key)) {
                break;
            }
        }
        if (row == matrix.length) {
            matrix = resize();
        }
        Node<K, V> oldValue = matrix[row][column];
        matrix[row][column] = new Node<>(key, value);
        if (node != null) {
            if (!node.getKey().equals(key)) {
                size ++;
            }
        }
        if (oldValue == null) {
            return null;
        }
        return oldValue.getValue();
    }

    public V get(K key) {
        int column = hash(key);
        for (int row = 0; row < data.length; row++) {
            Node<K, V> node = data[row][column];
            if (node == null) {
                return null;
            }
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    private Node<K, V>[][] resize() {
        resizedData = new Node[data.length * 2][data.length * 2];
        size = 0;
        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                Node<K, V> node = data[row][column];
                put(node.key, node.value, resizedData);
            }
        }
        data = resizedData;
        return resizedData;
    }

    public V remove(K key) {
        int column = hash(key);
        Node<K, V> position = null;
        for (int row = 0; row < data.length; row++) {
            Node<K, V> node = data[row][column];
            if (position != null) {
                if (row != (data.length - 1)) {
                    if (data[row + 1][column] != null) {
                        data[row][column] = data[row + 1][column];
                    } else {
                        data[row][column] = null;
                        break;
                    }
                } else data[row][column] = null;
            } else {
                if (node == null) {
                    System.out.println("Key no encontrada");
                    return null;
                }
                if (node.getKey().equals(key)) {
                    position = data[row][column];
                    size --;
                    if (row != (data.length - 1)) {
                        if (data[row + 1][column] != null) {
                            data[row][column] = data[row + 1][column];
                        } else {
                            data[row][column] = null;
                        }
                    } else data[row][column] = null;
                }
            }
        }
        if (position != null) {
            return position.getValue();
        }
        System.out.println("Key no encontrada");
        return null;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (int column = 0; column < data[0].length; column++) {
            for (int row = 0; row < data.length; row++) {
                Node<K, V> node = data[row][column];
                if (node == null) {
                    break;
                }
                values.add(node.getValue());
            }
        }
        return values;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (int column = 0; column < data[0].length; column++) {
            for (int row = 0; row < data.length; row++) {
                Node<K, V> node = data[row][column];
                if (node == null) {
                    break;
                }
                keys.add(node.getKey());
            }
        }
        return keys;
    }

    static class Node<K, V> {
        private final K key;
        private final V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
