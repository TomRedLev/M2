/**
 * Compte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface Compte extends java.rmi.Remote {
    public void retraitDe(int montant) throws java.rmi.RemoteException;
    public int valeurDuSolde() throws java.rmi.RemoteException;
    public void depotDe(int montant) throws java.rmi.RemoteException;
}
