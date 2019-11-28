/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.prefs.Preferences;

/**
 *
 * @author mbrebion
 */
public class SavedVariables {

    public static Preferences prefs;

    public static String getOpenCmd() {

        if (prefs != null) {
            return prefs.get("open", "");
        } else {
            return "";
        }
    }

    public static void setOpenCmd(String openCmd) {
        prefs.put("open", openCmd);
    }

    
    
    public static void setOutputDir(String output) {
        prefs.put("outputDir", output);
    }

    public static String getOutputDir() {
        if (prefs != null) {
            return prefs.get("outputDir", "");
        } else {
            return "";
        }
    }

    
    
    public static boolean getAutoSave() {
        System.err.println("Ping");
        if (prefs != null) {
            return "true".equals(prefs.get("autoSave", ""));
        } else {
            return false;
        }
    }

    public static void setAutoSave(boolean as) {
        if (as) {
            prefs.put("autoSave", "true");
        } else {
            prefs.put("autoSave", "false");
        }
        
    }
    
    
    public static void setMultiEdit(boolean me) {
        if (me) {
            prefs.put("multiEdit", "true");
        } else {
            prefs.put("multiEdit", "false");
        }
        
    }

    public static boolean getMultiEdit() {
        if (prefs != null) {
            return "true".equals(prefs.get("multiEdit", ""));
        } else {
            return false;
        }
    }
    
    
    
    public static String getPdflatexCmd() {

        if (prefs != null) {
            return prefs.get("pdflatex", "");
        } else {
            return "";
        }
    }

    public static void setPdflatexCmd(String pdflatexCmd) {
        prefs.put("pdflatex", pdflatexCmd);
    }

    
    
    public static String getTexModelsPaths() {

        if (prefs != null) {
            return prefs.get("templates", "");
        } else {
            return "";
        }
    }

    public static void setTexModelsPaths(String in) {
        prefs.put("templates", in);
    }

    
    
    
    public static String getMainGitDir() {

        if (prefs != null) {
            return prefs.get("mainGit", "");
        } else {
            return "";
        }
    }

    public static void setMainGitDir(String in) {
        prefs.put("mainGit", in);
    }

    
    
}
