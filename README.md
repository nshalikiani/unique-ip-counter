
## Task description

A simple text file with IPv4 addresses is given. One line is one address, something like this:

```
145.67.23.4
8.34.5.23
89.54.3.124
89.54.3.124
3.45.71.5
...
```
The file size is not limited and can occupy tens and hundreds of gigabytes.

It is necessary to calculate the number of unique IP addresses in this file, consuming as little memory and time as possible. 
There is a "naive" algorithm for solving this task (we read strings and put it in HashSet), it is desirable that your implementation is better than this simple, naive algorithm.

## Solution

Since "naive" approach of using HashSet was not allowed, I provided two other possible solutions.

My first solution is to have a four dimensional byte array where each dimension will represent part of IP address.
This solution is linear (it will take O(n) time), but it's not the most optimal in terms of memory usage, 
it will need approximately 4gb of memory, so that's why I provided another solution.

My second solution's main idea is to use bits instead of bytes (to reduce memory usage 8 times).
I used two BitSets for storage (since BitSet can only store maximum amount of Integer, we need two of them), main idea 
here is to transform ipAddress into unique integer and than mark it "already read" in BitSet.

I assumed that Ip addresses are in the correct format,so I didn't provide some validations for that.

## Build and Run

To build jar file:
```
mvn clean install  
```

To run the app with file path argument(it will run BitSet solution by Default, but you can specify it in the argument too):
```
java -jar target/unique-ip-counter-1.0.1.jar file_path
java -jar target/unique-ip-counter-1.0.1.jar file_path BitSet

```

To run the app with four dimensional array solution (we need to specify which solution two run in the arguments
and also we need to increase heap memory size, since default value is not enough):

```
java -Xms8g -Xmx8g -jar target/unique-ip-counter-1.0.1.jar file_path 4dArray

```


