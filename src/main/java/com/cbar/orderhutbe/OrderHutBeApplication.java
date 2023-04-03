package com.cbar.orderhutbe;

import com.cbar.orderhutbe.model.*;
import com.cbar.orderhutbe.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class OrderHutBeApplication implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final DishRepository dishRepository;
    private final FinalOrderRepository finalOrderRepository;
    private final PlanificationRepository planificationRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final WaiterRepository waiterRepository;
    private final UserRepository userRepository;

    public OrderHutBeApplication(ClientRepository clientRepository, DishRepository dishRepository, FinalOrderRepository finalOrderRepository, PlanificationRepository planificationRepository, RestaurantTableRepository restaurantTableRepository, WaiterRepository waiterRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.dishRepository = dishRepository;
        this.finalOrderRepository = finalOrderRepository;
        this.planificationRepository = planificationRepository;
        this.restaurantTableRepository = restaurantTableRepository;
        this.waiterRepository = waiterRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderHutBeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Adds clients
        Client client1 = new Client(1, "Claudia Frost");
        Client client2 = new Client(2, "Fletcher Beard");
        Client client3 = new Client(3, "Fulton Gonzalez");
        Client client4 = new Client(4, "Astra Bray");
        Client client5 = new Client(5, "Tanya Blake");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);
        clientRepository.save(client5);

        //Adds tables
        RestaurantTable table1 = new RestaurantTable(1, 1, 4);
        RestaurantTable table2 = new RestaurantTable(2, 1, 2);

        restaurantTableRepository.save(table1);
        restaurantTableRepository.save(table2);

        //Adds waiters
        Waiter waiter1 = new Waiter(1, "Barrett Coleman");
        Waiter waiter2 = new Waiter(2, "Shana Sharp");

        waiterRepository.save(waiter1);
        waiterRepository.save(waiter2);

        //Adds planifications
        Planification planification1 = new Planification(1, waiter1, table1);
        Planification planification2 = new Planification(2, waiter2, table2);

        planificationRepository.save(planification1);
        planificationRepository.save(planification2);

        //Adds dishes
        Dish dishPasta1 = new Dish(1, "Paste cu patru feluri de branza", 38, "PASTE - PASTA","https://dmkz2i5qfmsty.cloudfront.net/e2699f5c-40c5-4481-b1d4-e23ea04590f4.jpg", "paste proaspete unse bine de crema densă și sofisticată a celor patru tipuri de brânză, gorgonzola, mozzarella, brie și parmezan, din tradiționala bucătărie italiană (300g)\n");
        Dish dishPasta2 = new Dish(2, "Pasta Bolognesi", 37, "PASTE - PASTA","https://dmkz2i5qfmsty.cloudfront.net/4591ad61-4715-4f13-a5b6-078e1157624a.jpg", "așa cum îi spune și numele, acest preparat își are originea în orasul Bologna din nordul Italiei, unde sosul de bază ragu, din carne de vită, este preparat cu răbdare și măiestrie preț de câteva ore (300g)\n");
        Dish dishPasta3 = new Dish(3, "Paste Carbonara", 35, "PASTE - PASTA","https://dmkz2i5qfmsty.cloudfront.net/554a9add-c665-4cc3-a429-04e6c06bccb7.jpg", "pastele carbonara specifice zonei Lazio, în versiune locală gătite cu un sos cremos de smântână, bacon tras repede la tigaie și o ploaie de parmezan proaspăt ras (300g)");

        Dish dishPizza1 = new Dish(4, "Pizza Diavola", 36, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/31701ca1-9731-455d-a4e2-c3939ce9bf38.jpg", "preferată celor care iubesc iutele, mozzarella este îmbrățișată de salam chorizo picant, fulgi de chili, oregano irezistibil și sos Napoli din abundență (450g)");
        Dish dishPizza2 = new Dish(5, "Pizza Capriciosa", 34, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/f6d113b9-50b9-4680-838a-8c78e4c84e46.jpg", "ingrediente pe placul tuturor, la bază așteaptă pizza Margherita care îmbrățișează pătimaș șunca presată, ciupercile proaspete, ardeiul gras și delicatele măsline, alcătuind o fuziune de arome (450g)");
        Dish dishPizza3 = new Dish(6, "Pizza Speciala", 37, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/ab5c8dfe-0917-4afa-9539-9dd0ad088f65.jpg", "cum îi spune și numele, am pus laolaltă o pătură de ingrediente, mozzarella cremoasă, ciuperci proaspete champignon, fâșii de bacon, un strop de usturoi și un ou ochi aruncat peste, care-și îmbină perfect gustul și aromele și o fac cu adevărat specială (400g)");
        Dish dishPizza4 = new Dish(7, "Pizza Margherita", 27, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/82c1b007-0b76-438c-8e9e-f904b4d0e369.jpg", "prin simplitatea ingredientelor folosite dar cu un gust complex, blatul este uns bine cu sos Napoli, apoi presărat cu mozzarella fină și oregano aromat (400g)");

        Dish dishSoup1 = new Dish(8, "Supă cremă de legume", 19.50f, "SUPE | CIORBE", "https://dmkz2i5qfmsty.cloudfront.net/699e9a14-3b86-4eb1-8f69-7bca5e632551.jpg", "am luat ce legume proaspete ne-au picat la mână, le-am pus la fiert, le-am pasat vrednic și am obținut o cremă aromată și super hidratantă, la care adăugăm crutoane crănțănitoare pregătite de noi (350ml)");
        Dish dishSoup2 = new Dish(9, "Supă de pui cu tăieței de casă", 19.50f, "SUPE | CIORBE", "https://dmkz2i5qfmsty.cloudfront.net/7cd9f20f-17c2-498d-823b-d33376532880.jpg", "medicament pentru trup și suflet, un deliciu ușor și sățios care poate fi servit în orice moment al zilei, o zeamă limpede cu bucățele de pui, tăieței pregătiti în casă, rondele de morcovi și o pătură de verdeață proaspăt tocată (350ml)");

        Dish dishExtra1 = new Dish(10, "Apă Aqua Carpatica", 14, "RĂCORITOARE", "https://dmkz2i5qfmsty.cloudfront.net/398a4d38-39fa-4496-93c5-7219ef25bf6a.jpg", "Diverse sortimente(750ml)");

        dishRepository.save(dishPasta1);
        dishRepository.save(dishPasta2);
        dishRepository.save(dishPasta3);
        dishRepository.save(dishPizza1);
        dishRepository.save(dishPizza2);
        dishRepository.save(dishPizza3);
        dishRepository.save(dishPizza4);
        dishRepository.save(dishSoup1);
        dishRepository.save(dishSoup2);
        dishRepository.save(dishExtra1);

        //Adds orders
        FinalOrder order1 = new FinalOrder(1, new Date(), OrderStatus.WAITING, "", client1, planification1, Arrays.asList(dishPasta1, dishPizza1, dishPizza2, dishSoup1, dishExtra1));
        FinalOrder order2 = new FinalOrder(2, new Date(), OrderStatus.WAITING, "", client4, planification2, Arrays.asList(dishPasta1, dishPasta2, dishPasta3, dishPizza1, dishPizza4, dishSoup2));

        finalOrderRepository.save(order1);
        finalOrderRepository.save(order2);

        //Adds users
//        userRepository.save(new User(1, "admin", new BCryptPasswordEncoder().encode("admin"), "admin"));
//        userRepository.save(new User(2, "waiter", new BCryptPasswordEncoder().encode("waiter"), "waiter"));
    }
}
