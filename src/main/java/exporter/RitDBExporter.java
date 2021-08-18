package exporter;

import io.prometheus.client.Collector;
import io.prometheus.client.Counter;
import io.prometheus.client.GaugeMetricFamily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sungaofei on 20/2/13.
 */
public class RitDBExporter extends Collector{

    static final Counter requests = Counter.build()
            .name("my_library_requests_total_rtidb").help("Total requests.")
            .labelNames("method").register();

    void processGetRequest() {
        requests.labels("get").inc();
        // Your code here.
    }

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();

        // With no labels.
        mfs.add(new GaugeMetricFamily("my_gauge_2", "help", 42));

        // With labels
        GaugeMetricFamily labeledGauge = new GaugeMetricFamily("my_other_gauge", "help", Arrays.asList("labelname", "newlaobel"));
        labeledGauge.addMetric(Arrays.asList("foo", ""), 4);
        labeledGauge.addMetric(Arrays.asList("bar", ""), 5);
        mfs.add(labeledGauge);

        return mfs;
    }
}
