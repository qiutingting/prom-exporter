package exporter;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sungaofei on 20/2/13.
 */
public class CustomExporter {
    static final Counter requests = Counter.build()
            .name("my_library_requests_total").help("Total requests.")
            .labelNames("method").register();

    public static void processGetRequest() {
        requests.labels("get").inc();
        // Your code here.
    }

    public static void main(String[] args) throws IOException {
        new RitDBExporter().register();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(() -> {
//            double currect = 1;
            double value = requests.labels("get").get();
            System.out.println(value);


            requests.labels("get").inc();
        }, 0, 10, TimeUnit.SECONDS);
        HTTPServer server = new HTTPServer(1234);


    }
}
