package ooconcepts.encapsulation.list;

public interface IOOList {
    void add(Object element);
    Object remove(int index);
    Object get(int index);
    int size();
    void clear();
}
