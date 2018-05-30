package org.learning.jvolatile.thread.stop;

/*先看一段代码，假如线程1先执行，线程2后执行：

//线程1
boolean stop = false;
while(!stop){
    doSomething();
}
 
//线程2
stop = true;
这段代码是很典型的一段代码，很多人在中断线程时可能都会采用这种标记办法。
但是事实上，这段代码会完全运行正确么？即一定会将线程中断么？不一定，也许在大多数时候，
这个代码能够把线程中断，但是也有可能会导致无法中断线程（虽然这个可能性很小，
但是只要一旦发生这种情况就会造成死循环了）。

下面解释一下这段代码为何有可能导致无法中断线程。在前面已经解释过，
每个线程在运行过程中都有自己的工作内存，那么线程1在运行的时候，
会将stop变量的值拷贝一份放在自己的工作内存当中。

那么当线程2更改了stop变量的值之后，但是还没来得及写入主存当中，
线程2转去做其他事情了，那么线程1由于不知道线程2对stop变量的更改，
因此还会一直循环下去。
*/
public class Action {
	private volatile boolean stop = false;

	public void doSomething() {
		System.out.println(Thread.currentThread().getName() + ": I am working!!!");
	}

	public boolean isStop() {
		return stop;
	}

	public void stop() {
		this.stop = true;
	}
}
