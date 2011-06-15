package kws.ejb.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 6/11/11
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleClient {
    public static void main(String[] args) throws NamingException {
        InitialContext jndiContext = new InitialContext();
        System.out.println("Got context");
    }
}
