package adressen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdressenDAO {
    private Adres[] adressen;
    public AdressenDAO(String path){
        try {
            List<String> list1 = new ArrayList<>();
            String[] list2;
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                list1.add(scanner.nextLine());
            }
            // for (String string : list1) {
            //     System.out.println(string);
            // }
            adressen = new Adres[list1.size()];

            for (int i = 0; i < adressen.length; i++) {
                list2 = list1.get(i).split(";");
                switch (list2.length) {
                    case 4:
                        adressen[i] = new Adres(Integer.parseInt(list2[0]),list2[1],list2[2],Integer.parseInt(list2[3]));
                        break;

                    case 5:
                        adressen[i] = new Adres(Integer.parseInt(list2[0]),list2[1],list2[2],Integer.parseInt(list2[3]),list2[4]);
                        break;
                    default:
                        break;
                }
                
            }
            scanner.close();
            // for (Adres adres : adressen) {
            //     System.out.println(adres);
            // }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
    }
    public Adres[] getAdressenMetStraat(String straat){
        List<Adres> tempList = new ArrayList<>();
        Adres[] returnAdres;
        for (Adres adres : adressen) {
            if (straat.equals(adres.getStraat())){
                tempList.add(adres);
            }
        }
        returnAdres = new Adres[tempList.size()];
        for (int i = 0; i < returnAdres.length; i++) {
            returnAdres[i] = tempList.get(i);
        }
        return returnAdres;
    }
}
