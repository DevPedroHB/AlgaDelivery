package dev.pedrohb.algadelivery.delivery.tracking.infrastructure.event;

public interface IntegrationEventPublisher {
  public void publish(Object event, String key, String topic);
}
