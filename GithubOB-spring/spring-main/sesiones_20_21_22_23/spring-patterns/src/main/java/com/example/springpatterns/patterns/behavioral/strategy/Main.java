package com.example.springpatterns.patterns.behavioral.strategy;

public class Main {

	
	public static void main(String[] args) {
        //Preparar los datos
        ShopCart cart = new ShopCart();

        Product product1 = new Product("1422342342DSFDSF", 9.99);
        Product product2 = new Product("1422342342DSFDSF", 99.99);

        cart.addProduct(product1);
        cart.addProduct(product2);

        //Según el método de pago que seleccione el cliente, ejecutaríamos ua línea u otra:
        //PayPal
        cart.pay(new PayPalStrategy("","",""));
        //Tarjeta de crédito
        cart.pay(new CreditCardStrategy("","","", ""));
	}
}
