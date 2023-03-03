package MyCollections;

public interface MyListInterface<T> {
    public void add(T t);

    public void add(T t, int index);

    public T get(int index);

    public void remove(int index);

    public void clear();

    public void replace(T t, int index);

    public int length();

    public boolean contains(T t);

    public String toString();

    public void trimToSize();
}
