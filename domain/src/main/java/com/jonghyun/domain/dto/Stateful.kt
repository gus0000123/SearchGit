package com.jonghyun.domain.dto

/**
 * Success -> 항상 유효한 데이터만 담긴다.
 * Empty -> 데이터가 없다.
 * Loading -> 데이터를 불러오는 중이다. 이후 Success, Empty 등의 상태로 변경
 * Error -> 오류 발생한것에 대한 예외처리(필요하면)
 */
sealed class Stateful<out R> {
    data class Success<out T>(val value: T) : Stateful<T>()
    data class Error(val exception: Throwable) : Stateful<Nothing>()
    object Empty : Stateful<Nothing>()
    object Loading : Stateful<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$value]"
            is Error -> "Error[exception=$exception]"
            is Empty -> "Empty"
            Loading -> "Loading"
        }
    }
}

