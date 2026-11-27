package suche.tiefe.elter;

import graph.Graph;
import java.util.ArrayList;
import liste.Liste;
import java.util.HashSet;

// Tiefensuche. Gib nur die Reihe von Knoten aus.

public class Tiefensucheelter {

    //   o       o   o
    //    \     /   /
    //     o   o---o---o
    //      \ /   /
    //       o---o----o
    //  o   / \   \
    //  |  /   o---\
    //  o--         o
    //
    public static int[] suche(Graph g, int anfangknoten) {

        int[] elter = new int[g.groesse()];
        HashSet<Integer> gesehen = new HashSet<Integer>();
        ArrayList<Integer> zulaufen = new ArrayList<Integer>();

        zulaufen.add(anfangknoten);
        elter[anfangknoten] = anfangknoten;

        while (zulaufen.size() > 0) {

            int naechste = zulaufen.remove(zulaufen.size() - 1);
            gesehen.add(naechste);
            ArrayList<Integer> nachbarn = g.nachbar.get(naechste);
            System.out.println(naechste + " " + nachbarn.size());
            
            for (int nachbar : nachbarn) {
                if (!gesehen.contains(nachbar) && !zulaufen.contains(nachbar)) {
                    System.out.println("e " + nachbar + " " + naechste);
                    elter[nachbar] = naechste;
                    zulaufen.add(nachbar);
                }
            }
        }

        return elter;
    }
}
