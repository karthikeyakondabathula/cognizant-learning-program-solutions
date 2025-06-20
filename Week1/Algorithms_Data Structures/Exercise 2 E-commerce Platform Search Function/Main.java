import java.util.*;

public class Main {

public static void main(String[] args) {

Product[] products = new Product[5];
products[0] = new Product(101, "Shirt", "Clothing");
products[1] = new Product(205, "Laptop", "Electronics");
products[2] = new Product(309, "Mug", "Kitchen");
products[3] = new Product(123, "Shoes", "Footwear");
products[4] = new Product(150, "Phone", "Electronics");


System.out.println("Linear search:");
long start1 = System.nanoTime();
Product p1 = linearSearch(products, "Mug");
long end1 = System.nanoTime();
if (p1 != null) System.out.println(p1.productName + " found");
else System.out.println("not found");
System.out.println("Time: " + (end1 - start1) + " ns");


System.out.println("Binary search:");
Arrays.sort(products, Comparator.comparing(a -> a.productName));
long start2 = System.nanoTime();
Product p2 = binarySearch(products, "Mug");
long end2 = System.nanoTime();
if (p2 != null) System.out.println(p2.productName + " found");
else System.out.println("not found");
System.out.println("Time: " + (end2 - start2) + " ns");

}


static Product linearSearch(Product[] arr, String name){
for (int i=0;i<arr.length;i++){
if (arr[i].productName.equals(name)){
return arr[i];
}
}
return null;
}

static Product binarySearch(Product[] arr, String name){
int l=0, r=arr.length-1;
while (l<=r){
int m=(l+r)/2;
int cmp = arr[m].productName.compareTo(name);
if (cmp==0) return arr[m];
if (cmp<0) l=m+1;
else r=m-1;
}
return null;
}
}

class Product {
int productId;
String productName;
String category;

Product(int id, String name, String cat){
productId=id;
productName=name;
category=cat;
}
}
