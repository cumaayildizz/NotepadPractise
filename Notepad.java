package NotepadPractise;

import java.io.*;
import java.util.Scanner;

public class Notepad {
    Scanner scanner = new Scanner(System.in);

    public String inputText(){
        System.out.println("Lutfe notlarinizi yaziniz : ");
        String text = scanner.nextLine();
        return text;
    }

    public File fileCreation(String fileName){
        File file = new File("src/NotepadPractise/" + fileName + ".txt");

        try {
            if (file.createNewFile()){
                System.out.println(file.getName() + " was created");
            }else {
                System.out.println("The operation failed because " + file.getName() + " has already been created." );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return file;
    }

    public void deleteFile(String fileName){
        File deleteFail = new File("src/NotepadPractise/" + fileName  +".txt");
        if (deleteFail != null){
            deleteFail.delete();
        }else {
            System.out.println("bu isimde bir dosya bulunamadi");
        }

    }

    public void WriteFile(File file , String text){

        try {
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/NotepadPractise/Notepad.txt") , true)); //boyle bir kullanim da mevcut
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( file , true ));

            bufferedWriter.write("\n" + text);

            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void printFile( String showFileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/NotepadPractise/" + showFileName  +".txt")));
            System.out.println("=================================================================================================");
            int i = bufferedReader.read();
            while ( i != -1){
                System.out.print((char) i);
                i = bufferedReader.read();
            }
            System.out.println("=================================================================================================");

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public boolean run(){

        int selectCase;
        do {
            System.out.println("\n < 1 >  Mevcut bir dosyasinin uzerine yaz ");
            System.out.println(" < 2 >  Yeni bir not dosyasi olustur ");
            System.out.println(" < 3 >  Dosya sil ");
            System.out.println(" < 0 >  Cikis yap");
            System.out.print("\nSecimin : ");
            selectCase = Integer.parseInt(scanner.nextLine().trim());
        }while (!(selectCase >= 0 && selectCase < 4 ));

        if (selectCase == 1){
            System.out.println("Notepad uygulamasinda yapmak istedigin islemi sec");

            do {
                System.out.println();
                System.out.println(" < 1 > Not Ekle");
                System.out.println(" < 2 > Not Defterini goster");
                System.out.println(" < 3 > Ana Ekrana don");
                System.out.println(" < 0 > Uygulamadan cikis yap");
                System.out.print("\nSecimin : ");
                selectCase = Integer.parseInt(scanner.nextLine().trim());
            }while (!(selectCase >= 0 && selectCase < 4 ));

            switch (selectCase){
                case 0:
                    System.out.println("Uygulamadan cikis yapildi. \nIyi gunler");
                    return false;
                case 1:
                    System.out.println("\nMevcut Notepad dosyasinin uzerine yazmak istersen dosya adina Notepad yaz. " +
                            "\n Olusturdugn baska bir dosya uzerine yazmak istersen de uzerine yazmak istedigin dosya adini yaz!!");
                    System.out.println("\nLutfen uzerine yazmak istedigin dosya adini gir : ");
                    String writeFile = scanner.nextLine();
                    WriteFile( fileCreation(writeFile) , inputText());
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Gostermek istedigin dosyanin adini yaz : ");
                    String showFile = scanner.nextLine();
                    printFile(showFile);
                    run();
                case 3:
                    run();
                default: return false;
            }

        }else if (selectCase == 2){
            System.out.print("Olusturmak istedigin dosyanin adini giriniz : " );
            String newFileName = scanner.nextLine();
            fileCreation(newFileName);
            run();
        } else if (selectCase == 3) {
            System.out.print("\nSilmek istedigin dosyanin ismini gir : ");
            String deleteFileName = scanner.nextLine();
            deleteFile(deleteFileName);
            run();
        } else {
            System.out.println("Uygulamadan cikis yapildi. \nIyi gunler");
            return false;
        }

       return true;
    }



}
