package usecases;

import entities.Ticket;
import repositories.TicketRepository;

public class CloseTicket {

    private TicketRepository ticketRepository;

    CloseTicket(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void execute(String ticketId) {

        Ticket ticket = this.ticketRepository.get(ticketId);
        ticket.close();

        this.ticketRepository.update(ticket);
    }
}
