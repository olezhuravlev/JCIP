package org.jcip.annotations;

/**
 * Specifies synchronizing monitor.
 */
public @interface GuardedBy {

    String value() default "";
}
