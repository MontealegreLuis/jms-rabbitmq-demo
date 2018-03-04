package com.jms.rabbitmq.events;

public interface CanRecordEvents {
    void recordThat(Event event);
}
