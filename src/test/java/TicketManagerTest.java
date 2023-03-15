import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ticketsearchmanager.Ticket;
import ru.netology.ticketsearchmanager.TicketManager;
import ru.netology.ticketsearchmanager.repo.TicketRepository;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 110_000, "DME", "EGO", 95);
    Ticket ticket2 = new Ticket(2, 50_000, "LED", "HTA", 35);
    Ticket ticket3 = new Ticket(3, 1_000, "DME", "EGO", 195);
    Ticket ticket4 = new Ticket(4, 11_000, "KUF", "OGZ", 65);
    Ticket ticket5 = new Ticket(5, 15_000, "LED", "HTA", 45);
    Ticket ticket6 = new Ticket(6, 14_000, "LED", "HTA", 75);
    Ticket ticket7 = new Ticket(7, 19_000, "UFA", "EGO", 105);
    Ticket ticket8 = new Ticket(8, 10_499, "DME", "IKT", 50);
    Ticket ticket9 = new Ticket(9, 80_699, "SVO", "EGO", 83);
    Ticket ticket10 = new Ticket(10, 11_000, "IKT", "UFA", 160);
    Ticket ticket11 = new Ticket(11, 60_000, "LED", "HTA", 60);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
    }

    @Test
    public void shouldSearchByFromToWhenOneTicket() {
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("KUF", "OGZ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromToWhenTwoTicket() {
        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = manager.findAll("DME", "EGO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromToWhenManyTickets() {
        Ticket[] expected = {ticket6, ticket5, ticket2, ticket11};
        Ticket[] actual = manager.findAll("LED", "HTA");

        Assertions.assertArrayEquals(expected, actual);
    }
}