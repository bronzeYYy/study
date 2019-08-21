### 线程中断

调用Thread.interrupt()中断线程。如果线程处于阻塞（BLOCKED）、等待（WAITING、TIMED_WAITING）则会抛出InterruptedException，从而提前结束线程。但不能中断IO阻塞和synchronized锁阻塞。

### CountDownLatch

用于线程等待多个线程都执行完了countDownLatch.countDown();前面的代码。线程到达后会继续执行，不会等待所有的线程都执行到此。



### CyclicBarrier

用来控制多个线程互相等待，都到达cyclicBarrier.await();才同时继续执行。

CyclicBarrier的构造函数第二个参数为可选参数Runnable，所有线程到达屏障会执行。

### Semaphore

信号量，用来控制同时进入semaphore.acquire();和semaphore.release();之间的线程个数，比锁更强大。