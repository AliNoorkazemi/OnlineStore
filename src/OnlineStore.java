import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;
import java.io.Console;

public class OnlineStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        Admin admin = new Admin();
        Producer producer;
        Backer backer;
        Client client;
        User user = new User();
        OUT:
        while (true) {
            if (input == 0) {
                user.menu();
                input = scanner.nextInt();
            }
            if (user.getClass() == new User().getClass()) {
                switch (input) {
                    case 1:
                        admin.addClient();
                        input = 0;
                        break;
                    case 2:
                        user = admin.LogIn();
                        input = 0;
                        break;
                    case 3:
                        break OUT;
                }
            } else if (user.getClass() == admin.getClass()) {
                switch (input) {
                    case 1:
                        user = new User();
                        input = 0;
                        break;
                    case 2:
                        admin.createProducer();
                        input = 0;
                        break;
                    case 3:
                        admin.createBacker();
                        input = 0;
                        break;
                    case 4:
                        admin.showProduct(admin);
                        input = 0;
                        break;
                    case 5:
                        admin.changeDiscount();
                        input=0;
                        break;
                    case 6:
                        admin.showPurchases();
                        input=0;
                        break;
                    case 7:
                        admin.showExpenses();
                        input=0;
                        break;
                    case 8:
                        admin.showIncomes();
                        input=0;
                        break;
                    case 9:
                        admin.viewRecordsVolumeOfBackers();
                        input=0;
                        break;
                    case 10:
                        admin.viewSaleListOfProducers();
                        input=0;
                        break;
                    case 11:
                        admin.viewDeliveredLoadList();
                        input=0;
                        break;
                }
            } else if (user.getClass() == new Client(0).getClass()) {
                client = (Client) user;
                switch (input) {
                    case 1:
                        user = new User();
                        input = 0;
                        break;
                    case 2:
                        client.Purchase(admin);
                        input = 0;
                        break;
                    case 3:
                        client.showExpense();
                        input=0;
                        break;
                    case 4:
                        client.viewPurchases();
                        input=0;
                        break;
                    case 5:
                        client.viewProducer(admin);
                        input=0;
                        break;
                    case 6:
                        client.viewDeliveringPurchases();
                        input=0;
                        break;
                }
            } else if (user.getClass() == new Producer().getClass()) {
                producer = (Producer) user;
                switch (input) {
                    case 1:
                        user = new User();
                        input = 0;
                        break;
                    case 2:
                        producer.addProduct(admin);
                        input = 0;
                        break;
                    case 3:
                        producer.showProducts();
                        input = 0;
                        break;
                    case 4:
                        producer.showIncome();
                        input = 0;
                        break;
                    case 5:
                        producer.removeProduct(admin);
                        input=0;
                        break;
                }
            } else if (user.getClass() == new Backer().getClass()) {
                backer =(Backer)user;
                switch (input) {
                    case 1:
                        user = new User();
                        input = 0;
                        break;
                    case 2:
                        backer.changeVehicle();
                        input=0;
                        break;
                    case 3:
                        backer.getVehicle();
                        input=0;
                        break;
                    case 4:
                        backer.addToDelivering(admin);
                        input=0;
                        break;
                    case 5:
                        backer.viewDeliveringList();
                        input=0;
                        break;
                    case 6:
                        backer.addToDelivered();
                        input=0;
                        break;
                    case 7:
                        backer.viewRecordVolume();
                        input=0;
                        break;
                    case 8:
                        backer.ViewDeliveredList();
                        input=0;
                        break;
                }
            }
        }
    }
}

class User {
    private String userName;
    private String password;
    public static Scanner input = new Scanner(System.in);

    User() {
    }

    User(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void menu() {
        System.out.print("     1.SingUp\t\t");
        System.out.print("     2.LogIn\t\t");
        System.out.println("     3.Exit\t\t");
    }

    public boolean equals(User user) {
        if (this.getUserName().equals(user.getUserName()) && this.getPassword().equals(user.getPassword()))
            return true;
        else
            return false;
    }

    public void showProduct(Admin admin) {
        System.out.println("   Choose your sightly cluster : ");
        System.out.print("    1. Foodstuff\t\t");
        System.out.print("    2. Electronic Supplies\t\t");
        System.out.println("    3. Clothes");
        switch (input.nextInt()) {
            case 1:
                showFoodstuffs(admin);
                break;
            case 2:
                showElectronicSupplies(admin);
                break;
            case 3:
                showClothes(admin);
                break;
        }
    }

    public void addToPurchaseList(Product product){}

    public void showFoodstuffs(Admin admin) {
        for (int i = 0; i < admin.foodstuffs.size(); i++) {
            System.out.println(i + 1 + " . ");
            admin.foodstuffs.get(i).show();
        }
    }

    public void showElectronicSupplies(Admin admin) {
        for (int i = 0; i < admin.electronicSupplies.size(); i++) {
            System.out.println(i + 1 + " . ");
            admin.electronicSupplies.get(i).show();
        }
    }

    public void showClothes(Admin admin) {
        for (int i = 0; i < admin.clothes.size(); i++) {
            System.out.println(i + 1 + " . ");
            admin.clothes.get(i).show();
        }
    }
}

class Admin extends User {
    public LinkedList<User> users;
    public LinkedList<Producer> producers;
    public LinkedList<Foodstuff> foodstuffs;
    public LinkedList<ElectronicSupplies> electronicSupplies;
    public LinkedList<Clothes> clothes;

    Admin() {
        System.out.println("Admin");
        System.out.println("    enter a userName");
        this.setUserName(input.next());
        System.out.println("    enter a password");
        this.setPassword(input.next());
        users = new LinkedList<User>();
        users.add(this);
        foodstuffs = new LinkedList<Foodstuff>();
        clothes = new LinkedList<Clothes>();
        electronicSupplies = new LinkedList<ElectronicSupplies>();
    }

    public void viewDeliveredLoadList(){
        for(int i = 0 ; i < users.size();i++){
            if (this.users.get(i) instanceof Backer){
                System.out.println(this.users.get(i).getUserName());
                ((Backer)this.users.get(i)).ViewDeliveredList();
            }
        }
    }

    public void viewSaleListOfProducers(){
        for(int i = 0 ; i < this.producers.size() ; i++){
            System.out.println(this.producers.get(i).getUserName());
            for(int j = 0 ; j < this.producers.get(i).saleList.size();j++){
                System.out.println("\t"+(j+1)+". ");
                this.producers.get(i).saleList.get(j).show();
                System.out.println();
            }
        }
    }

    public void viewRecordsVolumeOfBackers(){
        for(int i = 0 ; i < this.users.size() ; i++){
            if ( this.users.get(i) instanceof Backer){
                System.out.println("\t"+this.users.get(i).getUserName());
                ((Backer) this.users.get(i)).viewRecordVolume();
            }
        }
    }

    public void addToProducerList(){
        producers = new LinkedList<Producer>();
        for(int i = 0 ; i < this.users.size();i++){
            if ( this.users.get(i) instanceof Producer){
                producers.add((Producer)this.users.get(i));
            }
        }
    }

    public void showIncomes(){
        Producer producer;
        for(int i = 0 ; i < users.size();i++){
            if ( users.get(i).getClass()==new Producer().getClass()){
                System.out.println("\t"+users.get(i).getUserName());
                producer=(Producer)users.get(i);
                producer.showIncome();
                System.out.println("\n");
            }
        }
    }

    public void showExpenses(){
        Client client;
        for ( int i = 0 ; i < users.size() ; i++){
            if ( users.get(i).getClass()==new Client(0).getClass()){
                System.out.println("\t"+users.get(i).getUserName());
                client=(Client) users.get(i);
                client.showExpense();
                System.out.println("\n");
            }
        }
    }

    public void showPurchases(){
        Client client;
        for ( int i = 0 ; i < users.size() ; i++){
            if ( users.get(i).getClass()==new Client(0).getClass()){
                System.out.println("\t"+users.get(i).getUserName());
                client = (Client) users.get(i);
                client.viewPurchases();
                System.out.println("\n");
            }
        }
    }

    public void changeDiscount(){
        System.out.println("   Choose your sightly cluster : ");
        System.out.print("    1. Foodstuff\t\t");
        System.out.print("    2. Electronic Supplies\t\t");
        System.out.println("    3. Clothes");
        int number;
        switch (input.nextInt()) {
            case 1:
                showFoodstuffs(this);
                System.out.println("     enter the number of your sightly product : ");
                number = input.nextInt();
                System.out.println("     write your discount percent : ");
                this.foodstuffs.get(number-1).discountPercent=input.nextInt();
                break;
            case 2:
                showElectronicSupplies(this);
                System.out.println("     enter the number of your sightly product : ");
                number = input.nextInt();
                System.out.println("     write your discount percent : ");
                this.electronicSupplies.get(number-1).discountPercent=input.nextInt();
                break;
            case 3:
                showClothes(this);
                System.out.println("     enter the number of your sightly product : ");
                number = input.nextInt();
                System.out.println("     write your discount percent : ");
                this.clothes.get(number-1).discountPercent=input.nextInt();
                break;
        }
    }

    public void createProducer() {
        System.out.println("Producer");
        System.out.println("    enter a userName");
        String userName = input.next();
        System.out.println("    enter a password");
        String password = input.next();
        users.add(new Producer(userName, password));
    }

    public void createBacker() {
        System.out.println("Backer");
        System.out.println("    enter a userName");
        String userName = input.next();
        System.out.println("    enter a password");
        String password = input.next();
        users.add(new Backer(userName, password));
    }

    public void menu() {
        System.out.print("     1. Log Out\t\t");
        System.out.print("     2. Create Producer\t\t");
        System.out.print("     3. Create Backer\t\t");
        System.out.print("     4. View Product\t\t");
        System.out.print("     5. Change Discount\t\t");
        System.out.print("     6. View Purchase\t\t");
        System.out.print("     7. View Expenses\t\t");
        System.out.print("     8. View Incomes\t\t");
        System.out.print("     9. View Records Volume\t\t");
        System.out.print("     10. View Sale Lists\t\t");
        System.out.println("     11. View Delivered Load List");
    }

    public User LogIn() {
        String userName;
        String password;
        System.out.println("   enter your userName");
        userName = input.next();
        Console console = System.console();
        char[]passwordChar = console.readPassword("enter your password\n");
        password=new String(passwordChar);
        User user = new User(userName, password);
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i)))
                user = users.get(i);
        }
        return user;
    }

    public void addClient() {
        this.users.add(new Client());
        for ( int i = 0 ; i < users.size()-1 ; i++){
            if ( users.get(i).getUserName().equals(users.getLast().getUserName())){
                users.removeLast();
                System.out.println("     this userName has already existed ");
            }
        }
    }

}

class Producer extends User {

    public LinkedList<Product> products;
    public LinkedList<Product> saleList;
    private int income;

    Producer() {}

    Producer(String userName, String password) {
        income = 0;
        this.setPassword(password);
        this.setUserName(userName);
        products = new LinkedList<Product>();
        saleList = new LinkedList<Product>();
    }

    public void removeProduct(Admin admin){
        showProducts();
        System.out.println("    Choose a product to remove : ");
        int number = input.nextInt();
        if(products.get(number-1).cluster.equals("foodStuff")){
            Foodstuff foodstuff =  (Foodstuff)products.get(number-1);
            for ( int i = 0 ; i < admin.foodstuffs.size(); i++)
                if ( foodstuff.equals(admin.foodstuffs.get(i))){
                    admin.foodstuffs.remove(i);
                    break;
                }
        }else if ( products.get(number-1).cluster.equals("Clothes")){
            Clothes clothes = (Clothes)products.get(number-1);
            for (int i = 0 ; i < admin.clothes.size();i++)
                if ( clothes.equals(admin.clothes.get(i))){
                    admin.clothes.remove(i);
                    break;
                }
        }else if ( products.get(number-1).cluster.equals("Electronic Supplies")) {
            ElectronicSupplies electronicSupplies = (ElectronicSupplies) products.get(number-1);
            for (int i = 0; i < admin.electronicSupplies.size(); i++)
                if (electronicSupplies.equals(admin.electronicSupplies.get(i))) {
                    admin.electronicSupplies.remove(i);
                    break;
                }
        }
        products.remove(number-1);
    }

    public void menu() {
        System.out.print("     1. Log Out\t\t");
        System.out.print("     2. Add Product\t\t");
        System.out.print("     3. Show Products\t\t");
        System.out.print("     4. View Income\t\t");
        System.out.println("     5. Remove Product");
    }

    public void showIncome() {
        for (int i = 0; i < saleList.size(); i++)
            income+=(saleList.get(i).price)*(100- saleList.get(i).discountPercent)/100;
        System.out.println("     income is : " + income);
        income=0;
    }

    public void addToPurchaseList(Product product){
        this.saleList.add(product);
    }

    public void addProduct(Admin admin) {
        System.out.println("     Choose the cluster of your product");
        System.out.println("    1. Foodstuff");
        System.out.println("    2. Electronic Supplies");
        System.out.println("    3. Clothes");
        int cluster = input.nextInt();
        switch (cluster) {
            case 1:
                products.add(this.addFoodstuff());
                admin.foodstuffs.add((Foodstuff) products.getLast());
                break;
            case 2:
                products.add(this.addElectronicSupplies());
                admin.electronicSupplies.add((ElectronicSupplies) products.getLast());
                break;
            case 3:
                products.add(this.addClothes());
                admin.clothes.add((Clothes) products.getLast());
                break;
        }
    }

    private Foodstuff addFoodstuff() {
        System.out.println("     Choose the type of your foodstuff");
        System.out.println("    1. green");
        System.out.println("    2. goody");
        System.out.println("    3. dairy");
        switch (input.nextInt()) {
            case 1:
                return new Green(this.getUserName());
            case 2:
                return new Goody(this.getUserName());
            default:
                return new Dairy(this.getUserName());
        }
    }

    private Clothes addClothes() {
        System.out.println("     Choose the type of your Clothes");
        System.out.println("    1. Shirt");
        System.out.println("    2. Trousers");
        System.out.println("    3. Shoe");
        switch (input.nextInt()) {
            case 1:
                return new Shirt(this.getUserName());
            case 2:
                return new Trousers(this.getUserName());
            default:
                return new Shoe(this.getUserName());
        }
    }

    private ElectronicSupplies addElectronicSupplies() {
        System.out.println("    Choose the type of your electronic supply :");
        System.out.println("    1. Mobile");
        System.out.println("    2. TV");
        System.out.println("    3. Game Console");
        switch (input.nextInt()) {
            case 1:
                return new Mobile(this.getUserName());
            case 2:
                return new TV(this.getUserName());
            default:
                return new GameConsole(this.getUserName());
        }
    }

    public void showProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + " . ");
            products.get(i).show();
        }
    }
}

class Backer extends User {

    LinkedList<Product> loads;
    String vehicle ;
    double vehicleCapacity;

    Backer() {}

    Backer(String userName, String password) {
        this.loads =new LinkedList<Product>();
        System.out.println("    enter the default vehicle :");
        System.out.print("   1. car\t");
        System.out.print("   2. motorcycle\t");
        System.out.println("   3. pickup");
        switch (input.nextInt()){
            case 1:
                this.vehicle = "car";
                this.vehicleCapacity=2;
                break;
            case 2:
                this.vehicle = "motorcycle";
                this.vehicleCapacity=0.5;
                break;
            case 3:
                this.vehicle = "pickup";
                this.vehicleCapacity=12;
                break;
        }
        this.setPassword(password);
        this.setUserName(userName);
    }

    public void ViewDeliveredList(){
        for( int i = 0 , j = 1 ; i < this.loads.size() ;i++){
            if ( this.loads.get(i).deliverySituation==DeliverySituation.Delivered){
                System.out.println((j++)+". ");
                this.loads.get(i).show();
                System.out.println();
            }
        }
    }

    public void viewRecordVolume(){
        double volume = 0;
        for ( int i = 0 ; i < this.loads.size() ; i++)
            if (this.loads.get(i).deliverySituation==DeliverySituation.Delivered)
                volume+=this.loads.get(i).volume;
        System.out.println("    Record Volume : "+ volume);
    }

    public void addToDelivered(){
        for(int i = 0; i < this.loads.size(); i++){
            System.out.println((i+1)+". ");
            this.loads.get(i).show();
        }
        System.out.println("     Choose a product that you delivered : ");
        this.loads.get(input.nextInt()-1).deliverySituation = DeliverySituation.Delivered;
    }

    public void viewDeliveringList(){
        for(int i = 0 , j = 1; i < this.loads.size(); i++){
            if ( this.loads.get(i).deliverySituation==DeliverySituation.Delivering){
                System.out.println((j++)+". ");
                this.loads.get(i).show();
                System.out.println();
            }
        }

    }

    public void addToDelivering(Admin admin){
        LinkedList<Client>clients=new LinkedList<Client>();
        Client client;
        admin.addToProducerList();
        for(int i = 0 , j = 1 ; i < admin.users.size();i++){
            if (admin.users.get(i) instanceof Client) {
                clients.add((Client) admin.users.get(i));
                System.out.println(j+". "+admin.users.get(i).getUserName());
                j++;
            }
        }
        System.out.println("   choose a client : ");
        client = clients.get(input.nextInt()-1);
        for(int i = 0  ; i < client.purchaseList.size();i++){
            if(client.purchaseList.get(i).deliverySituation==DeliverySituation.None && client.purchaseList.get(i).volume<=this.vehicleCapacity ){
                System.out.println((i+1)+".");
                client.purchaseList.get(i).show();
            }
        }
        System.out.println("\tchoose a product to delivery : ");
        System.out.println("\tif you don't want any enter 0");
        int number = input.nextInt()-1;
        if (number >= 0){
            this.loads.add(client.purchaseList.get(number));
            client.purchaseList.get(number).deliverySituation = DeliverySituation.Delivering;
            this.loads.getLast().deliverySituation=DeliverySituation.Delivering;
        }
    }

    public void changeVehicle(){
        System.out.println("   Choose your vehicle :");
        System.out.print("   1. car\t");
        System.out.print("   2. motorcycle\t");
        System.out.println("   3. pickup");
        switch (input.nextInt()){
            case 1:
                this.vehicle = "car";
                this.vehicleCapacity=2;
                break;
            case 2:
                this.vehicle = "motorcycle";
                this.vehicleCapacity=0.5;
                break;
            case 3:
                this.vehicle = "pickup";
                this.vehicleCapacity=12;
                break;
        }
    }

    public void getVehicle() {
        System.out.println("   Your vehicle is : "+this.vehicle);
    }

    public void menu() {
        System.out.print("     1. Log Out\t\t");
        System.out.print("     2. Change Vehicle\t\t");
        System.out.print("     3. My vehicle\t\t");
        System.out.print("     4. Add To Delivering\t\t");
        System.out.print("     5. Delivering List\t\t");
        System.out.print("     6. Add To delivered\t\t");
        System.out.print("     7. View Record Volume\t\t");
        System.out.println("     8. View Delivered List");
    }

}

class Client extends User {

    public int expense;
    public LinkedList<Product> purchaseList;

    Client(int a) {
    }

    Client() {
        this.purchaseList = new LinkedList<Product>();
        this.expense = 0;
        System.out.println("Client");
        System.out.println("     enter a userName");
        this.setUserName(input.next());
        System.out.println("     enter a password");
        this.setPassword(input.next());
    }

    public void viewDeliveringPurchases(){
        for(int i = 0 , j = 1 ; i < this.purchaseList.size();i++){
            if(this.purchaseList.get(i).deliverySituation==DeliverySituation.Delivering){
                System.out.println((j++)+". ");
                this.purchaseList.get(i).show();
                System.out.println();
            }
        }
    }

    public void viewProducer(Admin admin){
        Producer producer;
        admin.addToProducerList();
        for(int i =0 ; i < admin.producers.size();i++)
            System.out.println("\t"+(i+1)+". "+admin.producers.get(i).getUserName());
        System.out.println("    Choose your favourite producer : ");
        producer=admin.producers.get(input.nextInt()-1);
        producer.showProducts();
        System.out.println("    Choose your favourite product : \n\tif you don't like to purchase any enter 0");
        int number = input.nextInt()-1;
        if ( number>=0 ) {
            this.purchaseList.add(producer.products.get(number));
            producer.saleList.add(this.purchaseList.getLast());
        }
    }

    public void viewPurchases(){
        for(int i = 0 ; i < this.purchaseList.size();i++){
            System.out.println(i + 1 + " . ");
            purchaseList.get(i).show();
        }
    }

    public void showExpense(){
        for ( int i = 0 ; i < purchaseList.size();i++)
            expense+=(purchaseList.get(i).price)*(100-purchaseList.get(i).discountPercent)/100;
        System.out.println("     expense is : " + expense);
        expense=0;
    }

    public void Purchase(Admin admin) {
        System.out.println("   Choose your sightly cluster : ");
        System.out.print("    1. Foodstuff\t\t");
        System.out.print("    2. Electronic Supplies\t\t");
        System.out.println("    3. Clothes");
        int number=-1;
        switch (input.nextInt()) {
            case 1:
                showFoodstuffs(admin);
                System.out.println("   Choose the number of your purchase :\n ");
                System.out.println("\tif you don't like to purchase any enter 0");
                number = input.nextInt();
                if (number!=0)
                    this.purchaseList.add(admin.foodstuffs.get( number- 1));
                break;
            case 2:
                showElectronicSupplies(admin);
                System.out.println("   Choose the number of your purchase :\n ");
                System.out.println("\tif you don't like to purchase any enter 0");
                number = input.nextInt();
                if (number!=0)
                    this.purchaseList.add(admin.electronicSupplies.get(number-1));
                break;
            case 3:
                showClothes(admin);
                System.out.println("   Choose the number of your purchase :\n ");
                System.out.println("\tif you don't like to purchase any enter 0");
                number = input.nextInt();
                if (number!=0)
                    this.purchaseList.add(admin.clothes.get(number-1));
                break;
        }
        if ( number!=0){
            this.purchaseList.getLast().showProducer(admin.users).addToPurchaseList(this.purchaseList.getLast());
        }
    }

    public void menu() {
        System.out.print("     1. Log Out\t\t");
        System.out.print("     2. Products\t\t");
        System.out.print("     3. View Expense\t\t");
        System.out.print("     4. View Purchases\t\t");
        System.out.print("     5. View Producers\t\t");
        System.out.println("     6. View Delivering purchases");
    }
}

class Product {
    public DeliverySituation deliverySituation;
    public int discountPercent;
    public int price;
    public String cluster;
    public String producerName;
    public double volume;
    public static Scanner input = new Scanner(System.in);

    public Product(String producerName) {
        discountPercent= 0;
        deliverySituation = DeliverySituation.None;
        this.producerName = producerName;
        System.out.println("     volume :");
        this.volume = input.nextDouble();
        System.out.println("     price : ");
        this.price = input.nextInt();
        System.out.println("     discount percent: ");
        this.discountPercent=input.nextInt();
    }

    public User showProducer(LinkedList<User> users){
        for(int i = 0 ; i < users.size();i++){
            if (this.producerName.equals(users.get(i).getUserName()))
                return users.get(i);
        }
        return new User();
    }

    public void show() {}
}

class Foodstuff extends Product {

    public String type;
    public Date expiration;

    Foodstuff(String producerName) {
        super(producerName);
        this.cluster = "Foodstuff";
        Date newDate = new Date();
        System.out.println("   How much day later that this foodstuff will is going to expire : ");
        this.expiration=new Date(newDate.getYear(),newDate.getMonth()+1,newDate.getDate()+input.nextInt());
    }

    public void show() {
        System.out.println("cluster : " + this.cluster);
        System.out.println("producer : " + this.producerName);
        System.out.println("volume : " + this.volume);
        System.out.println("type  : " + this.type);
        System.out.println("price  : " + this.price);
        System.out.println("discount Percent : "+this.discountPercent);
        System.out.println("expiration : "+"2020/"+this.expiration.getMonth()+"/"+this.expiration.getDate());
        System.out.println("\n\n");
    }
}

class Green extends Foodstuff {
    String city;

    Green(String producerName) {
        super(producerName);
        this.type = "green";
        System.out.println("     city :");
        this.city = input.next();
    }

    public void show() {
        System.out.println("cluster : " + this.cluster);
        System.out.println("producer : " + this.producerName);
        System.out.println("volume : " + this.volume);
        System.out.println("type  : " + this.type);
        System.out.println("city  : " + this.city);
        System.out.println("price  : " + this.price);
        System.out.println("discount Percent : "+this.discountPercent);
        System.out.println("expiration : "+"2020/"+this.expiration.getMonth()+"/"+this.expiration.getDate());
        System.out.println("\n\n");
    }

}

class Goody extends Foodstuff {

    Goody(String producerName) {
        super(producerName);
        this.type = "goody";
    }
}

class Dairy extends Foodstuff {

    Dairy(String producerName) {
        super(producerName);
        this.type = "dairy";
    }
}

class Clothes extends Product {

    public String type;
    public String genus;
    public String size;
    public String typeSize;

    Clothes(String producerName) {
        super(producerName);
        this.cluster = "Clothes";
        System.out.println("    Size :");
        this.size = input.next();
        System.out.println("    Genus :");
        this.genus = input.next();
        System.out.println("    Choose the type of size of your Clothes :");
        System.out.println("    1. mannish");
        System.out.println("    2. womanish");
        System.out.println("    3. childly");
        switch (input.nextInt()) {
            case 1:
                this.typeSize = "Mannish";
                break;
            case 2:
                this.typeSize = "Womanish";
                break;
            case 3:
                this.typeSize = "Childly";
        }
    }

    public void show() {
        System.out.println("cluster : " + this.cluster);
        System.out.println("producer : " + this.producerName);
        System.out.println("volume : " + this.volume);
        System.out.println("type  : " + this.type);
        System.out.println("typeSize : " + this.typeSize);
        System.out.println("genus : " + this.genus);
        System.out.println("size : " + this.size);
        System.out.println("price  : " + this.price);
        System.out.println("discount Percent : "+this.discountPercent);
        System.out.println("\n\n");
    }
}

class Shoe extends Clothes {

    Shoe(String producerName) {
        super(producerName);
        this.type = "Shoe";
    }

}

class Shirt extends Clothes {

    Shirt(String producerName) {
        super(producerName);
        this.type = "Shirt";
    }
}

class Trousers extends Clothes {

    Trousers(String producerName) {
        super(producerName);
        this.type = "Trousers";
    }
}

class ElectronicSupplies extends Product {

    public String type;
    public int productionYear;
    public int displaySize;

    ElectronicSupplies(String producerName) {
        super(producerName);
        this.cluster = "Electronic Supplies";
        System.out.println("    write the production year of your product :");
        this.productionYear = input.nextInt();
    }

    public void show() {
        System.out.println("cluster : " + this.cluster);
        System.out.println("producer : " + this.producerName);
        System.out.println("volume : " + this.volume);
        System.out.println("type : " + this.type);
        System.out.println("production year : " + this.productionYear);
        System.out.println("display Size : " + this.displaySize);
        System.out.println("price  : " + this.price);
        System.out.println("discount Percent : "+this.discountPercent);
        System.out.println("\n\n");
    }
}

class Mobile extends ElectronicSupplies {

    Mobile(String producerName) {
        super(producerName);
        this.type = "Mobile";
        System.out.println("    Enter the displaySize :");
        this.displaySize = input.nextInt();
    }
}

class TV extends ElectronicSupplies {

    public int displaySize;

    TV(String producerName) {
        super(producerName);
        this.type = "TV";
        System.out.println("    Enter the displaySize :");
        this.displaySize = input.nextInt();
    }
}

class GameConsole extends ElectronicSupplies {

    public LinkedList<String> itemsList;

    GameConsole(String producerName) {
        super(producerName);
        this.type = "Game Console";
        itemsList = new LinkedList<String>();
        System.out.println("     Write the number of items which comes whit this product :");
        int i = input.nextInt();
        System.out.println("     Write the items");
        for (int j = 0; j < i; j++)
            itemsList.add(input.next());
    }

    public void show() {
        System.out.println("cluster : " + this.cluster);
        System.out.println("producer : " + this.producerName);
        System.out.println("volume : " + this.volume);
        System.out.println("type : " + this.type);
        System.out.println("production year : " + this.productionYear);
        System.out.println("items :");
        for (int j = 0; j < this.itemsList.size(); j++)
            System.out.println("    " + (j + 1) + ". " + this.itemsList.get(j));
        System.out.println("price  : " + this.price);
        System.out.println("discount Percent : "+this.discountPercent);
        System.out.println("\n\n");
    }
}

enum DeliverySituation{
    None,Delivered,Delivering
}