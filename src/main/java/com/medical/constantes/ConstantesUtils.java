package com.medical.constantes;

public class ConstantesUtils {

    public static String getSexeLabel(int code) {
        return switch (code) {
            case TicketConstant.HOMME -> "Homme";
            case TicketConstant.FEMME -> "Femme";
            default -> "Inconnu";
        };
    }

    public static String getCategorieLabel(int code) {
        return switch (code) {
            case TicketConstant.ADULTE -> "Adulte";
            case TicketConstant.ENFANT -> "Enfant";
            default -> "Inconnu";
        };
    }

    public static String getStatutTicketLabel(int code) {
        return switch (code) {
            case TicketConstant.SOUMISE -> "Soumise";
            case TicketConstant.EN_COURS -> "En cours";
            case TicketConstant.EN_ATTENTE -> "En attente";
            case TicketConstant.ANNULER -> "Annulé";
            case TicketConstant.CONSULTER -> "Consulté";
            default -> "Statut inconnu";
        };
    }

    public static String getTypeConsultationLabel(int code) {
        return switch (code) {
            case TicketConstant.SAGE_FEMME -> "Sage-femme";
            case TicketConstant.MEDECIN -> "Médecin";
            case TicketConstant.DENTIST -> "Dentiste";
            default -> "Type inconnu";
        };
    }
}

