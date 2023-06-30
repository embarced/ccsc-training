//package ccsc.refactoring.badtelefon.tarif;
//
//import ccsc.refactoring.badtelefon.Zeitpunkt;
//
//public class Privat extends Tarif {
//    @Override
//    public double berechneGespraechspreis(int minuten, Zeitpunkt zeitpunkt) {
//        minuten = minuten - 1;
//        minuten = minuten < 0 ? 0 : minuten;
//        if (zeitpunkt.isMondscheinZeit())
//            return minuten * 0.69;
//        else
//            return minuten * 1.99;
//    }
//}
