package metier;

public interface IMetierBanque {
    void addCompte(Compte compte);
    void verser(Long code,double solde);
    void retirerCompte(Long code,double solde);
    Compte consulter(Long code);
}
