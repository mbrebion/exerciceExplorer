/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import View.TextEditorBinded;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.StyleContext;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyleConstants;

public class CustomDocumentFilter extends DocumentFilter {

    private final StyledDocument styledDocument;
    private final JTextPane jtp;
    private final TextEditorBinded teb;
    private final Timer timer;
    private final int delay = 500;

    public final ArrayList<Integer> questionLocations = new ArrayList<>();
    public final ArrayList<String> versionTags = new ArrayList<>();
    private String selectedVersion = "original";
    private final StyleContext styleContext = StyleContext.getDefaultStyleContext();
    private final AttributeSet blueAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
    private final AttributeSet redAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.RED);
    private final AttributeSet blackAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
    private final AttributeSet grayAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.LIGHT_GRAY);

    DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);

    // list to store the new color locations
    private final List<Integer> blueList = new ArrayList<>();
    private final List<Integer> greyList = new ArrayList<>();
    private final List<Integer> redList = new ArrayList<>();

    // Use a regular expression to find the words you are looking for
    Pattern pattern = buildPattern();

    public CustomDocumentFilter(TextEditorBinded teb) {
        this.teb = teb;
        this.jtp = teb.jTextPane1;
        styledDocument = jtp.getStyledDocument();

        // parsing whole file event 
        timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                updateTextStyles(-1); // parse whole file
            }

        });
        timer.setRepeats(false);

    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
        super.insertString(fb, offset, text, attributeSet);

        handleTextChanged(offset);
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);

        handleTextChanged(offset);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
        super.replace(fb, offset, length, text, attributeSet);
        handleTextChanged(offset);
    }

    /**
     * Runs your updates later, not during the event notification.
     */
    public void handleTextChanged(int offset) {

        // first, a few portion of a text is parsed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                updateTextStyles(offset);
            }
        });

        timer.restart(); // cancel previous calls and recall timer

    }

    /**
     * Build the regular expression that looks for the whole word of each word
     * that you wish to find. The "\\b" is the beginning or end of a word
     * boundary. The "|" is a regex "or" operator.
     *
     * @return
     */
    private Pattern buildPattern() {
        StringBuilder sb = new StringBuilder();
        for (String token : new String[]{"\\\\addQ(\\[.*\\])?", "\\\\enonce", "\\\\partie", "\\\\sousPartie"}) {
            sb.append(""); // Start of word boundary
            sb.append(token);
            sb.append("|"); // End of word boundary and an or for the next word
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing "|"
        }

        Pattern p = Pattern.compile(sb.toString());

        return p;
    }

    public void updateTextStyles(int offset) {
        this.updateTextStyles(offset, true);
    }

    public void updateTextStyles(int offset, boolean tagUpdate) {

        this.teb.unRegisterUndoableManager(); //  no undoes for coloring

        // if offset >0 : only a portion around offset of the text is parsed 
        // if offset<0 : the whole text is parsed
        int begin, end;
        if (offset < 0) {
            begin = 0;
            end = jtp.getText().length();
            questionLocations.clear();
            if (tagUpdate) {
                versionTags.clear();  // remove all known tags
            }
        } else {
            begin = Math.max(offset - 80, 0); // maybe lokking for a few \n would be safer
            end = Math.min(jtp.getText().length(), offset + 80);
        }

        int count = 0;
        // Look for tokens and highlight them
        Matcher matcher = pattern.matcher(jtp.getText().subSequence(begin, end));
        while (matcher.find()) {

            // Change the color of recognized tokens
            if (matcher.group().contains("addQ")) {

                boolean display = true; // set to false if this question does not contains the versiontag asked by the user

                ////////////////////////////////////////// check if new versiontag is found : 
                if (matcher.group().contains("]")) {
                    try {
                        boolean contains = false;
                        String[] tags = matcher.group().substring(matcher.group().indexOf("[") + 1, matcher.group().indexOf("]")).split(",");
                        String trim;
                        for (String tag : tags) {

                            trim = tag.trim();
                            if (trim.equals(this.selectedVersion)) {
                                contains = true;
                            }
                            if (offset < 0 && tagUpdate && !versionTags.contains(trim) && !trim.equals("")) {
                                versionTags.add(trim);
                            }
                        }
                        if (!contains) {
                            display = false;
                        }
                    } catch (Error e) {
                    }
                }

                /////////////////////////////////////// we must find the whole question and answer blocs
                int qEnd = matcher.start();

                int found = 0;
                boolean oneOpened = false;
                int bcount = 0;
                List<Integer> indices = new ArrayList<>();

                while (found < 2 && begin + qEnd < jtp.getText().length()) {
                    char c = jtp.getText().charAt(begin + qEnd); // read next char

                    if (c == '{') {
                        if (bcount == 0) {
                            indices.add(qEnd);
                        }
                        bcount++;
                        oneOpened = true;
                    }
                    if (c == '}' && oneOpened) {
                        bcount--;
                        if (bcount == 0) {
                            found++;
                            indices.add(qEnd);
                            oneOpened = false;
                        }
                    }
                    qEnd++;
                }
                /////////////////////// displaying
                this.redList.add(matcher.start() + begin);
                this.redList.add(matcher.end() - matcher.start());

                if (display) {
                    count++; // one more question
                    questionLocations.add(matcher.start() + begin);
                    // normal mode : addQ tag and corresponding { and } are colored.

                    indices.stream().forEach((i) -> {
                        this.redList.add(i + begin);
                        this.redList.add(1);
                    });
                } else {
                    // hidden mode : question and answer in light grey
                    this.greyList.add(matcher.start() + begin);
                    this.greyList.add(qEnd - matcher.start());
                }

            } else {
                // other keywords : blue coloring
                this.blueList.add(matcher.start() + begin);
                this.blueList.add(matcher.end() - matcher.start());
            }
        }

        // Clear existing styles
        styledDocument.setCharacterAttributes(begin, end - begin, blackAttributeSet, true);

        // applying colors 
        for (int i = 0; i < this.blueList.size(); i += 2) {
            styledDocument.setCharacterAttributes(this.blueList.get(i), this.blueList.get(i + 1), blueAttributeSet, true);
        }
        this.blueList.clear();
        for (int i = 0; i < this.redList.size(); i += 2) {
            styledDocument.setCharacterAttributes(this.redList.get(i), this.redList.get(i + 1), redAttributeSet, true);
        }
        this.redList.clear();
        for (int i = 0; i < this.greyList.size(); i += 2) {
            styledDocument.setCharacterAttributes(this.greyList.get(i), this.greyList.get(i + 1), grayAttributeSet, true);
        }
        this.greyList.clear();

        if (offset < 0) {
            // if the whole document is parsed
            this.teb.setQuestionAmount(count);
            if (tagUpdate) {
                this.teb.updateVersionTags();
            }
        }

        this.teb.registerUndoableManager();

    }

    public int getQuestionNumber(int offset) {
        int out = 0;
        for (int i : questionLocations) {
            if (i > offset) {
                break;
            }
            out++;
        }
        return out;
    }

    public int getNextOffset(int offset) {
        int out = 0;
        for (int i : questionLocations) {
            out = i;
            if (i > offset) {
                break;
            }

        }
        return out;
    }

    public int getPreviousOffset(int offset) {
        int out = 0;
        for (int i : questionLocations) {

            if (i > offset) {
                break;
            }
            out = i;
        }
        return out;
    }

    public void setSelectedVersion(String version) {
        this.selectedVersion = version;
        this.updateTextStyles(-1, false);
        //The number of question must be modified here ! it is not done for the moment
    }
}