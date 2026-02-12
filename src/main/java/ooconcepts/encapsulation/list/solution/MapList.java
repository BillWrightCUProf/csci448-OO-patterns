package ooconcepts.encapsulation.list.solution;

import ooconcepts.encapsulation.list.IOOList;

import java.util.HashMap;
import java.util.Map;

public class MapList implements IOOList {
    private Map<Integer, Object> map;
    private int size = 0;

    public MapList() {
        clear();
    }

    @Override
    public void add(Object element) {
        map.put(size++, element);
    }

    @Override
    public Object remove(int index) {
        Object removed = map.remove(index);
        for (int i = index; i < size - 1; i++) {
            map.put(i, map.get(i + 1));
        }
        map.remove(size - 1);
        size--;
        return removed;
    }

    @Override
    public Object get(int index) {
        return map.get(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        map = new HashMap<>();
        size = 0;
    }
}
