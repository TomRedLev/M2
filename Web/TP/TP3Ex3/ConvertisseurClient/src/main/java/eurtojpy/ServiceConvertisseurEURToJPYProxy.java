package eurtojpy;

public class ServiceConvertisseurEURToJPYProxy implements eurtojpy.ServiceConvertisseurEURToJPY {
  private String _endpoint = null;
  private eurtojpy.ServiceConvertisseurEURToJPY serviceConvertisseurEURToJPY = null;
  
  public ServiceConvertisseurEURToJPYProxy() {
    _initServiceConvertisseurEURToJPYProxy();
  }
  
  public ServiceConvertisseurEURToJPYProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceConvertisseurEURToJPYProxy();
  }
  
  private void _initServiceConvertisseurEURToJPYProxy() {
    try {
      serviceConvertisseurEURToJPY = (new eurtojpy.ServiceConvertisseurEURToJPYServiceLocator()).getServiceConvertisseurEURToJPY();
      if (serviceConvertisseurEURToJPY != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceConvertisseurEURToJPY)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceConvertisseurEURToJPY)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceConvertisseurEURToJPY != null)
      ((javax.xml.rpc.Stub)serviceConvertisseurEURToJPY)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public eurtojpy.ServiceConvertisseurEURToJPY getServiceConvertisseurEURToJPY() {
    if (serviceConvertisseurEURToJPY == null)
      _initServiceConvertisseurEURToJPYProxy();
    return serviceConvertisseurEURToJPY;
  }
  
  public double convert(double eur) throws java.rmi.RemoteException{
    if (serviceConvertisseurEURToJPY == null)
      _initServiceConvertisseurEURToJPYProxy();
    return serviceConvertisseurEURToJPY.convert(eur);
  }
  
  
}