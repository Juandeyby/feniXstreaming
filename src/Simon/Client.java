/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simon;

/**
 *
 * @author USUARIO CESAR
 */
import de.root1.simon.Lookup;
import de.root1.simon.exceptions.EstablishConnectionFailed;
import java.io.IOException;

import de.root1.simon.Simon;
import de.root1.simon.exceptions.LookupFailedException;

public class Client {

    public static void main(String[] args) throws IOException, LookupFailedException, EstablishConnectionFailed {

        // create a callback object
        ClientCallbackImpl clientCallbackImpl = new ClientCallbackImpl();

        // 'lookup' the server object
        Lookup nameLookup = Simon.createNameLookup("192.168.0.102", 22222);
        ServerInterface server = (ServerInterface) nameLookup.lookup("Enrutador");

        // use the serverobject as it would exist on your local machine
        server.login(clientCallbackImpl);
        nameLookup.release(server);

        // do some more stuff
        // ...

        // and finally 'release' the serverobject to release to connection to the server
    }
}