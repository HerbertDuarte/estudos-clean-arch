package repositories;

import entities.Ticket;

public interface TicketRepository {
    Ticket get(String ticketId);

    void update(Ticket ticket);

    void save(Ticket ticket);

}
