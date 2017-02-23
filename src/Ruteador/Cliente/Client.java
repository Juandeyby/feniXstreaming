package Ruteador.Cliente;

import Ruteador.Servidor.TestRemote;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import de.root1.simon.exceptions.LookupFailedException;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, LookupFailedException, EstablishConnectionFailed  {
       Lookup nameLookup = Simon.createNameLookup("190.168.0.102", 22222);
        TestRemote testRemote = (TestRemote) nameLookup.lookup("Enrutador");
        nameLookup.release(testRemote);

    }
}