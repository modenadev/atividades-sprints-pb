package chess;

import boardgame.BoardExcpetion;

public class ChessException extends BoardExcpetion {
    private static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }

}
