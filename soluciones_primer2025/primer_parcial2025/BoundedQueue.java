public class BoundedQueue<T> implements BoundedQueueInterface<T> {

	private T[] array;
	private int head;
	private int tail;
	private int size;
	private int capacity;

	@SuppressWarnings("unchecked")
	public BoundedQueue(int limit) {
		this.capacity = limit;
		this.array = (T[]) new Object[limit];
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public boolean isFull() {
		return size == capacity;
	}

	@Override
	public void enqueue(T element) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		array[tail] = element;
		tail = (tail + 1) % capacity;
		size++;
	  }

	@Override
	public T dequeue()  {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T element = array[head];
		array[head] = null;
		head = (head + 1) % capacity;
		size--;
		return element;
	}


}
