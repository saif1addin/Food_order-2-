
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int orderId;
    private LocalDate orderDate;
    private String orderLocation;
    private String orderState;
    private Map<Food, Integer> items;
    private double totalPrice;
    customer customerData=new customer();
    // Method to return current date
    public static LocalDate getCurrentDate() {
        return LocalDate.now(); // Returns the current date
    }
    public Order(int orderId,String orderLocation) {
        this.orderId = orderId;
        this.orderDate = getCurrentDate();
        this.orderLocation = customerData.address;
        this.orderState = "Pending";
        this.items = new LinkedHashMap<>();
        this.totalPrice = 0.0;

    }
    public void addItem(Food food, int quantity) {
        items.put(food, items.getOrDefault(food, 0) + quantity);
        totalPrice += food.getPrice() * quantity;
    }
    public void updateItem(Food food, int newQuantity) {
        if (items.containsKey(food)) {
            int currentQuantity = items.get(food);
            totalPrice -= food.getPrice() * currentQuantity;
            items.put(food, newQuantity);
            totalPrice += food.getPrice() * newQuantity;
        } else {
            System.out.println("Item not found in order. Adding as new item.");
            addItem(food, newQuantity);
        }
    }
    public void removeItem(Food food) {
        if (items.containsKey(food)) {
            totalPrice -= food.getPrice() * items.get(food);
            items.remove(food);
            System.out.println(food.getName() + " has been removed from the order.");
        } else {
            System.out.println("Item not found in order.");
        }
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void changeState(String newState) {
        this.orderState = newState;
    }

    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order ID: ").append(orderId)
                .append("\nDate: ").append(orderDate)
                .append("\nLocation: ").append(orderLocation)
                .append("\nState: ").append(orderState)
                .append("\nTotal Price: ").append(totalPrice).append(" EGP")
                .append("\nItems:\n");

        for (Map.Entry<Food, Integer> entry : items.entrySet()) {
            Food food = entry.getKey();
            int quantity = entry.getValue();
            orderDetails.append("- ").append(food.name)
                    .append(" (").append(food.type).append(") - ")
                    .append(food.price).append(" EGP x")
                    .append(quantity).append("\n");
        }

        return orderDetails.toString();
    }
}
