package com.markz.redux.counter

import android.util.Log
import org.reduxkotlin.Dispatcher
import org.reduxkotlin.Middleware
import org.reduxkotlin.Store

/**
 * 拦截 Action，可以在这里执行日志记录、异步操作等副作用。
 *
 * @author zhangzhen40
 * @version v1.0.0
 * @since 2025/02/11
 */
class CounterMiddleware : Middleware<CounterState> {
    override fun invoke(store: Store<CounterState>): (next: Dispatcher) -> (action: Any) -> Any {
        return { next ->
            { action ->
                // 在这里实现具体的逻辑
                // 可以访问 store、next 和 action
                when (action) {
                    // 当触发 Increment 操作时，输出日志显示当前 count 值
                    is CounterAction.Increment -> Log.d("LOG","\uD83D\uDD39 Action: $action 被触发，当前 count : ${store.getState().count}")
                }
                // 返回一个 Any 类型的值, 例如，直接返回 action
                next(action) // 继续传递 action
            }
        }
    }
}