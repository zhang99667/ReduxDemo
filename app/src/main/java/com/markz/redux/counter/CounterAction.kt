package com.markz.redux.counter

/**
 * @author zhangzhen40
 * @version v1.0.0
 * @since 2025/02/11
 */
sealed class CounterAction {
    object Increment : CounterAction()
    object Decrement : CounterAction()
    object Reset : CounterAction()
}