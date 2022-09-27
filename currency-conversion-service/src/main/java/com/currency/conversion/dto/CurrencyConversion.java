package com.currency.conversion.dto;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class CurrencyConversion {

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionMultiple;

    private BigDecimal quantity;

    private BigDecimal calculatedAmount;

    private int port;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal calculatedAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.calculatedAmount = calculatedAmount;
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
     * @return quantity
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    /**
     * set field
     *
     * @param quantity
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * get field
     *
     * @return calculatedAmount
     */
    public BigDecimal getCalculatedAmount() {
        return this.calculatedAmount;
    }

    /**
     * set field
     *
     * @param calculatedAmount
     */
    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
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
        return new StringJoiner(", ", CurrencyConversion.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("from='" + from + "'")
                .add("to='" + to + "'")
                .add("conversionMultiple=" + conversionMultiple)
                .add("quantity=" + quantity)
                .add("calculatedAmount=" + calculatedAmount)
                .add("port=" + port)
                .toString();
    }
}
