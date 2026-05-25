
public class main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();

        rateLimiter.allowRequest(101);
        rateLimiter.allowRequest(101);
        rateLimiter.allowRequest(101);
        rateLimiter.allowRequest(101);
        rateLimiter.allowRequest(101);
        rateLimiter.allowRequest(101);

        rateLimiter.allowRequest(202);
        rateLimiter.allowRequest(303);
        rateLimiter.allowRequest(404);
        Thread.sleep(12000); // pauses execution for 12sec
        rateLimiter.allowRequest(101);

    }
}