package display;


import javax.swing.JFrame;

import engine.Simulation;
import model.ConfigureStructure;

public class Window extends JFrame{
	/**
	 * Cette classe crée une fenêtre simple pour l'affichage du panel affichant la simulation
	 * 
	 */
	// on fait heriter notre classe de JFrame (fenetre graphique)
	// pour pouvoir eventuellement personnaliser son comportement (surcharge)
	
	public Window(ConfigureStructure structConfig, Simulation simulation){
		this.init(structConfig, simulation); // on separe le constructeur du code d’initialisation des parametres graphiques (bonne pratique)
	}
	
	private void init(ConfigureStructure structConfig, Simulation simulation){
		Panel mainPanel = new Panel(structConfig, simulation); // on instancie un nouveal objet MyPanel
		this.setContentPane(mainPanel);
		
		this.setTitle("Etat de la simulation"); // titre de la fenetre
		this.setSize(structConfig.hDisplaySize, structConfig.vDisplaySize); // taille de la fenetre. On utilise plutot setPreferredSize si le composant parent
		this.setResizable(true); //On empêche/autorise le redimensionnement
		// utilise un LayoutManager.
		this.setLocationRelativeTo(null); // positionnement centre par rapport a l’ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // comportement lors d’un clic sur la croix rouge
		this.setVisible(true); // on la rend visible
	}
	
	
}
