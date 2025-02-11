package com.markz.redux.counter

import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore

/**
 * 创建 Redux Store
 * 使用 redux-kotlin 的 createStore 方法创建 store，
 * 并绑定 reducer、初始状态和 middleware。
 *
 * @author zhangzhen40
 * @version v1.0.0
 * @since 2025/02/11
 */

val store = createStore(
    reducer = CounterReducer().counterReducer,
    preloadedState = CounterState(),
    enhancer = applyMiddleware(CounterMiddleware())
)
