package pilhas_filas;

public interface QueueTAD {
	public void enqueue(int e);
    public int dequeue();
    public int head();
    public void clear();
    public boolean isEmpty();
    public int size();
}
