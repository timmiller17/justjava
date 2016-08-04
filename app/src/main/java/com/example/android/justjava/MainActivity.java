package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayMessage(createOrderSummary(calculatePrice(), hasWhippedCream, hasChocolate));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quant) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + quant);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity <= 0) {
            quantity = 0;
        } else {
            quantity--;
        }
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * Creates a summary of the order
     *
     * @param price of the total order
     */
    private String createOrderSummary(int price, boolean whippedCreamCheckBoxState,
                                        boolean chocolateCheckBoxState) {
        return  "Name: Bob Loblaw" +
                "\nAdd whipped cream? " + whippedCreamCheckBoxState +
                "\nAdd chocolate? " + chocolateCheckBoxState +
                "\nQuantity: " + quantity +
                "\nTotal: $" + price +
                "\nThank you!";
    }

    public void updateCheckBoxState(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        hasWhippedCream = whippedCreamCheckBox.isChecked();
        hasChocolate = chocolateCheckBox.isChecked();
        Log.v(this.getClass().getSimpleName(), "hasWhippedCream=" + hasWhippedCream);
    }

}