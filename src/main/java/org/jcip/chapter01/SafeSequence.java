package org.jcip.chapter01;

import org.jcip.annotations.GuardedBy;
import org.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SafeSequence {

    @GuardedBy("this")
    private static int value;

    public static synchronized int getNext() {
        return value++;
    }
}
