package СТР118_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostalAddress {
    private String street;
    private String city;
    private String postalCode;

    public PostalAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Postal Address");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel streetLabel = new JLabel("Street:");
        JTextField streetField = new JTextField();
        panel.add(streetLabel);
        panel.add(streetField);

        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField();
        panel.add(cityLabel);
        panel.add(cityField);

        JLabel postalCodeLabel = new JLabel("Postal Code:");
        JTextField postalCodeField = new JTextField();
        panel.add(postalCodeLabel);
        panel.add(postalCodeField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String street = streetField.getText();
                String city = cityField.getText();
                String postalCode = postalCodeField.getText();

                PostalAddress address = new PostalAddress(street, city, postalCode);
                System.out.println("Postal Address Saved: " + address.getStreet() + ", " + address.getCity() + ", " + address.getPostalCode());
            }
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
