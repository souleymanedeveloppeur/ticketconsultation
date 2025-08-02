package com.medical.constantes;

public final class TicketConstant {
    // Empêche l’instanciation
    private TicketConstant() {
        throw new UnsupportedOperationException("Classe utilitaire - ne doit pas être instanciée");
    }

    // Constantes SEXE
    public static final int HOMME = 1;
    public static final int FEMME = 0;

    // Constantes liées AU  category
    public static final int ADULTE = 1;
    public static final int ENFANT = 2;

//  Constantes liées AU  status ticket
    public static final int SOUMISE = 1;
    public static final int EN_COURS = 2;
    public static final int EN_ATTENTE = 3;
    public static final int ANNULER = 4;
    public static final int CONSULTER = 5;

// Constantes liées AU type Consultation
    public static final int SAGE_FEMME = 1;
    public static final int MEDECIN = 2;
    public static final int DENTIST = 3;

    // Constantes liées AU Priorite
    public static final int NORMALE = 1;
    public static final int URGENT = 2;
    public static final int CRITIQUE = 3;
}
