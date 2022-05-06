package BinaryTree;

public interface Dictionary<Key, E> {
    /** Reinitialize dictionary */
    public void claer();

    /** Insert a record */
    public void insert(Key k, E e);
    
    /** Remove and return a record (null if none exists). */
    public E remove(Key k);

    /** Remove and return an arbitrary record from dictionary. */
    public E removeAny();

    /** Return a record matching "k" (null if none exists). */
    public E find(Key k);

    /** @return The number of records in the dictionary. */
    public int size();
}