import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data; // Массив для хранения элементов стека
    private int size; // Текущий размер стека

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен!");
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T element = data[--size];
        data[size] = null; // Удаляем ссылку для предотвращения утечки памяти
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

