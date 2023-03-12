package swt.home.control.app;

import java.util.*;

public class CustomArrayList<E> extends ArrayList<E> {
  private int capacity = 0;
  private int currentElements = 0;

  public CustomArrayList() {
    this(10);
  }

  public CustomArrayList(int capacity) {
    super(capacity);
    this.capacity = capacity;
  }

  @Override
  public boolean add(E e) {
    if (currentElements == capacity) {
      remove(0);
    } else {
      currentElements++;
    }
    return super.add(e);
  }
}
