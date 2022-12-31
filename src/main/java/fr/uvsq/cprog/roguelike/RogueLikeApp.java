package fr.uvsq.cprog.roguelike;

/**
 * Cette classe est le programme principal du projet.
 *
 * Elle est une implémentation du <em>design pattern</em>
 * <a href="https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception)">Singleton</a>.
 *
 * @author Stéphane Lopes
 * @version fév. 2018
 */
public enum RogueLikeApp {
    ROGUE_LIKE_APP;

    /**
     * Cette méthode est destinée à initialiser et lancer l'exécution du programme.
     *
     * @param args les paramètres de la ligne de commande du shell
     */
    public void run(String[] args) {
        RogueLike rogueLike = new RogueLike() ;
        rogueLike.run() ;
    }

    /**
     * La méthode de classe <em>main</em> se contente de déléguer le lancement du programme à la méthode <em>run</em>.
     *
     * @param args les paramètres de la ligne de commande du shell
     */
    public static void main(String[] args) {
        ROGUE_LIKE_APP.run(args);
    }
}
