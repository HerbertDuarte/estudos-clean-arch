package usecases;

import entities.Ticket;
import entities.User;
import repositories.TicketRepository;

class OpenTicket {

    private TicketRepository ticketRepository;

    OpenTicket(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    Ticket execute(String description, User requester) {
        Ticket ticket = Ticket.builder()
                .requester(requester)
                .description(description)
                .build();
        this.ticketRepository.save(ticket);
        return ticket;
    }
}