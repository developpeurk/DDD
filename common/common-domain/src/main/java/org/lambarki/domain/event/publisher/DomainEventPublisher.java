package org.lambarki.domain.event.publisher;

import org.lambarki.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);

}
