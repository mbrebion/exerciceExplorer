/*
 * 04/24/2012
 *
 * Maxence Miguel-Brebion 
 *
 * LatexTokenMaker.java - Scanner for LaTeX.
 * 
 * This library is distributed under a modified BSD license.  See the included
 * LICENSE file for details.
 */
package TextEditor.Tex.Coloring;

import java.io.*;
import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.*;


/**
 * If you wish to regenerate this file yourself, keep in mind the following:
 * <ul>
 *   <li>The generated <code>LatexTokenMaker.java</code> file will contain two
 *       definitions of both <code>zzRefill</code> and <code>yyreset</code>.
 *       You should hand-delete the second of each definition (the ones
 *       generated by the lexer), as these generated methods modify the input
 *       buffer, which we'll never have to do.</li>
 *   <li>You should also change the declaration/definition of zzBuffer to NOT
 *       be initialized.  This is a needless memory allocation for us since we
 *       will be pointing the array somewhere else anyway.</li>
 *   <li>You should NOT call <code>yylex()</code> on the generated scanner
 *       directly; rather, you should use <code>getTokenList</code> as you would
 *       with any other <code>TokenMaker</code> instance.</li>
 * </ul>
 *
 * @author Robert Futrell & Maxence Miguel-Brebion
 * @version 0.6
 *
 */
%%

%public
%class LatexTokenMaker
%extends AbstractJFlexTokenMaker
%unicode
%type org.fife.ui.rsyntaxtextarea.Token


%{

// external state of file

public static String login="original";


// tokens
public static final int TOKEN_ADDQ=24;
public static final int TOKEN_ADDA=25;
public static final int TOKEN_ADDQ_H=26;
public static final int TOKEN_ADDA_H=27;
public static final int TOKEN_INLINE_EQ=30;
public static final int TOKEN_MLE=32;
public static final int TOKEN_MLE_IN_Q=33;
public static final int TOKEN_MLE_IN_A=34;
public static final int TOKEN_PART=37;
public static final int TOKEN_SUB_PART=38;
public static final int TOKEN_TITLE=39;

// serializing constants for multiline paterns
public static final int BALANCE_MULT = 1000;
public static final int BALANCE_DEC = 0; // cumulative balance of bracket should never be negative ;-)
public static final int FORMER_BALANCE_MULT = BALANCE_MULT*100;
public static final int FIRST_MULT = FORMER_BALANCE_MULT*10;

// lastToken = token_type + BALANCE_MULT*(balance + dec) +FORMER_BALANCE_MULT*formerBalanceCount 
// where balance is nb of "{" minus nb of "}" for the current line
// and block is the amount of blocks already recovered (\frac{a}{v} requires two for instance)
// and first is 1 if a multiline block started on this line ; 0 else

        protected int bracketCount=0;
        protected int formerBalanceCount=0;
        protected boolean first = false; // boolean flag used for indentation at the begining of a new block

	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public LatexTokenMaker() {
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 */
	private void addToken(int tokenType) {
		addToken(zzStartRead, zzMarkedPos-1, tokenType);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param tokenType The token's type.
	 * @see #addHyperlinkToken(int, int, int)
	 */
	private void addToken(int start, int end, int tokenType) {
		int so = start + offsetShift;
		addToken(zzBuffer, start,end, tokenType, so, false);
	}


	/**
	 * Adds the token specified to the current linked list of tokens.
	 *
	 * @param array The character array.
	 * @param start The starting offset in the array.
	 * @param end The ending offset in the array.
	 * @param tokenType The token's type.
	 * @param startOffset The offset in the document at which this token
	 *                    occurs.
	 * @param hyperlink Whether this token is a hyperlink.
	 */
	@Override
	public void addToken(char[] array, int start, int end, int tokenType,
						int startOffset, boolean hyperlink) {
		super.addToken(array, start,end, tokenType, startOffset, hyperlink);
		zzStartRead = zzMarkedPos;
	}


	/**
	 * ${inheritDoc}
	 */
	@Override
	public String[] getLineCommentStartAndEnd(int languageIndex) {
		return new String[] { "%", null };
	}

        /**
        *          DEALING WITH INDENT
        **/
       @Override
        public boolean getShouldIndentNextLineAfter(Token token) {
            if (!first || token==null){return false;}
            
            switch(token.getType()%BALANCE_MULT){
                 case  TOKEN_ADDQ :
                    return true;
                    
                case  TOKEN_MLE :
                    return true;
                    
                case TOKEN_MLE_IN_A:
                    return true;
                    
                case TOKEN_MLE_IN_Q :
                    return true;

                case Token.RESERVED_WORD :
                    return true;
            }
               

            return false;
        }


        /**
        *          DEALING WITH BRACKETS
        **/

    

        public void initBracketBlock(){
            formerBalanceCount = 0;
            bracketCount = 0;
        }

        public void enterBracketBlock(){
            formerBalanceCount = bracketCount; // the bracketCount must be saved as we may be in a block inside a former block which will need to be closed after
            bracketCount = 0;
        }

        public void leaveBracketBlock(){
            bracketCount = formerBalanceCount;
            formerBalanceCount = 0; 
        }

        public int getLastTokenVal(int tokenType){
            return tokenType + BALANCE_MULT*(bracketCount + BALANCE_DEC) + FORMER_BALANCE_MULT * formerBalanceCount ;
        }

        

        public void addOpenBracket(){
            bracketCount ++;
        }

        public void addCloseBracket(){
            bracketCount -- ;
        }

        public boolean isEndOfBlock(){
            return bracketCount==0;
        }

    public void conditionalReturnToInitial(int state) {
        // check wheter in bracker block is closed and switch state if yes.
        if (isEndOfBlock()) {
            leaveBracketBlock();
            switch(zzLexicalState){
                case  ADDQ:
                    this.addToken(TOKEN_ADDQ);
                    break;
                    
                case ADDA:
                    this.addToken(TOKEN_ADDA);
                    break;
                    
                default:
                    this.addToken(Token.SEPARATOR);
                    break;
            
            }

            yybegin(state);

        } else {
            this.addToken(Token.SEPARATOR);
        }
    }

        
        public void conditionalSwitch(String logins, int stateTrue, int stateFalse){
            int newState =  logins.contains(login) ? stateTrue : stateFalse;
            yybegin(newState);
        }

        /**
        *   Dealing with blocks
        **/

        /**
        * function called when an inline eq is parsed
        */
        public void parseInlineEq() {
            int s = zzStartRead;
            int e = zzMarkedPos - 1;
            String txt = yytext().replace("\\{", "XX").replace("\\}", "YY");
            for (int i=0; i<txt.length();i++){
                if (txt.charAt(i)=='{'){
                    this.addOpenBracket();
                    this.addToken(s+i, s+i, Token.SEPARATOR);
                } 
                else if (txt.charAt(i)=='}') {
                    this.addCloseBracket();
                    this.addToken(s+i, s+i, Token.SEPARATOR);
                }else{
                    this.addToken(s+i, s+i, TOKEN_INLINE_EQ);
                }
            }
         }


        public void beginMLE(int newState){
            addToken(zzStartRead,zzMarkedPos-2, Token.FUNCTION);
            addToken(zzMarkedPos-1,zzMarkedPos-1, Token.SEPARATOR);
            first=true;
            enterBracketBlock();
            addOpenBracket();
            yybegin(newState);
        }

        public void beginADDQ(int newState){
            addToken(zzStartRead,zzMarkedPos-2, TOKEN_ADDQ);
            addToken(zzMarkedPos-1,zzMarkedPos-1, TOKEN_ADDQ);
            first=true;
            initBracketBlock();
            addOpenBracket();
            yybegin(newState);
        }

	/**
	 * Returns the first token in the linked list of tokens generated
	 * from <code>text</code>.  This method must be implemented by
	 * subclasses so they can correctly implement syntax highlighting.
	 *
	 * @param text The text from which to get tokens.
	 * @param initialTokenType The token type we should start with.
	 * @param startOffset The offset into the document at which
	 *        <code>text</code> starts.
	 * @return The first <code>Token</code> in a linked list representing
	 *         the syntax highlighted text.
	 */
	@Override
	public Token getTokenList(Segment text, int previousLineData, int startOffset) {

		resetTokenList();
                
		this.offsetShift = -text.offset + startOffset;

		// Start off in the proper state.
		int state = YYINITIAL;

                // deserialize initialTokenType : 
                first = false;
                int initialTokenType =  previousLineData % BALANCE_MULT ;
                initBracketBlock(); // to be removed ?
                formerBalanceCount =  (previousLineData)/ FORMER_BALANCE_MULT;
                bracketCount = (previousLineData%FORMER_BALANCE_MULT) / BALANCE_MULT - BALANCE_DEC;
                    
                start = text.offset;
	        switch (initialTokenType) {
		
			case TOKEN_MLE:
				state = MLE;
				break;

                         case TOKEN_MLE_IN_Q:
				state = MLE_IN_Q;
				break;

                         case TOKEN_MLE_IN_A:
				state = MLE_IN_A;
				break;

                         case TOKEN_ADDQ:
				state = ADDQ;
				break;

                         case TOKEN_ADDQ_H:
				state = HIDDEN_ADDQ;
				break;

                         case TOKEN_ADDA_H:
				state = HIDDEN_ADDA;
				break;

                         case TOKEN_ADDA:
				state = ADDA;
				break;

			default:
				state = YYINITIAL;
                                 initBracketBlock();
		}
                               

		s = text;
		try {
			yyreset(zzReader);
			yybegin(state);
			return yylex();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new TokenImpl();
		}

	}


	/**
	 * Refills the input buffer.
	 *
	 * @return      <code>true</code> if EOF was reached, otherwise
	 *              <code>false</code>.
	 * @exception   IOException  if any I/O-Error occurs.
	 */
	private boolean zzRefill() {
		return zzCurrentPos>=s.offset+s.count;
	}


	/**
	 * Resets the scanner to read from a new input stream.
	 * Does not close the old reader.
	 *
	 * All internal variables are reset, the old input stream 
	 * <b>cannot</b> be reused (internal buffer is discarded and lost).
	 * Lexical state is set to <tt>YY_INITIAL</tt>.
	 *
	 * @param reader   the new input stream 
	 */
	public final void yyreset(java.io.Reader reader) {
		// 's' has been updated.
		zzBuffer = s.array;
		/*
		 * We replaced the line below with the two below it because zzRefill
		 * no longer "refills" the buffer (since the way we do it, it's always
		 * "full" the first time through, since it points to the segment's
		 * array).  So, we assign zzEndRead here.
		 */
		//zzStartRead = zzEndRead = s.offset;
		zzStartRead = s.offset;
		zzEndRead = zzStartRead + s.count - 1;
		zzCurrentPos = zzMarkedPos = zzPushbackPos = s.offset;
		zzLexicalState = YYINITIAL;
		zzReader = reader;
		zzAtBOL  = true;
		zzAtEOF  = false;
	}


%}


Letter					= ([azertyuiopmlkjhgfdsqwxcvbnAZERTYUIOPMLKJHGFDSQWXCVBNéèêëàâùûüöôç@ÉïîÀ°])
Digit					= ([0-9])
LetterOrUnderscore		        = ({Letter}|[_])
AnyChar					= ({LetterOrUnderscore}|{Digit}|[\-])
Appost                                   = (['])
Whitespace				= ([ \t\f])
LineCommentBegin		= "%"


URLSubDelim				= ([#><\^?\!\&\(\)\*\+:\.,\/;=\[\]\\|\"\~])
OpenBracket                              =([\{])
CloseBracket                              =([\}])
RAnyChar                                 = ({AnyChar} | {OpenBracket} | {CloseBracket} | {URLSubDelim}  )
RAnyCharWB                                 = ({AnyChar} |  {URLSubDelim} | (\\\{) | (\\\}) )

Sentence                                 = ({RAnyChar} | {Whitespace} |{Appost} )
SentenceWB                                 = ({RAnyCharWB} | {Whitespace} |{Appost} )

MLEbegin = ("\\eq{")
ADDQbegin = ("\\addQ{")
ADDQloginBegin = ("\\addQ["{AnyChar}+"]{")


%state EOL_COMMENT
%state MLE
%state MLE_IN_Q
%state MLE_IN_A
%state HIDDEN_ADDQ
%state HIDDEN_ADDA
%state ADDQ
%state ADDA

%%

<YYINITIAL, ADDQ,ADDA>{
([\\]{AnyChar}+)			            { addToken(Token.FUNCTION); }
([\\]%)					    { int temp = zzStartRead; addToken(temp, temp, Token.SEPARATOR); addToken(temp + 1, temp + 1, Token.IDENTIFIER);}
("$"{Sentence}+"$")                          { parseInlineEq();}
("\\begin{"{AnyChar}+"}")   { int temp = zzStartRead;
                                                addToken(temp, temp+5, Token.RESERVED_WORD);
                                                addToken(temp+6, temp+6, Token.RESERVED_WORD);
                                                addToken(temp+7, zzMarkedPos-2, Token.RESERVED_WORD);
                                                addToken(zzMarkedPos-1, zzMarkedPos-1, Token.RESERVED_WORD);
                                                first = true;
                                                        }
("\\end{"{AnyChar}+"}")		{ int temp = zzStartRead;
                                                addToken(temp, temp+3, Token.RESERVED_WORD);
                                                addToken(temp+4, temp+4, Token.RESERVED_WORD);
                                                addToken(temp+5, zzMarkedPos-2, Token.RESERVED_WORD);
                                                addToken(zzMarkedPos-1, zzMarkedPos-1, Token.RESERVED_WORD);
                                                        }
<MLE,MLE_IN_Q,MLE_IN_A>({LineCommentBegin}({Sentence}|"$")*)			{addToken(Token.COMMENT_EOL); }
{Whitespace}				{ addToken(Token.WHITESPACE); }
{Appost}  				{ addToken(Token.IDENTIFIER); }
{RAnyCharWB}+                            { addToken(Token.IDENTIFIER); }

}
<YYINITIAL> {

        {ADDQbegin}                                  { beginADDQ(ADDQ); }

        {ADDQloginBegin}                             { String logins = yytext(); first=true;
                                                       //addToken(zzStartRead,zzStartRead+5,TOKEN_ADDQ_H);
                                                       //addToken(zzStartRead+6,zzMarkedPos-3,TOKEN_ADDQ); 
                                                       //addToken(zzMarkedPos-2,zzMarkedPos-1,TOKEN_ADDQ_H); 
                                                         addToken(TOKEN_ADDQ);
                                                      initBracketBlock(); addOpenBracket();
                                                      logins=logins.substring(6,logins.length()-2);
                                                      conditionalSwitch(logins,ADDQ,HIDDEN_ADDQ); }

        {MLEbegin}                                   { beginMLE(MLE);  }       
                                                                    
        "\\titreExercice{"{SentenceWB}*"}"                  { int temp = zzStartRead+7;
                                                     addToken(temp-7,temp+6,Token.FUNCTION); 
                                                     addToken(temp+7,temp+7,Token.SEPARATOR); 
                                                     addToken(temp+8,zzMarkedPos-2,TOKEN_TITLE); 
                                                     addToken(zzMarkedPos-1,zzMarkedPos-1,Token.SEPARATOR); 
                                                     }

        "\\partie{"{SentenceWB}*"}"                  { int temp = zzStartRead;
                                                     addToken(temp,temp+6,Token.FUNCTION); 
                                                     addToken(temp+7,temp+7,Token.SEPARATOR); 
                                                     addToken(temp+8,zzMarkedPos-2,TOKEN_PART); 
                                                     addToken(zzMarkedPos-1,zzMarkedPos-1,Token.SEPARATOR); 
                                                     }

        "\\sousPartie{"{SentenceWB}*"}" { int temp = zzStartRead+4;
                                                     addToken(temp-4,temp+6,Token.FUNCTION); 
                                                     addToken(temp+7,temp+7,Token.SEPARATOR); 
                                                     addToken(temp+8,zzMarkedPos-2,TOKEN_SUB_PART); 
                                                     addToken(zzMarkedPos-1,zzMarkedPos-1,Token.SEPARATOR); 
                                                     }
	
	[\{\}]					    { addToken(Token.SEPARATOR); }

        
	
	

	"\n" |
	<<EOF>>						{ addNullToken(); return firstToken; }

	/* Catch any other (unhandled) characters and flag them as identifiers. */
	{AnyChar}+						{ addToken(Token.IDENTIFIER);  }
        .							{  addToken(Token.IDENTIFIER);  }

}


<EOL_COMMENT> {	
	{Sentence}				{ addToken(Token.COMMENT_EOL);  }
         <<EOF>>				        { addToken( Token.NULL); return firstToken; }
        .					{  addToken(Token.COMMENT_EOL);  }
}


/* equation outside question or answer */
<MLE>{        
       {RAnyCharWB}+					{  addToken( TOKEN_MLE);  }
       {OpenBracket}                                     {  addToken( Token.SEPARATOR); addOpenBracket();}
       {CloseBracket}                                    {  addCloseBracket(); conditionalReturnToInitial(YYINITIAL);}
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_MLE)); return firstToken; }
        .					        {  addToken( TOKEN_MLE);  }
}

/* equation inside question */
<MLE_IN_Q>{
       {RAnyCharWB}+					{  addToken( TOKEN_MLE_IN_Q);  }
       {OpenBracket}                                     {  addToken( Token.SEPARATOR); addOpenBracket();}
       {CloseBracket}                                    {  addCloseBracket(); conditionalReturnToInitial(ADDQ);}
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_MLE_IN_Q)); return firstToken; }
        .					        {  addToken( TOKEN_MLE_IN_Q);  }
}

/* equation inside answer */
<MLE_IN_A>{
       {RAnyCharWB}+					{  addToken( TOKEN_MLE_IN_A);  }
       {OpenBracket}                                     {  addToken( Token.SEPARATOR); addOpenBracket();}
       {CloseBracket}                                    {  addCloseBracket(); conditionalReturnToInitial(ADDA);}
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_MLE_IN_A)); return firstToken; }
        .					        {  addToken( TOKEN_MLE_IN_A);  }
}


/* question */
<ADDQ>{
       
       {MLEbegin}                                        {  beginMLE(MLE_IN_Q); }
       {OpenBracket}                                     {  addToken( Token.SEPARATOR); addOpenBracket();}
       {CloseBracket}                                    {  addCloseBracket(); conditionalReturnToInitial(ADDA);}
                                                          /*    after the question comes the answer    */
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_ADDQ)); return firstToken; }
        .					        {  addToken( TOKEN_ADDQ); }
}

/* answer */
<ADDA>{
       {MLEbegin}                                        {  beginMLE(MLE_IN_A); }
       {OpenBracket}                                     {  addToken( bracketCount == 0 ? TOKEN_ADDA : Token.SEPARATOR); addOpenBracket();}
       {CloseBracket}                                    {  addCloseBracket(); conditionalReturnToInitial(YYINITIAL);}
                                                          /*    after the answer comes the normal mode    */
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_ADDA)); return firstToken; }
        .					        {  addToken( TOKEN_ADDA); }
}


/* Hidden question */
<HIDDEN_ADDQ>{
       {RAnyCharWB}+					{  addToken( TOKEN_ADDQ_H);  }
       {OpenBracket}                                     {  addToken( TOKEN_ADDQ_H); addOpenBracket();}
       {CloseBracket}                                    {  addToken( TOKEN_ADDQ_H); addCloseBracket(); conditionalReturnToInitial(HIDDEN_ADDA);}
                                                          /*    after the question comes the answer mode    */
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_ADDQ_H)); return firstToken; }
        .					        {  addToken( TOKEN_ADDQ_H); }
}

/* Hidden answer */
<HIDDEN_ADDA>{
       {RAnyCharWB}+					{  addToken( TOKEN_ADDA_H);  }
       {OpenBracket}                                     {  addToken( TOKEN_ADDA_H); addOpenBracket();}
       {CloseBracket}                                    {  addToken( TOKEN_ADDA_H); addCloseBracket(); conditionalReturnToInitial(YYINITIAL);}
                                                          /*    after the answer comes the normal mode    */
        <<EOF>>					        {  addToken( getLastTokenVal(TOKEN_ADDA_H)); return firstToken; }
        .					        {  addToken( TOKEN_ADDA_H); }
}