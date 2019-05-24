package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int vowels(String str)
    {
        char[] vowels = {'а','о','и','е','ё','э','ы','у','ю','я'};
        int count = 0;
        str = str.toLowerCase();
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            for(int j = 0; j < vowels.length; j++){
                if(ch[i] == vowels[j]){
                    count++;
                }
            }
        }
        return count;
    }
    private static int consonants(String str)
    {
        char[] consonants = {'б','в','г','д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с','т', 'ф','х','ц','ч','ш','щ'};
        int count = 0;
        str = str.toLowerCase();
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            for(int j = 0; j < consonants.length; j++){
                if(ch[i] == consonants[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Введите путь к файлу: ");
        Scanner scan = new Scanner(System.in);
        String Path = scan.nextLine();
        String s = "";
        Scanner in = new Scanner(new File(Path),"cp1251");
        while(in.hasNext())
            s += in.nextLine() + "\r\n";
        in.close();
        long Count = s.chars().filter(Character::isLetter).count();
        if(Count == 0){
            System.out.print("Файл пуст!");
            return;
        }
        System.out.print("Текст из файла: \n" + s);
        System.out.println("Всего букв в тексте: " + Count);
        System.out.println("Гласных букв: " + vowels(s));
        System.out.println("Согласных букв: " + consonants(s));
    }
}
