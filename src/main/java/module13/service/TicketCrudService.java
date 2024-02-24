package module13.service;

import module13.dao.TicketDao;
import module13.model.Ticket;

public class TicketCrudService {
    private final TicketDao ticketDao = new TicketDao();

    public void saveTicket(Ticket ticket) {
        try {
            if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
                throw new IllegalArgumentException("Client, fromPlanet, and toPlanet must not be null");
            }
            ticketDao.save(ticket);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
