package ru.shemplo.scanner;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import lombok.Setter;

public final class FastScanner implements IFastScanner {
    
    private final Reader reader;
    
    public FastScanner (InputStream is, Charset charset) throws IOException {
        if (charset == null || !StandardCharsets.UTF_8.equals (charset)) {
            var reader = new InputStreamReader (is, charset);
            this.reader = new BufferedReader (reader);
        } else {
            this.reader = new UTF8Reader (is);
        }
    }
    
    public FastScanner (String string) {
        this.reader = new StringReader (string);
    }
    
    @Override
    public void close () {
        try   { reader.close (); } 
        catch (IOException ioe) {
            throw new RuntimeException (ioe);
        }
    }
    
    private int linesSkipped = 0, previousCharacter;
    private String token = "";
    
    private void _readToken () throws IOException {
        if (token.length () > 0) { return; }
        linesSkipped = previousCharacter == '\n' ? 1 : 0;
        
        StringBuilder tokenSB = new StringBuilder ();
        boolean isToken = false;
        int charachter = -1;
        
        while ((charachter = reader.read ()) != -1) {
            if (Character.isWhitespace (charachter)) {
                if (charachter == '\n' && !isToken) {
                    linesSkipped++;
                }
                
                previousCharacter = charachter;
                if (isToken) { break; } // token is read
            } else {
                tokenSB.append ((char) charachter);
                isToken = true;
            }
            
            previousCharacter = charachter;
        }
        
        token = tokenSB.toString ();
    }

    @Override
    public boolean hasNext () throws IOException {
        _readToken ();
        return token.length () > 0;
    }

    @Override
    public boolean hasNextInLine () throws IOException {
        return hasNext () && linesSkipped == 0;
    }

    @Override
    public boolean hasNextInt (int radix) throws IOException {
        if (!hasNext ()) { return false; }
        try {
            Integer.parseInt (token, radix);
        } catch (NumberFormatException nfe) {
            return false;
        }
        
        return true;
    }

    @Override
    public boolean hasNextLong (int radix) throws IOException {
        if (!hasNext ()) { return false; }
        try {
            Long.parseLong (token, radix);
        } catch (NumberFormatException nfe) {
            try {
                Long.parseUnsignedLong (token, radix);
            } catch (NumberFormatException nfe2) {                
                return false;
            }
        }
        
        return true;
    }

    @Override
    public String next () throws IOException {
        if (hasNext ()) {
            String out = token;
            token = "";
            return out;
        } else {
            throw new IOException ("EOF reached");
        }
    }
    
    @Override
    public String nextLine () throws IOException {
        StringBuilder sb = new StringBuilder ();
        
        int character = -1;
        while ((character = reader.read ()) != -1) {
            if (character == '\n') { break; }
            sb.append ((char) character);
        }
        
        previousCharacter = -1;
        return sb.toString ();
    }

    @Override
    public int nextInt (int radix) throws IOException {
        if (hasNextLong (radix)) {
            return Integer.parseInt (next (), radix);
        } else {
            String message = "Next token is absent or non-integer";
            throw new IOException (message);
        }
    }

    @Override
    public long nextLong (int radix) throws IOException {
        if (hasNextLong (radix)) {
            return Long.parseLong (next (), radix);
        } else {
            String message = "Next token is absent or non-long";
            throw new IOException (message);
        }
    }

    @Override
    public long nextUnsignedLong (int radix) throws IOException {
        if (hasNextInt (radix)) {
            return Long.parseUnsignedLong (next (), radix);
        } else {
            String message = "Next token is absent or non-unsigned long";
            throw new IOException (message);
        }
    }

    @Setter
    private Pattern wordPattern;

    @Override
    public boolean hasNextWord () throws IOException {
        if (!hasNext ()) { return false; }
        
        if (wordPattern == null) { return true; }
        return wordPattern.matcher (token).find ();
    }
    
}
