package gaofei;

import exporter.CustomExporter;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

/**
 * Created by sungaofei on 21/2/2.
 */
public class Test {
    private static CollectorRegistry registry = new CollectorRegistry();
    private static Gauge serviceStatus = Gauge.build()
            .name("my_service_is_enable").help("if the service is enable.").register(registry);

    public static void main(String[] args) {
        System.out.println(1111);

    }

    @org.testng.annotations.Test
    public void test4(){
//        Assert.assertTrue(false);

    }


    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) throws IOException {
//        PushGateway pg = new PushGateway("k8s.testing-studio.com:9091");
//        if (null != result.getThrowable()){
//            serviceStatus.set(0.0);
//        }else {
//            serviceStatus.set(1.0);
//        }
//        pg.pushAdd(registry, "my_batch_job");
    }

}
