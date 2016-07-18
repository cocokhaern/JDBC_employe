import com.formation.presentation.IUtilisateurView;
import com.formation.presentation.UtilisateurViewImp;

import dao.UtilisateurDaoImp;

public class TestMain {

	public static void main(String[] args) {
		
		IUtilisateurView view = new UtilisateurViewImp(new UtilisateurDaoImp());
		
		view.retrieveAllUtilisateurView();
		view.createUtilisateurView();
		view.updateUtilisateurView();
		view.retrieveUtilisateurAvecIdView();
		view.deleteUtilisateurAvecIdView();
		view.retrieveAllUtilisateurView();
	}

}
