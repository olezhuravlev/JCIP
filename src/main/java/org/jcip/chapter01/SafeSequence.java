package org.jcip.chapter01;

import org.jcip.chapter01.annotations.GuardedBy;
import org.jcip.chapter01.annotations.ThreadSafe;

@ThreadSafe
public class SafeSequence {

    @GuardedBy("this")
    private static int value;

    public static synchronized int getNext() {
        return value++;
    }
}
