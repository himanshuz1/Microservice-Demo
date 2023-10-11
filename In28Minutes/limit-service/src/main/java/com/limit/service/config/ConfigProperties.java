package com.limit.service.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
@ConfigurationProperties("limit-service")
public class ConfigProperties {

    private int minimum;

    private int maximum;

    /**
     * get field
     *
     * @return minimum
     */
    public int getMinimum() {
        return this.minimum;
    }

    /**
     * set field
     *
     * @param minimum
     */
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    /**
     * get field
     *
     * @return maximum
     */
    public int getMaximum() {
        return this.maximum;
    }

    /**
     * set field
     *
     * @param maximum
     */
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ConfigProperties.class.getSimpleName() + "[", "]")
                .add("minimum=" + minimum)
                .add("maximum=" + maximum)
                .toString();
    }
}
