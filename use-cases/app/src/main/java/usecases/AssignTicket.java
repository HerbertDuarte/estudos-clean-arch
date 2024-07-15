package usecases;

import entities.Ticket;
import entities.User;
import repositories.TicketRepository;
import repositories.UserRepository;

public class AssignTicket {

    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    AssignTicket(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public void execute(String ticketId, String assigneeId) {
        Ticket ticket = this.ticketRepository.get(ticketId);
        User assignee = this.userRepository.get(assigneeId);
        ticket.assignUser(assignee);
        this.ticketRepository.update(ticket);
    }
}
