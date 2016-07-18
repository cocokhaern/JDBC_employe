import com.formation.dao.UtilisateurDaoImp;
import com.formation.presentation.IUtilisateurView;
import com.formation.presentation.UtilisateurViewImp;

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
