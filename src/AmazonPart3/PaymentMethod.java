package AmazonPart3;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


enum PaymentMethodType {
    CASH, CREDIT_CARD, DEBIT_CARD, CHECK, BANK_ACCOUNT
}
public class PaymentMethod {
    private PaymentMethodType type;
    private String properties;
    private boolean isDefault;

    public PaymentMethod(PaymentMethodType type, String properties, boolean isDefault) {
        this.type = type;
        this.properties = properties;
        this.isDefault = isDefault;
    }

    public PaymentMethodType getType() {
        return type;
    }

    public void setType(PaymentMethodType type) {
        this.type = type;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

}

class User {
    private Integer userId;
    private String name;
    private String address;
    private String email;
    private List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();

    public User(Integer userId, String name, String address, String email) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;

    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    PaymentMethod getDefaultPaymentMethod() {
        for (PaymentMethod paymentMethod : paymentMethods) {
            if (paymentMethod.getIsDefault()) {
                return paymentMethod;
            }
        }
        return null;
    }
}

class Image {
    String imageAltText;
    String content;
}

class Product {
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    List<Image> images = new ArrayList<Image>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = (int) price;
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public List<Image> getImages() {
        return images;
    }

//    public boolean wasPurchasedByUser(Shop shop, User user) {
//        for (ShoppingCart shoppingCart : shop.getShoppingCarts()) {
//            for (Product product : shoppingCart.getProducts()) {
//                if(product.getId() == this.getId() && ShoppingCart.getUser().getUserId() == user.getUserId()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    private List<ShoppingCart> shoppingCarts;
//
//    public List<ShoppingCart> getShoppingCarts() {
//        return shoppingCarts;
//    }

//    private List<Product> products;
//    public List<Product> getProducts() {
//        return products;
//    }

}

enum ShopingCartStatus {
    OPEN, FULILLED, ABANDONED
}

class ShoppingCart {
    private User user;
    private List<Product> products;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addProduct(User user, Product product) {
        setUser(user);
        getProducts().add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}


class Shop {
    private List<ShoppingCart> shoppingCarts;

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void fulfillShoppingCart(ShoppingCart shoppingCart) {
        for (Product product : shoppingCart.getProducts()) {
            shipProductTo(shoppingCart.getUser().getAddress(), product);
        }
        shoppingCarts.add(shoppingCart);
    }

    public List<Product> pastPurchasesPerUser(User user) {
        List<Product> pastPurchases = new ArrayList<Product>();

        for (ShoppingCart shoppingCart: shoppingCarts) {
            for (Product product : shoppingCart.getProducts()) {
                pastPurchases.add(product);
            }
        }
        return pastPurchases;
    }

    private void shipProductTo(String address, Product product) {
        // this method should actually call warehouse API to ship the product to
        // given address
    }
}

class ShopppingCartTest {

    @Test
    public void Test1() {
        User user1 = new User(1, "Alices", "400 Jump Street", "alice@foo.com");
        PaymentMethod defaultMethod = user1.getDefaultPaymentMethod();
        Assert.assertTrue(defaultMethod.getIsDefault());

        //     PaymentMethod getDefaultPaymentMethod() {
        //        for (PaymentMethod paymentMethod : paymentMethods) {
        //            if (paymentMethod.getIsDefault()) {
        //                return paymentMethod;
        //            }
        //        }
        //        return null;
        //    }



        // fail Assert.asserTrue(null);
    }

    @Test
    public void Test2() {
        User user1 = new User(1, "Alices", "400 Jump Street", "alice@foo.com");
        PaymentMethod method1 = new PaymentMethod(PaymentMethodType.CREDIT_CARD, "myPersonalCard", true);
        PaymentMethod method2 = new PaymentMethod(PaymentMethodType.CREDIT_CARD, "corporateCard", false);
        user1.addPaymentMethod(method1);
        user1.addPaymentMethod(method2);
        Assert.assertSame(method1, user1.getDefaultPaymentMethod());

        // true

    }

    @Test
    public void Test3() {
        User user1 = new User(1, "Alices", "400 Jump Street", "alice@foo.com");
        User user2 = new User(2, "Bob", "1938 Leap Avenue", "bob@foo.com");
        Assert.assertEquals("Bob", user2.getName());
        Assert.assertEquals("alice@foo.com", user1.getEmail());
        // true
    }

    @Test
    public void Test4() {
        Product myProduct = new Product();
        Image thumbnail = new Image();
        myProduct.addImage(thumbnail);
        Assert.assertSame(thumbnail, myProduct.getImages().get(0));

        // true
    }

    @Test
    public void Test5() {
        Product product = new Product();
        product.setPrice(10.75);
        Assert.assertTrue(10.75 == product.getPrice());

        // false
    }
}