"# Backend-Fundamentals" 
Part 1: The Foundation - How Computers Actually Talk
The Socket: A socket is literally just a file descriptor that allows two programs to communicate  either on the same machine or across the internet.

# Basic Server in Java

Think of it like a telephone.

 You pick up the phone (create a socket),
 dial a number (connect to an address), 
 and talk (send data).

# Testing our program
 curl http://localhost:8080
# You'll see: Hello from raw socket server!
```

**What just happened?**

1. `ServerSocket` binds to port 8080 and listens
2. `accept()` blocks until a client connects
3. We read the HTTP request line by line
4. We manually construct an HTTP response
5. We close the connection



