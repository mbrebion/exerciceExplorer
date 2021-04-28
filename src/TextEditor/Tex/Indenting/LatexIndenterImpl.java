/* The following code was generated by JFlex 1.4.1 on 27/04/2021 14:01 */

/*
 * 04/23/2019
 *
 * Maxence Miguel-Brebion 
 *
 * Latex Parser : improve code and format
 * 
 * 
 */
package TextEditor.Tex.Indenting;
import java.io.IOException;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 27/04/2021 14:01 from the specification file
 * <tt>/Users/mbrebion/devNum/Java/ExerciceExplorer/src/TextEditor/Tex/Indenting/LatexIndenter.flex</tt>
 */
public class LatexIndenterImpl extends LatexIndenterBase {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int BLOCK_A = 2;
  public static final int YYINITIAL = 0;
  public static final int BLOCK_Q = 1;
  public static final int BRACKET_BLOCK = 3;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\12\1\0\1\5\23\0\1\5\3\6\1\42\1\41"+
    "\1\6\1\4\2\6\1\27\1\6\1\25\1\1\1\3\1\6\12\2"+
    "\6\6\3\1\1\36\1\1\1\44\12\1\1\47\1\23\1\24\10\1"+
    "\1\20\1\11\1\21\1\6\1\1\1\0\1\37\1\13\1\31\1\22"+
    "\1\14\1\35\1\15\1\1\1\16\2\1\1\33\1\1\1\17\1\32"+
    "\1\40\1\26\1\43\1\34\1\30\1\46\2\1\1\45\2\1\1\7"+
    "\1\6\1\10\1\6\61\0\1\1\17\0\1\1\10\0\1\1\26\0"+
    "\1\1\1\0\1\1\4\0\5\1\2\0\2\1\4\0\1\1\1\0"+
    "\1\1\2\0\1\1\1\0\2\1\uff03\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\2\1\1\2\1\1\1\3\2\1\1\4\1\5"+
    "\1\2\1\6\1\1\1\3\1\1\2\0\7\1\1\7"+
    "\2\0\1\6\1\1\5\0\11\1\6\0\3\1\1\0"+
    "\1\10\7\1\6\0\1\1\1\0\13\1\11\0\1\1"+
    "\2\0\11\1\10\0\1\11\4\1\1\0\2\1\6\0"+
    "\1\10\1\1\4\0\1\1\3\0\1\12\3\0\1\13"+
    "\1\0\1\1\2\0\1\12\1\14\4\0\1\1\3\0"+
    "\1\1\4\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[160];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\170\0\120\0\240\0\310\0\360"+
    "\0\310\0\u0118\0\u0140\0\120\0\120\0\u0168\0\u0190\0\u01b8"+
    "\0\u0168\0\u01e0\0\310\0\u0208\0\u0230\0\u0258\0\u0280\0\u02a8"+
    "\0\u02d0\0\u02f8\0\u0320\0\u0118\0\u0348\0\u0168\0\u0370\0\u0398"+
    "\0\u03c0\0\u03e8\0\u0410\0\u0438\0\u0460\0\u0488\0\u04b0\0\u04d8"+
    "\0\u0500\0\u0528\0\u0550\0\u0578\0\u05a0\0\u05c8\0\u05f0\0\u0618"+
    "\0\u0640\0\u0668\0\u0690\0\u06b8\0\u06e0\0\u0708\0\u0730\0\u0758"+
    "\0\u0780\0\u07a8\0\u07d0\0\u07f8\0\u0820\0\u0848\0\u0870\0\u0898"+
    "\0\u08c0\0\u08e8\0\u0910\0\u0938\0\u0960\0\u0988\0\u09b0\0\u09d8"+
    "\0\u0a00\0\u0a28\0\u0a50\0\u0a78\0\u0aa0\0\u0ac8\0\u0af0\0\u0b18"+
    "\0\u0b40\0\u0b68\0\u0b90\0\u0bb8\0\u0be0\0\u0c08\0\u0c30\0\u0c58"+
    "\0\u0c80\0\u0ca8\0\u0cd0\0\u0cf8\0\u0d20\0\u0d48\0\u0d70\0\u0d98"+
    "\0\u0dc0\0\u0de8\0\u0e10\0\u0e38\0\u0e60\0\u0e88\0\u0eb0\0\u0ed8"+
    "\0\u0f00\0\u0f28\0\u0f50\0\u0f78\0\u0fa0\0\u0fc8\0\u0ff0\0\u1018"+
    "\0\u1040\0\u1068\0\u1090\0\u10b8\0\u10e0\0\u1108\0\u1130\0\u1158"+
    "\0\u1180\0\u11a8\0\u11d0\0\u11f8\0\u1220\0\u1248\0\u1270\0\u1298"+
    "\0\u12c0\0\u12e8\0\u1310\0\u1338\0\u1360\0\u1388\0\u13b0\0\u13d8"+
    "\0\u1400\0\u1428\0\u1450\0\u1478\0\u14a0\0\u14c8\0\u14f0\0\u1518"+
    "\0\u1540\0\u1568\0\u1590\0\u15b8\0\u15e0\0\u1608\0\u1630\0\u1658"+
    "\0\u1680\0\u16a8\0\u16d0\0\u16f8\0\u1720\0\u1748\0\u1770\0\u1798";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[160];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\3\6\1\5\1\7\1\6\2\5\1\10\1\11"+
    "\26\6\1\12\1\13\5\6\7\5\1\14\1\15\1\5"+
    "\1\0\35\5\50\0\1\5\3\6\1\5\1\16\1\6"+
    "\1\14\1\17\1\20\1\21\26\6\1\12\1\13\5\6"+
    "\1\0\3\6\2\0\1\6\2\0\1\22\1\0\26\6"+
    "\2\0\5\6\5\0\1\23\3\0\1\24\1\23\36\0"+
    "\3\6\2\0\3\6\1\22\1\0\1\25\1\26\6\6"+
    "\1\27\4\6\1\30\3\6\1\31\1\32\2\6\1\33"+
    "\2\0\5\6\1\0\11\34\1\0\26\34\2\0\5\34"+
    "\1\0\11\35\1\0\26\35\2\0\5\35\5\0\1\36"+
    "\2\0\1\17\1\24\1\36\42\0\1\17\1\0\1\37"+
    "\2\0\1\17\36\0\3\6\2\0\3\6\1\22\1\0"+
    "\1\25\1\26\6\6\1\27\4\6\1\40\4\6\1\32"+
    "\3\6\2\0\5\6\1\0\3\6\2\0\3\6\1\22"+
    "\1\0\26\6\2\0\5\6\13\0\1\41\1\42\6\0"+
    "\1\43\4\0\1\44\4\0\1\45\13\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\1\6\1\46\24\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\4\6\1\47\6\6\1\50\12\6\2\0\5\6\1\0"+
    "\3\6\2\0\1\6\2\0\1\22\1\0\11\6\1\51"+
    "\14\6\2\0\5\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\22\1\0\3\6\1\52\12\6\1\53\7\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\17\6\1\54\6\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\3\6\1\55\22\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\24\6\1\56\1\6\2\0\5\6\1\0\11\35\1\0"+
    "\26\35\1\0\1\5\5\35\5\0\1\37\4\0\1\37"+
    "\36\0\3\6\2\0\1\6\2\0\1\22\1\0\16\6"+
    "\1\53\7\6\2\0\5\6\14\0\1\57\52\0\1\60"+
    "\6\0\1\61\45\0\1\62\54\0\1\63\34\0\1\64"+
    "\32\0\3\6\2\0\1\6\2\0\1\22\1\0\2\6"+
    "\1\65\23\6\2\0\5\6\1\0\3\6\2\0\1\6"+
    "\2\0\1\22\1\0\7\6\1\66\7\6\1\67\6\6"+
    "\2\0\5\6\1\0\3\6\1\0\1\70\1\6\1\71"+
    "\1\0\1\22\1\70\5\6\1\72\20\6\2\0\5\6"+
    "\1\0\3\6\2\0\1\6\1\71\1\0\1\22\1\0"+
    "\5\6\1\73\20\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\15\6\1\74\10\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\17\6\1\75\6\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\26\6\2\0\3\6\1\76"+
    "\1\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\2\6\1\77\23\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\26\6\2\0\1\100\4\6"+
    "\15\0\1\101\64\0\1\102\22\0\1\70\1\0\1\71"+
    "\2\0\1\70\5\0\1\103\36\0\1\71\10\0\1\104"+
    "\61\0\1\105\32\0\1\106\33\0\3\6\2\0\1\6"+
    "\2\0\1\22\1\0\3\6\1\107\22\6\2\0\5\6"+
    "\1\0\3\6\2\0\1\6\1\110\1\0\1\22\1\0"+
    "\26\6\2\0\5\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\22\1\0\4\6\1\111\21\6\2\0\5\6\5\0"+
    "\1\70\1\0\1\71\2\0\1\70\42\0\1\71\4\0"+
    "\1\71\36\0\1\112\1\113\1\6\2\0\1\6\2\0"+
    "\1\22\1\0\5\112\2\6\3\112\1\6\1\112\1\6"+
    "\11\112\2\0\5\112\1\0\1\114\1\115\1\6\2\0"+
    "\1\6\2\0\1\22\1\0\5\114\1\6\1\116\3\114"+
    "\1\6\1\114\1\6\11\114\2\0\5\114\1\0\3\6"+
    "\2\0\1\6\2\0\1\22\1\0\26\6\2\0\1\117"+
    "\4\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\20\6\1\120\5\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\21\6\1\121\4\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\23\6\1\122\2\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\15\6\1\123\10\6\2\0"+
    "\5\6\16\0\1\124\50\0\1\125\31\0\1\126\1\127"+
    "\10\0\5\126\2\0\3\126\1\0\1\126\1\0\11\126"+
    "\2\0\5\126\1\0\1\130\1\131\10\0\5\130\1\0"+
    "\1\132\3\130\1\0\1\130\1\0\11\130\2\0\5\130"+
    "\33\0\1\133\52\0\1\134\12\0\3\6\2\0\1\6"+
    "\2\0\1\22\1\0\4\6\1\135\21\6\2\0\5\6"+
    "\1\0\1\136\1\137\10\0\5\136\2\0\3\136\1\0"+
    "\1\136\1\0\11\136\2\0\5\136\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\16\6\1\140\7\6\2\0"+
    "\5\6\1\0\1\112\1\113\1\6\2\0\1\6\2\0"+
    "\1\22\1\0\5\112\1\6\1\141\3\112\1\6\1\112"+
    "\1\142\11\112\2\0\5\112\1\0\1\112\1\113\1\112"+
    "\2\0\1\6\2\0\1\22\1\0\5\112\1\6\1\141"+
    "\3\112\1\6\1\112\1\142\11\112\2\0\5\112\1\0"+
    "\1\114\1\115\1\6\2\0\1\6\2\0\1\22\1\0"+
    "\5\114\1\6\1\143\3\114\1\6\1\114\1\6\11\114"+
    "\2\0\5\114\1\0\1\114\1\115\1\114\2\0\1\6"+
    "\2\0\1\22\1\0\5\114\1\6\1\143\3\114\1\6"+
    "\1\114\1\6\11\114\2\0\5\114\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\5\6\1\144\20\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\1\6\1\145\24\6\2\0\5\6\1\0\3\6\2\0"+
    "\1\6\2\0\1\22\1\0\21\6\1\146\4\6\2\0"+
    "\5\6\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\26\6\2\0\4\6\1\33\1\0\3\6\2\0\1\6"+
    "\2\0\1\22\1\0\24\6\1\147\1\6\2\0\5\6"+
    "\1\0\3\6\2\0\1\6\2\0\1\22\1\0\3\6"+
    "\1\150\22\6\2\0\5\6\17\0\1\151\61\0\1\152"+
    "\17\0\1\126\1\127\10\0\5\126\1\0\1\70\3\126"+
    "\1\0\1\126\1\153\11\126\2\0\5\126\1\0\1\126"+
    "\1\127\1\126\7\0\5\126\1\0\1\70\3\126\1\0"+
    "\1\126\1\153\11\126\2\0\5\126\1\0\1\130\1\131"+
    "\10\0\5\130\1\0\1\154\3\130\1\0\1\130\1\0"+
    "\11\130\2\0\5\130\1\0\1\130\1\131\1\130\7\0"+
    "\5\130\1\0\1\154\3\130\1\0\1\130\1\0\11\130"+
    "\2\0\5\130\20\0\1\155\63\0\1\156\52\0\1\157"+
    "\11\0\3\6\2\0\1\6\1\160\1\0\1\22\1\0"+
    "\26\6\2\0\5\6\1\0\1\136\1\137\5\0\1\161"+
    "\2\0\5\136\2\0\3\136\1\0\1\136\1\0\11\136"+
    "\2\0\5\136\1\0\1\136\1\137\1\136\4\0\1\161"+
    "\2\0\5\136\2\0\3\136\1\0\1\136\1\0\11\136"+
    "\2\0\5\136\1\0\3\6\2\0\1\6\2\0\1\22"+
    "\1\0\1\6\1\162\24\6\2\0\5\6\1\0\3\6"+
    "\1\0\1\70\1\6\1\71\1\0\1\22\1\70\26\6"+
    "\2\0\5\6\1\0\3\6\2\0\1\6\2\0\1\22"+
    "\1\0\6\6\1\141\17\6\2\0\5\6\1\0\3\6"+
    "\2\0\1\6\1\71\1\0\1\22\1\0\26\6\2\0"+
    "\5\6\1\0\1\163\1\164\1\6\2\0\1\6\2\0"+
    "\1\22\1\0\5\163\2\6\5\163\1\6\11\163\2\0"+
    "\5\163\1\0\3\6\2\0\1\6\2\0\1\22\1\0"+
    "\26\6\2\0\1\6\1\165\3\6\1\0\3\6\2\0"+
    "\1\6\1\166\1\0\1\22\1\0\26\6\2\0\5\6"+
    "\1\0\3\6\2\0\1\6\2\0\1\22\1\0\25\6"+
    "\1\167\2\0\5\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\22\1\0\1\6\1\170\24\6\2\0\5\6\7\0"+
    "\1\160\54\0\1\171\54\0\1\70\35\0\1\71\41\0"+
    "\1\172\1\173\10\0\5\172\2\0\5\172\1\0\11\172"+
    "\2\0\5\172\7\0\1\166\100\0\1\174\10\0\1\175"+
    "\1\176\10\0\5\175\2\0\3\175\1\0\1\175\1\0"+
    "\11\175\2\0\5\175\12\0\1\161\36\0\3\6\2\0"+
    "\1\6\1\177\1\0\1\22\1\0\26\6\2\0\5\6"+
    "\1\0\1\163\1\164\1\6\2\0\1\6\2\0\1\22"+
    "\1\0\5\163\1\6\1\143\5\163\1\6\11\163\2\0"+
    "\5\163\1\0\1\163\1\164\1\163\2\0\1\6\2\0"+
    "\1\22\1\0\5\163\1\6\1\143\5\163\1\6\11\163"+
    "\2\0\5\163\1\0\3\6\2\0\1\6\2\0\1\22"+
    "\1\0\26\6\2\0\2\6\1\200\2\6\2\0\1\201"+
    "\46\0\3\6\2\0\1\6\1\202\1\0\1\22\1\0"+
    "\26\6\2\0\5\6\1\0\3\6\2\0\1\6\1\203"+
    "\1\0\1\22\1\0\26\6\2\0\5\6\7\0\1\177"+
    "\41\0\1\172\1\173\10\0\5\172\1\0\1\154\5\172"+
    "\1\0\11\172\2\0\5\172\1\0\1\172\1\173\1\172"+
    "\7\0\5\172\1\0\1\154\5\172\1\0\11\172\2\0"+
    "\5\172\7\0\1\202\41\0\1\175\1\176\5\0\1\204"+
    "\2\0\5\175\2\0\3\175\1\0\1\175\1\0\11\175"+
    "\2\0\5\175\1\0\1\175\1\176\1\175\4\0\1\204"+
    "\2\0\5\175\2\0\3\175\1\0\1\175\1\0\11\175"+
    "\2\0\5\175\12\0\1\177\36\0\3\6\2\0\1\6"+
    "\2\0\1\22\1\0\1\6\1\205\24\6\2\0\5\6"+
    "\2\0\1\201\1\206\4\0\1\207\40\0\3\210\7\0"+
    "\5\210\2\0\3\210\1\0\1\210\1\0\11\210\2\0"+
    "\5\210\1\0\6\203\1\0\1\211\1\212\1\0\26\203"+
    "\2\0\5\203\1\0\6\213\1\214\2\213\1\215\5\213"+
    "\1\216\20\213\2\0\5\213\1\0\3\6\2\0\1\6"+
    "\2\0\1\22\1\0\26\6\2\0\1\217\4\6\2\0"+
    "\1\206\5\0\1\207\46\0\1\220\41\0\3\210\4\0"+
    "\1\221\2\0\5\210\2\0\3\210\1\0\1\210\1\0"+
    "\11\210\2\0\5\210\12\0\1\211\36\0\7\203\1\222"+
    "\1\212\1\0\26\203\2\0\5\203\1\0\11\213\1\223"+
    "\26\213\2\0\5\213\1\0\6\214\1\213\1\224\1\225"+
    "\1\223\26\214\2\0\5\214\12\0\1\215\36\0\6\216"+
    "\2\213\1\226\1\223\6\216\1\227\17\216\2\0\5\216"+
    "\1\0\3\6\2\0\1\6\2\0\1\22\1\0\16\6"+
    "\1\230\7\6\2\0\5\6\2\0\1\231\54\0\1\232"+
    "\41\0\6\203\1\0\1\211\1\212\1\211\26\203\2\0"+
    "\5\203\12\0\1\223\36\0\6\213\1\214\2\213\1\215"+
    "\26\213\2\0\5\213\1\0\7\214\1\233\1\225\1\223"+
    "\26\214\2\0\5\214\1\0\10\216\1\226\1\223\6\216"+
    "\1\227\17\216\2\0\5\216\1\0\6\216\1\214\1\213"+
    "\1\226\1\215\6\216\1\227\17\216\2\0\5\216\1\0"+
    "\3\6\2\0\1\6\2\0\1\22\1\0\3\6\1\234"+
    "\22\6\2\0\5\6\2\0\1\231\1\235\4\0\1\171"+
    "\40\0\3\236\2\0\1\236\2\0\1\237\1\0\26\236"+
    "\2\0\5\236\1\0\7\214\1\224\1\225\1\215\26\214"+
    "\2\0\5\214\1\0\3\6\2\0\1\6\2\0\1\22"+
    "\1\0\16\6\1\150\7\6\2\0\5\6\2\0\1\235"+
    "\5\0\1\171\40\0\3\236\2\0\1\236\1\0\1\171"+
    "\1\237\1\0\26\236\2\0\5\236\1\0\3\236\2\0"+
    "\2\236\1\240\1\237\1\0\26\236\2\0\5\236\1\0"+
    "\3\236\2\0\1\236\1\177\1\171\1\237\1\0\26\236"+
    "\2\0\5\236";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6080];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\10\1\0\1\11\6\1\2\11\5\1\2\0"+
    "\10\1\2\0\2\1\5\0\11\1\6\0\3\1\1\0"+
    "\10\1\6\0\1\1\1\0\13\1\11\0\1\1\2\0"+
    "\11\1\10\0\5\1\1\0\2\1\6\0\2\1\4\0"+
    "\1\1\3\0\1\1\3\0\1\1\1\0\1\1\2\0"+
    "\2\1\4\0\1\1\3\0\1\1\4\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[160];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */

	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public LatexIndenterImpl() {
            super();
	}

        
 @Override
    public void startParsing() {
        yybegin(YYINITIAL);
        try {
            yylex();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
            



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LatexIndenterImpl(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LatexIndenterImpl(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 172) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public boolean yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 11: 
          { this.startBlock(1);
          }
        case 13: break;
        case 8: 
          { startBracketBloc(yytext());
          }
        case 14: break;
        case 12: 
          { this.startBlock(2);
          }
        case 15: break;
        case 3: 
          { this.endLine();
          }
        case 16: break;
        case 5: 
          { addCloseBracket();
          }
        case 17: break;
        case 9: 
          { this.endBlock();
          }
        case 18: break;
        case 2: 
          { this.addWhiteSpace();
          }
        case 19: break;
        case 10: 
          { this.currentLine+=yytext().trim(); this.endLine(); this.endLine();
          }
        case 20: break;
        case 7: 
          { this.currentLine += yytext();
          }
        case 21: break;
        case 4: 
          { addOpenBracket();
          }
        case 22: break;
        case 1: 
          { this.currentLine+=yytext();
          }
        case 23: break;
        case 6: 
          { endBracketBlock() ;
          }
        case 24: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case YYINITIAL: {
              this.endLine(); return false;
            }
            case 161: break;
            case BLOCK_Q: {
              return false;
            }
            case 162: break;
            case BRACKET_BLOCK: {
              return false;
            }
            case 163: break;
          
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
