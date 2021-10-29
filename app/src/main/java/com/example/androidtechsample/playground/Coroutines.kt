package com.example.androidtechsample.playground

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.coroutines.EmptyCoroutineContext

fun test1() {
  runBlocking {
    launch {
      println("test1:1")
      delay(1000L)
      println("test1:2")
    }
    launch {
      println("test1:3")
    }
  }
}

fun test2() {
  val scope = CoroutineScope(EmptyCoroutineContext)
  scope.launch { // １つ目のCoroutine
    delay(1000L)
    println("test2:1")
  }
  scope.launch { // 2つ目のCoroutine
    delay(1000L)
    println("test2:2")
  }
  scope.cancel() // 1つ目も2つ目もキャンセル
}

fun test3() {
  runBlocking {
    val job1 = launch {
      println("test3:start: job1")
      delay(100L)
      println("test3:completed: job1")
    }
    launch {
      println("test3:start: job2")
      delay(100L)
      println("test3:completed: job2")
    }
    delay(50L)
    job1.cancel()
  }
}

fun test4() {
  runBlocking {
    val deferred1 = async {
      delay(1000L)
      1
    }
    val deferred2 = async {
      delay(1000L)
      2
    }
    println("test4" + deferred1.await() + deferred2.await())
  }
}

fun test5() {
  val emptyContext = EmptyCoroutineContext
  val emptyScope = CoroutineScope(emptyContext)
  emptyScope.launch {
    delay(1000L)
    println("test5:emptyContext")
  }

  val dispatchersContext = Dispatchers.IO
  val dispatchersScope = CoroutineScope(dispatchersContext)
  dispatchersScope.launch {
    delay(1000L)
    println("test5:dispatchersContext")
  }

  val job = Job()
  val jobScope1 = CoroutineScope(job)
  jobScope1.launch {
    println("test5:start1")
    delay(1000L)
    println("test5:end1")
  }
  val jobScope2 = CoroutineScope(job)
  jobScope2.launch {
    println("test5:start2")
    delay(1000L)
    println("test5:end2")
  }
  Thread.sleep(500L)
  job.cancel()
  Thread.sleep(2000L)
}

fun test6() {
  val exceptionHandler = CoroutineExceptionHandler { _, e ->
    println(":catch: $e")
  }
  val context = Job() + exceptionHandler
  val scope = CoroutineScope(context)
  scope.launch {
    supervisorScope {
      launch {
        delay(500L)
        throw Exception("test6:error")
      }
      launch { // not supervisor
        delay(1000L)
        println("test6:completed 2")
      }
    }
  }
  Thread.sleep(2000L)
}

// エラーが出ます
fun test7() {
  val context = Job()
  val scope = CoroutineScope(context)
  scope.launch {
    val deferred = async {
      delay(1000L)
      throw Exception("test7:error")
    }
    try {
      println("test7:result: $deferred")
    } catch (e: Throwable) {
      println("test7:catch: $e")
    }
  }
  Thread.sleep(2000L)
}

// test7のエラー出ないver
fun test8() {
  val exceptionHandler = CoroutineExceptionHandler { _, e ->
    println("test8:catch $e")
  }
  val context = Job() + exceptionHandler
  val scope = CoroutineScope(context)
  scope.launch {
    val deferred = async {
      delay(1000L)
      throw Exception("test8:error")
    }
    println(":result: $deferred")
  }
  Thread.sleep(2000L)
}

fun main() {
  test1()
  test2()
  test3()
  test4()
  test5()
  test6()
  test7()
  test8()
}
