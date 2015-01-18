import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by pumba30 on 18.01.2015.
 */
public class PropetiesSiteDemo {


    public static void main(String[] args) throws IOException {
        int c;

        URL url = new URL("http://shop.growboxov.net/index.php?route=common/home");

        System.out.println("Протокол: " + url.getProtocol());
        System.out.println("Порт: " + url.getPort());
        System.out.println("Хост: " + url.getHost());
        System.out.println("Файл: " + url.getFile());
        System.out.println("Целиком: " + url.toExternalForm());

        URLConnection urlConnection = url.openConnection();

        //получить дату
        long date = urlConnection.getDate();
        System.out.println("Тот самый лонг дейт =" + date);
        if (date == 0) {
            System.out.println("Нет информации о дате");
        } else {
            System.out.println("Дата " + new Date(date));
        }

        //получить тип содержимого
        System.out.println("Тип содержимого: " + urlConnection.getContentType());

        //получить дату истечения срока (устаревание)
        date = urlConnection.getExpiration();
        if (date == 0) {
            System.out.println("Нет информации о сроке действия");
        } else {
            System.out.println("Истекает: " + new Date(date));
        }

        //получить дату последней модификации
        date = urlConnection.getLastModified();
        if (date == 0) {
            System.out.println("Нет информации о дате последней модификации");
        } else {
            System.out.println("Дата последней модификации: " + new Date(date));
        }

        //получить длину содержимого
        long length = urlConnection.getContentLengthLong();
        if (length == -1) {
            System.out.println("Длина содержимого недоступна");
        } else {
            System.out.println("Длина содержимого " + length);
        }


        if (length != 0) {
            System.out.println("===== Содержимое =====");
            InputStream input = urlConnection.getInputStream();
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("Содержимое не доступно");
        }

    }


}
