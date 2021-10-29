package com.example.androidtechsample.playground

//fun test1() {
//  runBlocking {
//    launch {
//      println("1")
//      delay(1000L)
//      println("2")
//    }
//    launch {
//      println("3")
//    }
//  }
//}

//fun test2() {
//  val scope = CoroutineScope(EmptyCoroutineContext)
//  scope.launch { // １つ目のCoroutine
//    delay(1000L)
//    println("1")
//  }
//  scope.launch { // 2つ目のCoroutine
//    delay(1000L)
//    println("2")
//  }
//  scope.cancel() // 1つ目も2つ目もキャンセル
//}

//fun test3() {
//  runBlocking {
//    val job1 = launch {
//      println("start: job1")
//      delay(100L)
//      println("completed: job1")
//    }
//    val job2 = launch {
//      println("start: job2")
//      delay(100L)
//      println("completed: job2")
//    }
//    delay(50L)
//    job1.cancel()
//  }
//}

//fun test4() {
//  runBlocking {
//    val deferred1 = async {
//      delay(1000L)
//      1
//    }
//    val deferred2 = async {
//      delay(1000L)
//      2
//    }
//    println(deferred1.await() + deferred2.await())
//  }
//}

//fun test5() {
//  val emptyContext = EmptyCoroutineContext
//  val emptyScope = CoroutineScope(emptyContext)
//  emptyScope.launch {
//    delay(1000L)
//    println("emptyContext")
//  }
//
//  val dispatchersContext = Dispatchers.IO
//  val dispatchersScope = CoroutineScope(dispatchersContext)
//  dispatchersScope.launch {
//    delay(1000L)
//    println("dispatchersContext")
//  }
//
//  val job = Job()
//  val jobScope1 = CoroutineScope(job)
//  jobScope1.launch {
//    println("start1")
//    delay(1000L)
//    println("end1")
//  }
//  val jobScope2 = CoroutineScope(job)
//  jobScope2.launch {
//    println("start2")
//    delay(1000L)
//    println("end2")
//  }
//  Thread.sleep(500L)
//  job.cancel()
//  Thread.sleep(2000L)
//}

//fun test6() {
//  val exceptionHandler = CoroutineExceptionHandler { _, e ->
//    println("catch: $e")
//  }
//  val context = Job() + exceptionHandler
//  val scope = CoroutineScope(context)
//  scope.launch {
//    supervisorScope {
//      launch {
//        delay(500L)
//        throw Exception("error")
//        delay(500L)
//        println("completed 1")
//      }
//      launch { // not supervisor
//        delay(1000L)
//        println("completed 2")
//      }
//    }
//  }
//  Thread.sleep(2000L)
//}

// エラーが出ます
//fun test7() {
//  val context = Job()
//  val scope = CoroutineScope(context)
//  scope.launch {
//    val deferred = async {
//      delay(1000L)
//      throw Exception("error")
//    }
//    try {
//      println("result: ${deferred.await()}")
//    } catch (e: Throwable) {
//      println("catch: $e")
//    }
//  }
//  Thread.sleep(2000L)
//}

// test7のエラー出ないver
//fun test8() {
//  val exceptionHandler = CoroutineExceptionHandler { _, e ->
//    println("catch $e")
//  }
//  val context = Job() + exceptionHandler
//  val scope = CoroutineScope(context)
//  scope.launch {
//    val deferred = async {
//      delay(1000L)
//      throw Exception("error")
//    }
//    println("result: ${deferred.await()}")
//  }
//  Thread.sleep(2000L)
//}

fun main() {
//  test8()
}
