import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by pumba30 on 18.01.2015.
 */
public class PropetiesSiteDemo {
        int c;

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.growbox.com.ua/index.html");

        System.out.println("Протокол: " + url.getProtocol());
        System.out.println("Порт: " + url.getPort());
        System.out.println("Хост: " + url.getHost());
        System.out.println("Файл: " + url.getFile());
        System.out.println("Целиком: " + url.toExternalForm());

        URLConnection urlConnection = url.openConnection();

        //получить дату
        long date = urlConnection.getDate();
        if(date == 0){
            System.out.println("Нет информации о дате");
        } else {
            System.out.println("Дата " + new Date(date));
        }

        //получить тип содержимого



    }


}
