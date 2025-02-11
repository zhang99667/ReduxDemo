package com.markz.redux.counter

import org.reduxkotlin.Reducer

/**
 * Reducer：根据当前 state 和 Action 返回新的 state
 *
 * @author zhangzhen40
 * @version v1.0.0
 * @since 2025/02/11
 */
class CounterReducer {
    val counterReducer: Reducer<CounterState> = { state, action ->
        when (action) {
            is CounterAction.Increment -> state.copy(count = state.count + 1)
            is CounterAction.Decrement -> state.copy(count = state.count - 1)
            is CounterAction.Reset -> state.copy(count = 0)
            else -> state
        }
    }
}