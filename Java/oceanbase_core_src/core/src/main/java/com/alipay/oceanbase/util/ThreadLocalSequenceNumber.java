package com.alipay.oceanbase.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 
 * @author liangjie.li
 * @version $Id: ThreadLocalSequenceNumber.java, v 0.1 Jun 27, 2013 5:18:30 PM liangjie.li Exp $
 */
public class ThreadLocalSequenceNumber {
    private final AtomicInteger  uniqueId  = new AtomicInteger(0);
    private ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>() {
                                                      @Override
                                                      protected Integer initialValue() {
                                                          return uniqueId.getAndIncrement();
                                                      }
                                                  };

    /**
     * 
     * 
     * @return
     */
    public int getSequenceNumber() {
        uniqueNum.set(uniqueNum.get() + 1);
        return uniqueNum.get();
    }
}
