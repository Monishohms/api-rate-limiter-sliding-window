import java.util.*;

public class RateLimiter {
    static int reqCapacity = 5;
    static long windowSize = 10000; // 1sec = 1000 ms so, 10sec = 10*1000 ms
    static Map<Integer, Queue<Long>> reqInfo = new HashMap<>();

    public static void allowRequest(int userId) {
        long currentTime = System.currentTimeMillis();
        boolean isExistingUser = reqInfo.containsKey(userId);
        if (!isExistingUser) {
            Queue<Long> reqTimeStamp = new ArrayDeque<>();
            reqTimeStamp.offer(currentTime);
            reqInfo.put(userId, reqTimeStamp);
            System.out.println("============================================================");
            System.out.println("Incoming Request From User : " + userId);
            System.out.println("Current Time               : " + currentTime);
            System.out.println("Request Status             : " + "Accepted");
            System.out.println("Recent Requests Queue      : " + reqTimeStamp);

        } else {
            Queue<Long> reqQueue = reqInfo.get(userId);
            removeExpiredRequests(reqQueue, currentTime); // removes expired req present in the reqQueue
            if (reqQueue.size() >= reqCapacity) {
                System.out.println("============================================================");
                System.out.println("Incoming Request From User : " + userId);
                System.out.println("Current Time               : " + currentTime);
                System.out.println("Request Status             : " + "Denied");
                System.out.println("Reason                     : " + "Rate Limit Exceeded");
                System.out.println("Recent Requests Queue      : " + reqQueue);

            } else {
                reqQueue.offer(currentTime);
                System.out.println("============================================================");
                System.out.println("Incoming Request From User : " + userId);
                System.out.println("Current Time               : " + currentTime);
                System.out.println("Request Status             : " + "Accepted");
                System.out.println("Recent Requests Queue      : " + reqQueue);
            }
        }

    }

    public static void removeExpiredRequests(Queue<Long> queue, long currentTime) {

        long expiredReq = currentTime - windowSize;

        while (!queue.isEmpty()) {
            long req = queue.peek();
            if (req < expiredReq)
                queue.poll();
            else
                break;

        }

    }

}
