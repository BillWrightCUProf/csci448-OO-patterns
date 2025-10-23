package examples.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Reference: https://medium.com/@b.stoilov/everything-you-need-to-know-about-thread-pools-in-java-fe02e803d339#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjI1ZjgyMTE3MTM3ODhiNjE0NTQ3NGI1MDI5YjAxNDFiZDViM2RlOWMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTAwMDE4MTEzMjk2Njc3MzUwMjgiLCJlbWFpbCI6ImJpbGx3cmlnaHQ1MTBAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5iZiI6MTc0MTMwNTg0MywibmFtZSI6IkJpbGwgV3JpZ2h0IiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hL0FDZzhvY0lteER5bzRqTFJSY2F6TGVwdlVmTnBNR3JJNFJZTEpraDlWanZET29VanIyMkhWakY5OHc9czk2LWMiLCJnaXZlbl9uYW1lIjoiQmlsbCIsImZhbWlseV9uYW1lIjoiV3JpZ2h0IiwiaWF0IjoxNzQxMzA2MTQzLCJleHAiOjE3NDEzMDk3NDMsImp0aSI6IjQ0NGZmMWI1ZDY5YWJjZjA2MmQ0MzJiYjgzMjAzYTg2MzBhZjMyMjQifQ.wI3jWdgXwxwNeE6cftbgJuHeghcjjM03tNGaro9B8RNN8pfR8hQaEgvjKL3tW6p9Z2EiDDk-XuDr361AKaaA1rVodjQ5gNK5LzxQeJTq626uHSXltmlrY_NRSUCGtJT90UpI5dFmYeLAFAvb3pvTNdaNtcxluuRYJpG2EzE5ja1DKAxkQiPXjj-ghTne_od7RsrplsW_SL0cJOY_JJWaZAO6OAF-VeYHZIJTlcF7bkWi3ACx94iAgg0m-k-XhQwdwVQ44QaKMO4vXucGNh5iqcvY32vJvYNx6O_Qr0Nnx8vunh-8SZ8KOSlhAawYk5EanxgXj7Gwg8WAC5xZ283HCw

public class ThreadExample {
    int threadCount = 1;
    int taskCount = 50;

    ThreadExample(int threadCount, int taskCount) {
        this.threadCount = threadCount;
        this.taskCount = taskCount;
    }

    public void executeFixedThreadPool() {
        // Executors is a Factory that creates instances of ExecutorService

        // Thread pools in Java are autoclosable. This means we can put them in a
        // try-with-resources block, and they’ll wait for all submitted tasks to complete
        // before moving on.
        try (ExecutorService threadPool = Executors.newFixedThreadPool(threadCount)) {
            execute(threadPool);
        }
    }

    public void executeCachedThreadPool() {
        try (ExecutorService threadPool = Executors.newCachedThreadPool()) {
            execute(threadPool);
        }
    }

    public void executeScheduledThreadPool() {
        try (var threadPool = Executors.newScheduledThreadPool(threadCount)) {
            for (int i = 0; i < taskCount; i++) {
                long delayInSeconds = new Random().nextInt(5);
                String message = "Scheduled task " + i + " started with " + delayInSeconds + " seconds delay";
                threadPool.schedule(() -> System.out.println(message), delayInSeconds, TimeUnit.SECONDS);
            }
            System.out.println("Scheduled tasks submitted");
        }
    }

    public void execute(ExecutorService threadPool) {
        for (int i = 0; i < taskCount; i++) {
            String message = "Running task " + i + "...";
            threadPool.submit(() -> System.out.println(message));
        }
    }


}
