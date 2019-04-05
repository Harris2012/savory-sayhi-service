package cn.savory.app;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class Healthy implements HealthIndicator {

    private boolean up = true;

    @Override
    public org.springframework.boot.actuate.health.Health health() {

        return new Health.Builder().status(up ? Status.UP : Status.DOWN).build();
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
