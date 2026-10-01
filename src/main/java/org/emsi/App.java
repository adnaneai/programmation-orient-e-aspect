package org.emsi;

import metier.Compte;
import metier.IMetierBanque;
import metier.MetierBanqueImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       new App().start();
    }
    public void start()
    {
        System.out.println("Demarrage de l'application.");
        Scanner scanner = ConsoleInput.scanner();
        System.out.println("Saisir le code du compte : ");
        long code = scanner.nextLong();
        System.out.println("Saisir le solde initiale du compte : ");
        double solde = scanner.nextDouble();
        IMetierBanque metierBanque = new MetierBanqueImpl();
        metierBanque.addCompte(new Compte(code,solde));
        while (true) {
            try {
                System.out.println("Type d'operations : ");
                String operations = scanner.next();
                if (operations.equals("quitter"))
                    break;
                System.out.print("Montant : ");
                double montant=scanner.nextDouble();
                if (operations.equals("v")){
                    metierBanque.verser(code,montant);
                }else if (operations.equals("r")) {
                    metierBanque.retirerCompte(code,montant);
                }
                Compte compte = metierBanque.consulter(code);
                System.out.println("Etat du compte : "+compte.toString()  );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
