package org.jcip.chapter01.annotations;

/**
 * Specifies synchronizing monitor.
 */
public @interface GuardedBy {

    String value() default "";
}
