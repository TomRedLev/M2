package DefaultNamespace;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Client {

	public static void main(String[] args) throws ServiceException, RemoteException {
		Compte service = new CompteServiceLocator().getCompte();
		((CompteSoapBindingStub) service).setMaintainSession(true);
		service.depotDe(100);
		service.depotDe(100);
		System.out.println(service.valeurDuSolde());
	}

}
