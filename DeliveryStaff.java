import java.util.ArrayList;

public class DeliveryStaff {
    private String firstName;
    private String lastName;
    private String location; // The place where the delivery person works
    private double averageReview; // Average review score
    private ArrayList<Order> assignedOrders; // List of orders assigned to the delivery staff here we must update it

    // constructor
    public DeliveryStaff(String firstName, String lastName, String location, double averageReview) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.averageReview = averageReview;
        this.assignedOrders = new ArrayList<>();
    }

    // assign orders to this delivery staff if their location matches
    public void assignOrdersByLocation(ArrayList<Order> orders) {
        for (Order order : orders) {
            if (order.getOrderLocation().equalsIgnoreCase(this.location)) {
                this.assignedOrders.add(order);
            }
        }
    }

    // view all assigned orders
    public void viewAssignedOrders() {
        System.out.println("Assigned Orders for " + firstName + " " + lastName + ":");
        if (assignedOrders.isEmpty()) {
            System.out.println("No orders assigned.");
        } else {
            for (Order order : assignedOrders) {
                System.out.println(order);
                System.out.println("*================================*");
            }
        }
    }

    @Override
    public String toString() {
        return "DeliveryStaff{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", averageReview=" + averageReview +
                '}';
    }
}
