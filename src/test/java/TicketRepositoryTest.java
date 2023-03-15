import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticketsearchmanager.Ticket;
import ru.netology.ticketsearchmanager.repo.TicketRepository;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 110_000, "DME", "EGO", 95);
    Ticket ticket2 = new Ticket(2, 50_000, "LED", "HTA", 35);
    Ticket ticket3 = new Ticket(3, 6_000, "DME", "EGO", 195);
    Ticket ticket4 = new Ticket(4, 11_000, "KUF", "OGZ", 65);
    Ticket ticket5 = new Ticket(5, 15_000, "LED", "HTA", 45);
    Ticket ticket6 = new Ticket(6, 14_000, "LED", "HTA", 75);
    Ticket ticket7 = new Ticket(7, 19_000, "UFA", "EGO", 105);
    Ticket ticket8 = new Ticket(8, 10_499, "DME", "IKT", 50);
    Ticket ticket9 = new Ticket(9, 80_699, "SVO", "EGO", 83);
    Ticket ticket10 = new Ticket(10, 11_000, "IKT", "UFA", 160);
    Ticket ticket11 = new Ticket(11, 60_000, "LED", "HTA", 60);

    @Test
    public void shouldAddTicket() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
        repo.addTicket(ticket9);
        repo.addTicket(ticket10);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByID() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.removeById(3);

        Ticket[] expected = {ticket1, ticket2, ticket4};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }
}
