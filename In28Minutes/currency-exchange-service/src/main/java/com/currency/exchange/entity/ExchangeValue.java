package com.currency.exchange.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

@Entity
public class ExchangeValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(precision = 20, scale = 8)
    private BigDecimal conversionMultiple;


    private transient int port;

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public ExchangeValue(String from, String to, BigDecimal conversionMultiple) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public ExchangeValue(String from, String to, BigDecimal conversionMultiple, int port) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
    }



    /**
     * get field
     *
     * @return id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field
     *
     * @return from
     */
    public String getFrom() {
        return this.from;
    }

    /**
     * set field
     *
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * get field
     *
     * @return to
     */
    public String getTo() {
        return this.to;
    }

    /**
     * set field
     *
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * get field
     *
     * @return conversionMultiple
     */
    public BigDecimal getConversionMultiple() {
        return this.conversionMultiple;
    }

    /**
     * set field
     *
     * @param conversionMultiple
     */
    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    /**
     * get field
     *
     * @return port
     */
    public int getPort() {
        return this.port;
    }

    /**
     * set field
     *
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExchangeValue.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("from='" + from + "'")
                .add("to='" + to + "'")
                .add("conversionMultiple=" + conversionMultiple)
                .add("port=" + port)
                .toString();
    }
}
