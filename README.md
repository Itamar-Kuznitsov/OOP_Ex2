# Object-Oriented Programming Ex_2

## Description
This is the third task in Object-Oriented Programming course (OOP).

There are two parts in this task: Ex2_1 & Ex2_2.

__Ex2_1:__ 
 * In our program we read and calculate the number of lines in list of files, using normal method(without using Thread), a method using Thread and another           method using Thread Pool.
 
__Ex2_2:__
 This program has two parts:
 * A generic task with a Type that returns a result and may throw an exception.
   Each task has a priority used for scheduling͕ inferred from the integer value of the task͛s Type.
 * A custom thread pool class that defines a method for submitting a generic task to a priority queue, created by a
   Callable<V> and a Type, passed as arguments.

In this program we used S.O.L.I.D principles 

and we added Test class for checking the reliability and the efficiency of the code.




### UML diagrams:

![Ex2_2 UML](https://user-images.githubusercontent.com/72256735/212062441-e37902a5-83c2-4ad6-888b-dee776209327.png)



![image](https://user-images.githubusercontent.com/72256735/212135706-c5e191f4-190a-441a-af82-8444db41e330.png)


## Getting Started
### Dependencies
Based on Maven - build automation tool by the Apache Group.

Our pom.xml include:
 
* org.junit.jupiter - version 5.9.0
 
### Installing
* Download the program to your local machine
* Extract the files
### Executing program
* Via IDE:

  * Open the files in your favorite IDE
  * Run the files via the IDE
  * Via Command line:

* Open CMD
  * Enter to your file location by the command: cd
  * Compile the java file by the following command:
```
javac <Name_Of_File>.java
```

Then run it by:
```
java <Name_Of_File>
```

## Conclusion
There are a lot of discussions of using the ThreadPool and creating your own threads.
During the semester, we learned that Java Virtual Machine (JVM)
allows a Java application to have multiple threads of execution running concurrently.
The Thread class supports the creation of platform threads that are typically mapped 1:1 to kernel threads, scheduled
by the operating system.

Let's talk about the pros and cons:

 __Creating your own threads:__
* Pros 
 * More efficient for long running, or blocking tasks.
* Cros
 * Creating and destroying threads has a high CPU usage, can severely affect the final response time of the task. 
   Executing multiple threads can push CPU to 100% and most of the time would be wasted in swapping threads in and out of the processor along with their memory.
   
__Using Thread Pool:__
* Pros
 * Threads are created ahead of time and kept around to pick up any work items you give them to do, without the overhead associated with    creating your own          threads.
* Cros
 * require a thread to have a particular priority.
 * The thread pool has a maximum number of threads, so a large number of blocked thread pool    threads might prevent tasks from starting.

 __500 files:__
 
![image](https://user-images.githubusercontent.com/72256735/212047684-bf9708ac-faec-4d33-a5e7-5bffc39e9993.png)

 __5000 files:__

 ![image](https://user-images.githubusercontent.com/72256735/212047772-5fc169af-434b-4358-984d-9c236f1bde7b.png)

In conclusion, as we expected, with 500 files there is a big difference between the normal method and Thread/ThreadPool methods. With 5000 files there is significant difference.
Compared to Thread Pool and Thread, the times are not clear. In the short plan Thread Pool is more efficient and in the long plan using Thread is more efficient.
In our opinion, this difference happens due to the processing power of the computer. 
Because when there are many operations in relation to the size of the pool, then the queue is larger and the number of tasks that are performed is small.
Therefore it seems that Thread Pool is slower because the number of active threads is smaller than execution by normal Thread. 
 
 
## Authors
Made by

* [Itamar Kuznitsov](https://github.com/Itamar-Kuznitsov)
* [Aaron Luchan](https://github.com/aronl096)
 
## Version
* 0.1
  * Initial Release ~ Jan 2023
