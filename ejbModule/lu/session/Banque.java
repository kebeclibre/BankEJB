package lu.session;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.security.auth.login.AccountNotFoundException;

/**
 * Session Bean implementation class Banque
 */
@Stateful
@LocalBean
public class Banque implements BanqueRemote {
	
	private Map<String,String> accountData;
	
    public Banque() {
    }


	@Override
	public void depot(double x) {
		Double solde = Double.parseDouble(accountData.get("balance"));
		String newBalance = solde+x+"";
		accountData.replace("balance", newBalance);
		
	}


	@Override
	public boolean retrait(double y) {
		Double credit = Double.parseDouble(accountData.get("allowedCredit"));
		Double solde = Double.parseDouble(accountData.get("balance"));
		
		if (solde-y >= -credit) {
			String newBalance = solde-y+"";
			accountData.replace("balance", newBalance);
			return true;
		} else { return false;}
		
		
	}


	@Override
	public void changerTitulaire(String nom, String prenom) {
		accountData.replace("nom", nom);
		accountData.replace("prenom", prenom);
		
	}


	@Override
	public void createAccount(String numero, String nom, String prenom, double initSold, double allowedCredit) {
		accountData = new HashMap<String,String>();
		String solde = initSold+"";
		String credit = allowedCredit+"";
		
		accountData.put("numero", numero);
		accountData.put("nom", nom);
		accountData.put("prenom", prenom);
		accountData.put("balance", solde);
		accountData.put("allowedCredit", credit);
		
	}


	@Override
	public Map<String, String> getAccountData() {
		return accountData;
	}


	@Override
	public String getInfo(String field) {
		return accountData.get(field);
		
	}


	@Override
	public void setAccountData(Map<String, String> map) {
		accountData = map;
		
	}
	
	

}
