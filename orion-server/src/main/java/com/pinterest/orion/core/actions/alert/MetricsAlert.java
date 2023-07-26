package com.pinterest.orion.core.actions.alert;

import com.pinterest.orion.server.OrionServer;
import io.dropwizard.metrics5.Gauge;
import io.dropwizard.metrics5.MetricName;

import java.util.logging.Logger;

public class MetricsAlert extends Alert {

    private Logger logger = Logger.getLogger(MetricsAlert.class.getCanonicalName());

    @Override
    public String getName() {
        return "Metrics Alert";
    }

    @Override
    public void alert(AlertMessage message) {
        OrionServer.METRICS.register(
                MetricName.build("MetricsAlert"),
                (Gauge<Integer>) () -> 1
        );
        // TODO: Add tags from message
        logger.info("[Alert_Test] Title: " + message.getTitle());
        logger.info("[Alert_Test] Body: " + message.getBody());
    }
}
