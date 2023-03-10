package com.cbar.orderhutbe;

import com.cbar.orderhutbe.model.*;
import com.cbar.orderhutbe.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public OrderHutBeApplication(ClientRepository clientRepository, DishRepository dishRepository, FinalOrderRepository finalOrderRepository, PlanificationRepository planificationRepository, RestaurantTableRepository restaurantTableRepository, WaiterRepository waiterRepository) {
        this.clientRepository = clientRepository;
        this.dishRepository = dishRepository;
        this.finalOrderRepository = finalOrderRepository;
        this.planificationRepository = planificationRepository;
        this.restaurantTableRepository = restaurantTableRepository;
        this.waiterRepository = waiterRepository;
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
        Dish dishPasta1 = new Dish(1, "Paste cu patru feluri de branza", 38, "PASTE - PASTA","https://dmkz2i5qfmsty.cloudfront.net/e2699f5c-40c5-4481-b1d4-e23ea04590f4.jpg", "paste proaspete unse bine de crema dens?? ??i sofisticat?? a celor patru tipuri de br??nz??, gorgonzola, mozzarella, brie ??i parmezan, din tradi??ionala buc??t??rie italian?? (300g)\n");
        Dish dishPasta2 = new Dish(2, "Pasta Bolognesi", 37, "PASTE - PASTA","https://dmkz2i5qfmsty.cloudfront.net/4591ad61-4715-4f13-a5b6-078e1157624a.jpg", "a??a cum ??i spune ??i numele, acest preparat ????i are originea ??n orasul Bologna din nordul Italiei, unde sosul de baz?? ragu, din carne de vit??, este preparat cu r??bdare ??i m??iestrie pre?? de c??teva ore (300g)\n");
        Dish dishPasta3 = new Dish(3, "Paste Carbonara", 35, "PASTE - PASTA","https://dmkz2i5qfmsty.cloudfront.net/554a9add-c665-4cc3-a429-04e6c06bccb7.jpg", "pastele carbonara specifice zonei Lazio, ??n versiune local?? g??tite cu un sos cremos de sm??nt??n??, bacon tras repede la tigaie ??i o ploaie de parmezan proasp??t ras (300g)");

        Dish dishPizza1 = new Dish(4, "Pizza Diavola", 36, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/31701ca1-9731-455d-a4e2-c3939ce9bf38.jpg", "preferat?? celor care iubesc iutele, mozzarella este ??mbr????i??at?? de salam chorizo picant, fulgi de chili, oregano irezistibil ??i sos Napoli din abunden???? (450g)");
        Dish dishPizza2 = new Dish(5, "Pizza Capriciosa", 34, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/f6d113b9-50b9-4680-838a-8c78e4c84e46.jpg", "ingrediente pe placul tuturor, la baz?? a??teapt?? pizza Margherita care ??mbr????i??eaz?? p??tima?? ??unca presat??, ciupercile proaspete, ardeiul gras ??i delicatele m??sline, alc??tuind o fuziune de arome (450g)");
        Dish dishPizza3 = new Dish(6, "Pizza Speciala", 37, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/ab5c8dfe-0917-4afa-9539-9dd0ad088f65.jpg", "cum ??i spune ??i numele, am pus laolalt?? o p??tur?? de ingrediente, mozzarella cremoas??, ciuperci proaspete champignon, f????ii de bacon, un strop de usturoi ??i un ou ochi aruncat peste, care-??i ??mbin?? perfect gustul ??i aromele ??i o fac cu adev??rat special?? (400g)");
        Dish dishPizza4 = new Dish(7, "Pizza Margherita", 27, "PIZZA", "https://dmkz2i5qfmsty.cloudfront.net/82c1b007-0b76-438c-8e9e-f904b4d0e369.jpg", "prin simplitatea ingredientelor folosite dar cu un gust complex, blatul este uns bine cu sos Napoli, apoi pres??rat cu mozzarella fin?? ??i oregano aromat (400g)");

        Dish dishSoup1 = new Dish(8, "Sup?? crem?? de legume", 19.50f, "SUPE | CIORBE", "https://dmkz2i5qfmsty.cloudfront.net/699e9a14-3b86-4eb1-8f69-7bca5e632551.jpg", "am luat ce legume proaspete ne-au picat la m??n??, le-am pus la fiert, le-am pasat vrednic ??i am ob??inut o crem?? aromat?? ??i super hidratant??, la care ad??ug??m crutoane cr??n????nitoare preg??tite de noi (350ml)");
        Dish dishSoup2 = new Dish(9, "Sup?? de pui cu t??ie??ei de cas??", 19.50f, "SUPE | CIORBE", "https://dmkz2i5qfmsty.cloudfront.net/7cd9f20f-17c2-498d-823b-d33376532880.jpg", "medicament pentru trup ??i suflet, un deliciu u??or ??i s????ios care poate fi servit ??n orice moment al zilei, o zeam?? limpede cu buc????ele de pui, t??ie??ei preg??titi ??n cas??, rondele de morcovi ??i o p??tur?? de verdea???? proasp??t tocat?? (350ml)");

        Dish dishExtra1 = new Dish(10, "Ap?? Aqua Carpatica", 14, "R??CORITOARE", "https://dmkz2i5qfmsty.cloudfront.net/398a4d38-39fa-4496-93c5-7219ef25bf6a.jpg", "Diverse sortimente(750ml)");

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
    }
}
