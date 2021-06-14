package com.webprj.project_green.service;

public class BoardServiceImpl {

    @Override
    public int getBoardLike(BoardLikeVO vo) throws Exception {
        return session.selectOne(boardLike+".getBoardLike",vo);
    }

    @Override
    public void insertBoardLike(BoardLikeVO vo) throws Exception {
        session.insert(boardLike+".createBoardLike",vo);
    }

    @Override
    public void deleteBoardLike(BoardLikeVO vo) throws Exception {
        session.delete(boardLike+".deleteBoardLike",vo);
    }

    @Override
    public void updateBoardLike(int boardId) throws Exception {
        session.update(boardLike+".updateBoardLike",boardId);
    }

}
