package com.company;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите х : ");
        int x = scanner.nextInt();
        Formula form = new Formula(x);
        form.displayFormula();
        System.out.println("Введите ключевое слово : ");
        String word = scanner.next();
        if (word.equals("save")){
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C://file14.txt"))){
                objectOutputStream.writeObject(form);
                objectOutputStream.writeInt(x);
                System.out.println("Okey");
            } catch (IIOException ex){
                System.out.println(ex.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error");
        }
        System.out.println("Введите второе ключевое слово : ");
        String word2 = scanner.next();
        if (word2.equals("upload")){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C://file14.txt"))){
                Formula formula = (Formula) objectInputStream.readObject();
                System.out.println(formula.x);
                System.out.println("Okey-2");
            } catch (IOException | ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Error-2");
        }
    }
}
class Formula implements Serializable{
    float x;
    public Formula(float x){
        this.x = x;
    }
    public void displayFormula(){
        double vector = x - (Math.sin(x));
        System.out.println(vector);
    }
}
