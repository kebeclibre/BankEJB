package lu.session;

import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface BanqueRemote {
	
	public void createAccount(String numero, String nom, String prenom, double initSold, double allowedCredit);
	
	public Map<String,String> getAccountData();
	
	public void depot(double x);

	public boolean retrait(double y);

	public void changerTitulaire(String nom, String prenom);

	public String getInfo(String field);
	
	public void setAccountData(Map<String,String> map);
	
	
	
}
