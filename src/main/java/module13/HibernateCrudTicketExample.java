package module13;

import module13.db.Migration;
import module13.model.Client;
import module13.model.Ticket;
import module13.model.Planet;
import module13.service.ClientCrudService;
import module13.service.PlanetCrudService;
import module13.service.TicketCrudService;
import module13.service.hibernate.HibernateUtil;

public class HibernateCrudTicketExample {
    public static void main(String[] args) {

        new Migration();
        Long idClientOne = 9L;
        Long idClientTwo = 7L;
        String idPlanetFromClientOne = "MARS";
        String idPlanetToClientOne = "JUP";
        String idPlanetFromClientTwo = "EAR";
        String idPlanetToClientTwo = "VEN";

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

        Client client = clientCrudService.findClientById(idClientOne);
        Planet planetFrom = planetCrudService.findPlanetById(idPlanetFromClientOne);
        Planet planetTo = planetCrudService.findPlanetById(idPlanetToClientOne);
        Ticket ticket = new Ticket(client,planetFrom,planetTo);
        ticketCrudService.saveTicket(ticket);
        Long idTicketForDelete = ticket.getId();

        client = clientCrudService.findClientById(idClientTwo);
        planetFrom = planetCrudService.findPlanetById(idPlanetFromClientTwo);
        planetTo = planetCrudService.findPlanetById(idPlanetToClientTwo);
        ticket = new Ticket(client,planetFrom,planetTo);
        ticketCrudService.saveTicket(ticket);

        Ticket foundTicket = ticketCrudService.findTicketById(idTicketForDelete);
        ticketCrudService.deleteTicket(foundTicket);

        client = null;
        planetFrom = planetCrudService.findPlanetById(idPlanetFromClientOne);
        planetTo = planetCrudService.findPlanetById(idPlanetToClientOne);
        ticket = new Ticket(client,planetFrom,planetTo);
        ticketCrudService.saveTicket(ticket);

        client = clientCrudService.findClientById(idClientOne);
        planetFrom = null;
        planetTo = planetCrudService.findPlanetById(idPlanetToClientOne);
        ticket = new Ticket(client,planetFrom,planetTo);
        ticketCrudService.saveTicket(ticket);

        client = clientCrudService.findClientById(idClientOne);
        planetFrom = planetCrudService.findPlanetById(idPlanetFromClientOne);
        planetTo = null;
        ticket = new Ticket(client,planetFrom,planetTo);
        ticketCrudService.saveTicket(ticket);

        Long idClientNone = 20L;
        String idPlanetFromClientNone = "SUN";
        String idPlanetToClientNone = "MOON";
        client = clientCrudService.findClientById(idClientNone);
        planetFrom = planetCrudService.findPlanetById(idPlanetFromClientNone);
        planetTo = planetCrudService.findPlanetById(idPlanetToClientNone);
        ticket = new Ticket(client,planetFrom,planetTo);
        ticketCrudService.saveTicket(ticket);

        HibernateUtil.getInstance().close();
    }
}
