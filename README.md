# API Rate Limiter using Sliding Window Algorithm

## What is Rate Limiting?

Rate limiting is a technique used to control the number of requests a user or client can send to a system within a specific time window.

It helps protect systems from:
- Server overload
- Excessive traffic
- API abuse
- DDoS attacks
- Resource exhaustion

Rate limiting is widely used in:
- Backend APIs
- Authentication systems
- Payment gateways
- Distributed systems
- Cloud services

---

## Why is Rate Limiting Important?

Without rate limiting, a large number of incoming requests can:
- degrade system performance
- increase server load
- exhaust system resources
- affect other users

Rate limiting helps:
- maintain system stability
- improve reliability
- ensure fair resource usage
- prevent malicious traffic spikes

---

## Sliding Window Algorithm

This project implements rate limiting using the Sliding Window algorithm.

The Sliding Window approach tracks requests continuously within a moving time window instead of fixed intervals.

Example:
- Maximum Requests Allowed = 5
- Time Window = 10 seconds

If a user sends more than 5 requests within the last 10 seconds, additional requests are denied.

Older expired requests are automatically removed from the tracking queue.

---

## Why Sliding Window is Commonly Used?

Sliding Window is widely used because it provides:
- smoother traffic control
- better accuracy
- fair request distribution
- reduced burst traffic problems

Compared to Fixed Window algorithms, Sliding Window prevents sudden request spikes near window boundaries.

---

## Why HashMap and Queue?

This project combines:
- HashMap
- Queue

to efficiently manage per-user request tracking.

### HashMap
Used for:
- storing user-specific request data
- fast user lookup
- efficient request management

### Queue
Used for:
- maintaining request timestamps in chronological order
- removing expired requests efficiently
- tracking requests within the active sliding window

Combining both data structures enables efficient rate limiting.

---

## Project Overview

This project implements an API Rate Limiter using the Sliding Window algorithm in Java.

The system:
- tracks requests for each user
- removes expired requests automatically
- validates incoming requests
- accepts or rejects requests based on configured limits

The implementation simulates real-world API traffic throttling mechanisms used in backend systems.

---

## Features

- Sliding Window based rate limiting
- Per-user request tracking
- Automatic expiration of old requests
- Request throttling mechanism
- HashMap + Queue implementation
- Real-time request validation
- Efficient timestamp management

---

## Tech Stack

- Java
- HashMap
- Queue
- ArrayDeque
- Object-Oriented Programming (OOP)

---

## Project Structure

```text
RateLimiter.java
Main.java
```

---

## Sample Output

### Request Accepted

```text
============================================================
INCOMING API REQUEST
User ID        : 101
Request Status : ACCEPTED
Reason         : Within Rate Limit
============================================================
```

### Request Denied

```text
============================================================
INCOMING API REQUEST
User ID        : 101
Request Status : DENIED
Reason         : Rate Limit Exceeded
============================================================
```

### Sliding Window Expiration

```text
============================================================
SLIDING WINDOW UPDATE
Expired Requests Removed Successfully
Window Status : Updated
============================================================
```

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/Monishohms/api-rate-limiter-sliding-window.git
```

2. Compile Java files

```bash
javac *.java
```

3. Run the project

```bash
java Main
```

---

## Future Improvements

- Thread-Safe Rate Limiter
- Distributed Rate Limiting
- Redis Integration
- REST API Integration
- Dynamic Configuration
- Monitoring and Analytics Dashboard
- Token Bucket and Leaky Bucket Algorithms
