package pucrs;

public interface ListTAD {
	public void add(int element);

    public void add(int index, int element);

    public int get(int index);

    public int set(int index, int element);

    public boolean remove(int element);
    public int removeByIndex(int index);

    public boolean isEmpty();

    public int size();

    public boolean contains(int element);

    public int indexOf(int element);

    public void clear();
}
