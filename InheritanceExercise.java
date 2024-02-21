interface DiscountRate {
    double getServiceMemberDiscount();
    double getProductMemberDiscount();
}

class Sale {
    Customer customer;
    String date;
    double serviceExpense;
    double productExpense;

    Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    String getDate() {
        return date;
    }

    double getServiceExpense() {
        return serviceExpense;
    }

    void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    double getProductExpense() {
        return productExpense;
    }

    void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    double getServiceDiscount() {
        return customer.getServiceMemberDiscount();
    }

    double getProductDiscount() {
        return customer.getProductMemberDiscount();
    }

    void displayInfo() {
        System.out.println("Sale Date: " + date);
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Service Discount: $" + getServiceDiscount() +
                " (" + customer.getServiceMemberDiscount() + "%)");
        System.out.println("Product Discount: $" + getProductDiscount() +
                " (" + customer.getProductMemberDiscount() + "%)");
    }
}

class Customer implements DiscountRate {
    String customerName;
    String customerType;

    Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public double getServiceMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return 20;
            case "Gold":
                return 15;
            case "Silver":
                return 10;
            default:
                return 0;
        }
    }

    public double getProductMemberDiscount() {
        switch (customerType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 10;
            default:
                return 0;
        }
    }

    String getCustomerName() {
        return customerName;
    }

    void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    String getCustomerType() {
        return customerType;
    }

    void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}

public class InheritanceExercise {
    public static void main(String[] args) {
        Customer customer = new Customer("John Doe", "Gold");
        Sale sale = new Sale(customer, "2024-02-21");

        sale.setServiceExpense(100.0);
        sale.setProductExpense(50.0);

        sale.displayInfo();
    }
}
