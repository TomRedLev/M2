/**
 * ServiceConvertisseurEURToJPYServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eurtojpy;

public class ServiceConvertisseurEURToJPYServiceLocator extends org.apache.axis.client.Service implements eurtojpy.ServiceConvertisseurEURToJPYService {

    public ServiceConvertisseurEURToJPYServiceLocator() {
    }


    public ServiceConvertisseurEURToJPYServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceConvertisseurEURToJPYServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceConvertisseurEURToJPY
    private java.lang.String ServiceConvertisseurEURToJPY_address = "http://localhost:8081/Convertisseur/services/ServiceConvertisseurEURToJPY";

    public java.lang.String getServiceConvertisseurEURToJPYAddress() {
        return ServiceConvertisseurEURToJPY_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceConvertisseurEURToJPYWSDDServiceName = "ServiceConvertisseurEURToJPY";

    public java.lang.String getServiceConvertisseurEURToJPYWSDDServiceName() {
        return ServiceConvertisseurEURToJPYWSDDServiceName;
    }

    public void setServiceConvertisseurEURToJPYWSDDServiceName(java.lang.String name) {
        ServiceConvertisseurEURToJPYWSDDServiceName = name;
    }

    public eurtojpy.ServiceConvertisseurEURToJPY getServiceConvertisseurEURToJPY() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceConvertisseurEURToJPY_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceConvertisseurEURToJPY(endpoint);
    }

    public eurtojpy.ServiceConvertisseurEURToJPY getServiceConvertisseurEURToJPY(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            eurtojpy.ServiceConvertisseurEURToJPYSoapBindingStub _stub = new eurtojpy.ServiceConvertisseurEURToJPYSoapBindingStub(portAddress, this);
            _stub.setPortName(getServiceConvertisseurEURToJPYWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceConvertisseurEURToJPYEndpointAddress(java.lang.String address) {
        ServiceConvertisseurEURToJPY_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (eurtojpy.ServiceConvertisseurEURToJPY.class.isAssignableFrom(serviceEndpointInterface)) {
                eurtojpy.ServiceConvertisseurEURToJPYSoapBindingStub _stub = new eurtojpy.ServiceConvertisseurEURToJPYSoapBindingStub(new java.net.URL(ServiceConvertisseurEURToJPY_address), this);
                _stub.setPortName(getServiceConvertisseurEURToJPYWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServiceConvertisseurEURToJPY".equals(inputPortName)) {
            return getServiceConvertisseurEURToJPY();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://eurtojpy", "ServiceConvertisseurEURToJPYService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://eurtojpy", "ServiceConvertisseurEURToJPY"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceConvertisseurEURToJPY".equals(portName)) {
            setServiceConvertisseurEURToJPYEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
