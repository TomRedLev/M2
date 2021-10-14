package DefaultNamespace;

public class CompteProxy implements DefaultNamespace.Compte {
  private String _endpoint = null;
  private DefaultNamespace.Compte compte = null;
  
  public CompteProxy() {
    _initCompteProxy();
  }
  
  public CompteProxy(String endpoint) {
    _endpoint = endpoint;
    _initCompteProxy();
  }
  
  private void _initCompteProxy() {
    try {
      compte = (new DefaultNamespace.CompteServiceLocator()).getCompte();
      if (compte != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)compte)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)compte)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (compte != null)
      ((javax.xml.rpc.Stub)compte)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Compte getCompte() {
    if (compte == null)
      _initCompteProxy();
    return compte;
  }
  
  public void retraitDe(int montant) throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    compte.retraitDe(montant);
  }
  
  public int valeurDuSolde() throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    return compte.valeurDuSolde();
  }
  
  public void depotDe(int montant) throws java.rmi.RemoteException{
    if (compte == null)
      _initCompteProxy();
    compte.depotDe(montant);
  }
  
  
}