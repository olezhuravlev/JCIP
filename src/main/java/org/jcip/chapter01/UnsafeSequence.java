package org.jcip.chapter01;

import org.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {

    private static int value;

    public static int getNext() {
        return value++;
    }
}
