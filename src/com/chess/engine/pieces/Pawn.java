package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece{

    private final static int[] CANDIDATE_MOVE_COORDINATE= {8};



    Pawn(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();
        for(final int currentCanidateOffset : CANDIDATE_MOVE_COORDINATE) {
            int candidateDestinationCoordinate = this.piecePosition + (this.getPieceAlliance().getDirection() * currentCanidateOffset);

            if(!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                continue;
            }

            //
            if(currentCanidateOffset == 8 && board.getTile(candidateDestinationCoordinate).isTileOccupied()){
                //TODO more work to do here -- stubbed out currently!
                legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
            }
        }

        return legalMoves;
    }
}