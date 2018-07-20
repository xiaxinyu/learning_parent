package org.learning.thread.base;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static void main(String[] args) {
		// 获取 Java 线程 管理MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		// 不需要 获取 同步 的 monitor 和 synchronizer 信息， 仅 获取 线程 和 线程 堆栈 信息
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
		// 遍历 线程 信息， 仅 打印 线程 ID 和 线程 名称 信息
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + ":" + threadInfo.getThreadName() + "] " + threadInfo);
		}
	}
}
