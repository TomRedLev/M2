package fr.uge.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LibraryClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        ILibrary library;
        library = (ILibrary) Naming.lookup("library");
        library.add("Philo", 1234, "Benoit");
        library.add("Maths", 1235, "Mamadou");
        library.add("Science", 1236, "Ahmed");
        library.add("Chimie", 1237, "David");
        for (var elem : library.lookT("Maths")) {
            System.out.println(elem);
        }
        library.lookT("Maths").get(0).setAuthor_name("Benoit");
        for (var elem : library.lookA("Benoit")) {
            System.out.println(elem);
        }

        library.remove(1234);
    }

}
