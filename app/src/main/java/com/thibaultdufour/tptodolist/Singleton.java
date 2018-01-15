package com.thibaultdufour.tptodolist;

import java.util.ArrayList;

/**
 * Created by dufourth on 15/01/2018.
 */
public final class Singleton {
    // L'utilisation du mot clé volatile, en Java version 5 et supérieure,
    // permet d'éviter le cas où "Singleton.instance" est non nul,
    // mais pas encore "réellement" instancié.
    // De Java version 1.2 à 1.4, il est possible d'utiliser la classe ThreadLocal.
    private static volatile Singleton instance = null;

    // D'autres attributs, classiques et non "static".
    private ArrayList<String> listeTache = new ArrayList<String>();

    /**
     * Constructeur de l'objet.
     */
    private Singleton() {
        // La présence d'un constructeur privé supprime le constructeur public par défaut.
        // De plus, seul le singleton peut s'instancier lui-même.
        super();
    }

    /**
     * Méthode permettant de renvoyer une instance de la classe Singleton
     * @return Retourne l'instance du singleton.
     */
    public final static Singleton getInstance() {
        //Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet
        //d'éviter un appel coûteux à synchronized,
        //une fois que l'instanciation est faite.
        if (Singleton.instance == null) {
            // Le mot-clé synchronized sur ce bloc empêche toute instanciation
            // multiple même par différents "threads".
            // Il est TRES important.
            synchronized(Singleton.class) {
                if (Singleton.instance == null) {
                    Singleton.instance = new Singleton();
                }
            }
        }
        return Singleton.instance;
    }

    public void addTask(String val)
    {
        listeTache.add(val);
    }

    public ArrayList<String> getListTask()
    {
        return  listeTache;
    }
    public void clearTaskList()
    {
        listeTache= new ArrayList<String>();
    }
}
