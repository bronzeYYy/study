### HashMap

1.7 头插法

1.8 尾插法，一个桶的元素达到8个，转化为红黑树

并发情况的死循环：

多个线程同时进行进行put操作时，大小达到了阈值后进行扩容时可能会产生循环链表问题，此时再这个桶中获取不存在的值则进行死循环

### HashTable

相比HashMap线程安全，不能存放null

高并发使用ConcurrentHashMap

### ConcurrentHashMap

不能存放null

使用分段锁，只锁住当前线程操作的桶

