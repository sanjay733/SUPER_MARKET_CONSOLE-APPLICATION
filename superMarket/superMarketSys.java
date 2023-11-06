package superMarket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


class User{
	String name;
	String email;
	String password;
	int credit;
	String role;
	List<String> purchaseHistory;
	User(String name,String email,String password,int credit,String role)
	{
		this.name=name;
		this.email=email;
		this.password=password;
		this.credit=credit;
	    this.role=role;
	    purchaseHistory=new ArrayList<>();
	}
	  public void addCredit(int amount) {
	        credit += amount;
	    }

	    public void reduceCredit(int amount) {
	        if (credit >= amount) {
	            credit -= amount;
	        } else {
	            System.out.println("Credit balance is low can't deduct.");
	        }
	    }
}
class Products{
	String name;
	String type;
	int price;
	int quantity;
	  Products(String name, String type, int price, int quantity) {
	        this.name = name;
	        this.type = type;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    public void addQuantity(int amount) {
	        quantity += amount;
	    }

	    public void subtractQuantity(int amount) {
	        if (quantity >= amount) {
	            quantity -= amount;
	        } else {
	            System.out.println("Insufficient quantity available.");
	        }
	    }
}

public class superMarketSys {

	public static void main(String args[]) {
		List<User> users=new ArrayList<>();
		List<Products> products=new ArrayList<>();
	    Map<Products,Integer> currentCart=new HashMap<>();

		users.add(new User("sanjay","20cs148@kpriet.ac.in","12345678",1000,"ADMIN"));
		users.add(new User("KPR","20cs148@kpriet.ac.in","12345678",1000,"ADMIN"));
		users.add(new User("random","20cs148@kpriet.ac.in","12345678",1000,"CUSTOMER"));
		products.add(new Products("pen","stationary",99,100));
		products.add(new Products("eraser","stationary",99,100));
		products.add(new Products("juice","food",99,100));

		 Scanner sc=new Scanner(System.in);
		   System.out.println("============== WELCOME TO SUPER MARKET ================");
		   System.out.println();
		   System.out.println("Enter your username  and  password :");
		   String userName=sc.next();
		   String userPassword=sc.next();
		   
		   boolean isAdmin=false;
		   
		   User currentUser=null;
				   
		   for(User user:users) {
			   if(user.name.equals(userName) && user.password.equals(userPassword)) {
				   currentUser=user;
			   }
		   }
		   if (currentUser != null) {
			    if (currentUser.role.equals("ADMIN")) {
			        isAdmin = true;
			    }
		   }
		   if(currentUser==null) {
			   System.out.println("INVALID USER-NAME OR PASSWORD !!!");
			   System.out.println("TRY AGAIN OR IF YOU ARE A NEW USER CONTACT THE ADMIN");
		   }
		   if(currentUser!=null) {
			   boolean actionComplete=true;
			   while(actionComplete) {
			   if(isAdmin) {
				   System.out.println("========= WELCOME ADMIN " + currentUser.name + " TO SUPER MARKET ==========");
		           System.out.println("1 - ADD A NEW ADMIN");
		           System.out.println("2 - ADD A NEW CUSTOMER");
		           System.out.println("3 - ADD A PRODUCT");
		           System.out.println("4 - SEARCH FOR A PRODUCT");
		           System.out.println("5 - MODIFY PRODUCT DETAILS");
		           System.out.println("6 - REMOVE A PRODUCT");
		           System.out.println("7 - VIEW PRODUCTS SORTED BY NAME OR TYPE");
		           System.out.println("8 - MANAGE CUSTOMER'S CREDIT SCORE");
		           System.out.println("9 - EXIT");
		           System.out.println("PLEASE ENTER THE ACTION YOU WOULD LIKE TO PERFORM: ");
		           int action = sc.nextInt();
		           
              switch(action) {
              
              case 1:{
              System.out.println("====== ENTER THE CREDENTIALS OF THE NEW ADMIN ==========");
			   System.out.print("ENTER THE NAME OF THE NEW ADMIN: ");
			   String adminName=sc.next();
			   System.out.print("ENTER THE EMAIL ID: ");
			   String adminEmail=sc.next();
			   System.out.println("ENTER THE PASSWORD: ");
			   String adminUserPassword=sc.next();
			   String role="ADMIN";
			   users.add(new User(adminName,adminEmail,adminUserPassword,1000,role));
			  System.out.println("========= NEW ADMIN "+adminName+" HAS BEEN SUCCESSULLY ADDED ==========");
			  break;
		   }
		   case 2:{
			   System.out.println("====== ENTER THE CREDENTIALS OF THE NEW CUSTOMER ==========");
			   System.out.print("ENTER THE NAME OF THE NEW CUSTOMER: ");
			   String customerName=sc.next();
			   System.out.print("ENTER THE EMAIL ID: ");
			   String customerEmail=sc.next();
			   System.out.println("ENTER THE PASSWORD: ");
			   String customerPassword=sc.next();
			   String role="CUSTOMER";
			   users.add(new User(customerName,customerEmail,customerPassword,1000,role));
			  System.out.println("========= NEW CUSTOMER "+customerName+" HAS BEEN SUCCESSULLY ADDED ==========");
			  break;
		   }
		   case 3:{
			   System.out.println("ENTER THE PRODUCT NAME ");
			   String productName=sc.next();
			   System.out.println("ENTER THE TYPE OF THE PRODUCT TO ADD");
			   String productType=sc.next();
			   System.out.println("ENTER THE PRICE OF THE PRODUCT TO ADD");
			   int price=sc.nextInt();
			   System.out.println("ENTER THE QUANTITY OF THE PRODUCT TO ADD");
			   int quantity=sc.nextInt();
			   products.add(new Products(productName,productType,price,quantity));
			   break;
		   }
		   case 4:{
			   System.out.println("1. SEARCH BY PRODUCT NAME");
			   System.out.println("2. SEARCH BY PRODUCT TYPE");
			   int choice=sc.nextInt();
			   if(choice==1) {
				   System.out.println("ENTER THE NAME OF THE PRODUCT");
				   String productName=sc.next();
				   for(Products product:products) {
					   if(product.name.equals(productName)) {
						   System.out.println("The Product Name is:"+product.name);
						   System.out.println("The Product price is:"+product.price);
						   System.out.println("The Product type is:"+product.type);
						   System.out.println("The Product Availabe Quantity is:"+product.quantity);

					   }
				   }
			   }
			   else if(choice==2) {
				   System.out.println("ENTER THE TYPE OF THE PRODUCT");
				   String productType=sc.next();
				   for(Products product:products) {
					   if(product.type.equals(productType)) {
						   System.out.println("The Product Name is:"+product.name);
						   System.out.println("The Product price is:"+product.price);
						   System.out.println("The Product type is:"+product.type);
						   System.out.println("The Product Availabe Quantity is:"+product.quantity);

					   }
			   }
		   }
			   else {
				   System.out.println("PLEASE ENTER A VALID CHOICE");
			   }
			   break;
              }
		   case 5: {
			    System.out.println("====== MODIFY PRODUCT DETAILS ========");

			    System.out.print("Enter the name of the product to modify: ");
			    String productNameToModify = sc.next();
			    Products productToModify = null;
			    for (Products product : products) {
			        if (product.name.equals(productNameToModify)) {
			            productToModify = product;
			            break;
			        }
			    }

			    if (productToModify != null) {
			        System.out.print("Enter the new price for " + productToModify.name + ": ");
			        int newPrice = sc.nextInt();
			        productToModify.price = newPrice;

			        System.out.print("Enter the new quantity for " + productToModify.name + ": ");
			        int newQuantity = sc.nextInt();
			        productToModify.quantity = newQuantity;

			        System.out.println("Product details for " + productToModify.name + " have been updated.");
			    } else {
			        System.out.println("Product not found. Please check the product name and try again.");
			    }
			    break;
		   }
		   case 6:{
			   System.out.println("ENTER THE NAME OF THE PRODUCT TO REMOVE:");
			   String removeProduct=sc.next();
			   for(Products product:products) {
				   if(product.name.equals(removeProduct)) {
					   products.remove(product);
					   System.out.println("PRODUCT SUCCESSFULLY REMOVED FROM INVENTORY");
				   }
			   }
			   break;
		   }
		   case 7:{
			   System.out.println("1. VIEW PRODUCTS SORTED BY NAME");
			   System.out.println("2. VIEW PRODUCTS SORTED BY PRODUCT");
			   int choice=sc.nextInt();
			   if(choice==1) {
				   Collections.sort(products,Comparator.comparing(a->a.name));
				   
			   }
			   else if(choice==2) {
				   Collections.sort(products,Comparator.comparing(a->a.type));
				   System.out.println(products);
			   }
			   
			   else {
				   System.out.println("Enter a valid option");
			   }
			   for (Products product : products) {
			        System.out.println("product Name: " + product.name);
			        System.out.println("product type: " + product.type);
			        System.out.println("product price: " +product.price);
			        System.out.println("----------------------------------");
			    }
			   break;
		   }
		   case 8:{
			   System.out.println("Enter the email of the customer you want to modify the credit score:");
			   String emailCheck=sc.next();
			   for(User user:users) {
				   if(user.email.equals(emailCheck)) {
					   System.out.println("Enter the credit amount you want to modify");
					   int modifyLimit = sc.nextInt();
			            user.credit += modifyLimit;
			            System.out.println("Fine limit updated successfully.");		
			            }
			   }
			   break;
		   }
		   case 9:{
			   actionComplete=false;
			   break;
		   }
		   default:{
			   System.out.println("Enter a valid option!");
		   }
		   
	}
}
			   else {
				   if (currentUser.role.equals("CUSTOMER")) {
				        System.out.println("========= WELCOME CUSTOMER " + currentUser.name + " TO SUPER MARKET ==========");
				        System.out.println("1 - VIEW PRODUCTS");
				        System.out.println("2 - ADD PRODUCTS TO CART");
				        System.out.println("3 - REMOVE PRODUCTS FROM CART");
				        System.out.println("4 - VIEW CART");
				        System.out.println("5 - PROCEED TO PAYMENT");
				        System.out.println("6 - VIEW PURCHASE HISTORY");
				        System.out.println("7 - LOGOUT");
				        System.out.println("PLEASE ENTER THE ACTION YOU WOULD LIKE TO PERFORM: ");
				        int customerAction = sc.nextInt();

				        switch (customerAction) {
				            case 1: {
				                for (Products product : products) {
				                    System.out.println("Product Name: " + product.name);
				                    System.out.println("Product Type: " + product.type);
				                    System.out.println("Product Price: " + product.price);
				                    System.out.println("Product Quantity: " + product.quantity);
				                    System.out.println("------------------------------");
				                }
				                break;
				            }
				            case 2: {
				                System.out.println("Enter the product name to add to the cart:");
				                String productToAdd = sc.next();
				                System.out.println("Enter the quantity to add:");
				                int quantityToAdd = sc.nextInt();
                                for(Products product:products) {
                                	if(product.name.equals(productToAdd)) {
                                		currentCart.put(product, product.price*quantityToAdd);
                                		System.out.println("PRODUCT SUCCESSFULLT ADDED IN THE CART !");
                                	}
                                }
				                break;
				            }
				            case 3: {
				                System.out.println("Enter the product name to remove from the cart:");
				                String productToRemove = sc.next();
                                if(currentCart.containsKey(productToRemove)) {
                                	currentCart.remove(productToRemove);
                                	System.out.println("PRODUCT SUCCESSFULLY REMOVED FROM CART");

                                }
				                break;
				            }
				            case 4: {
				                System.out.println("THE PRODUCTS IN YOUR CART ARE: ");
				                boolean isCartEmpty = true;  
				                for (Map.Entry<Products, Integer> entry : currentCart.entrySet()) {
				                    Products productInCart = entry.getKey();
				                    int quantity = entry.getValue();
				                    if (quantity > 0) { 
				                        isCartEmpty = false; 
				                        System.out.println("Product Name: " + productInCart.name);
				                        System.out.println("Quantity: " + quantity);
				                        System.out.println("Total Price: " + (productInCart.price * quantity));
				                        System.out.println("------------------------------");
				                    }
				                }

				                if (isCartEmpty) {
				                    System.out.println("CART IS EMPTY");
				                }
				                break;
				            }
				            case 5: {
				            	String productsHistory="";
				            	int totalValue=0;
				            	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				            	   LocalDateTime now = LocalDateTime.now();  
				                for(Map.Entry<Products, Integer> current:currentCart.entrySet()) {
                                totalValue+=current.getValue();
                                productsHistory+=current.getKey()+" "+current.getValue()+" "+dtf.format(now);
				                }
                                int creditRemain=currentUser.credit;
                                if(creditRemain>totalValue) {
                                	creditRemain-=totalValue;
                                	System.out.println("TOAL BILLING VALUE OF CART IS: "+totalValue);
                                }
                                else {
                                	System.out.println("INSUFFICIENT CREDIT BALANCE!");
				                }
				                break;
				            }
				            case 6: {
				            	System.out.println("THE PURCHASE HISTORY OF THE USER "+currentUser.name+" IS");
				            	for(String s:currentUser.purchaseHistory) {
				            		System.out.println(s);
				            	}
				                break;
				            }
				            case 7: {
				            	System.out.println("LOGGING OUT "+currentUser.name);
				               currentUser=null;
				               actionComplete=false;
				                break;
				            }
				            default: {
				                System.out.println("Enter a valid option!");
				            }
				        }
				    }
				   System.out.println("Do you want to perform another action? (yes/no)");
			        String continueChoice = sc.next();

			        if (!continueChoice.equalsIgnoreCase("yes")) {
			            actionComplete = false; 
			        }
				}			  
			   }
}
}
}