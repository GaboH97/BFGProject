/*
  This object manages all internal logic of the Tic Tac Toe of the game.
  Allows user to play in single mode (vs PC AI ) or 2-player mode. AI mode
  implements minimax algorithm to find the most optimal move given the game's
  current state.
*/

var TicTacToe = function() {

  //If player
  /*if (typeof robotPlayer !== "undefined") {
    this.robotPlayer = robotPlayer;
  }*/

  this.gameModeAuto = false;
  this.location = -1;

  this.emptyChar = "E";
  //Creates representation of empty board
  this.board = [
    this.emptyChar, this.emptyChar, this.emptyChar,
    this.emptyChar, this.emptyChar, this.emptyChar,
    this.emptyChar, this.emptyChar, this.emptyChar
  ];

  // "X" Player plays first
  this.currentTurn = "X";

  this.isPlaying = false;

  this.advanceTurn = function() {
    this.currentTurn = this.currentTurn === "X" ? "O" : "X";
  }

  this.clearBoard = function() {
    for (var i = 0; i<this.board.length; i++) {
      this.board[i] = this.emptyChar;
    }
  }

  this.start = function() {
    this.isPlaying = true;
  }

  this.stop = function() {
    this.isPlaying = false;
  }

  /*
   * public  function that checks if the state is a terminal state or not
   * the state result is updated to reflect the result of the game
   * @returns [Boolean]: true if it's terminal, false otherwise
   */

  this.isWinningMove = function() {
    var auxBoard = this.board;
    for (var i = 0; i <= 6; i = i + 3) {//Check winning move on rows every i+3 index until position 6 ([3,1])
      if (auxBoard[i] !== this.emptyChar && auxBoard[i] === auxBoard[i + 1] && auxBoard[i + 1] == auxBoard[i + 2]) {//Check winning move on rows every i+3 index until position 6 ([3,1])
        return true;
      }
    }
    for (var i = 0; i <= 2; i++) {//Check winning move on columns every i+3 index until position 2 ([1,3])
      if (auxBoard[i] !== this.emptyChar && auxBoard[i] === auxBoard[i + 3] && auxBoard[i + 3] === auxBoard[i + 6]) {
         return true;
      }
    }
    if ((auxBoard[0] != this.emptyChar && auxBoard[0] === auxBoard[4] && auxBoard[4] === auxBoard[8]) ||
      auxBoard[2] != this.emptyChar && auxBoard[2] === auxBoard[4] && auxBoard[4] === auxBoard[6]) {  //Check winning move gonals
      return true;
    }
  }

  this.checkRow = function(row){
    var counterAux = 0;
    var auxBoard = this.board;
    for (var i = (row-1)*3; i < ((row-1)*3)+3; i++) {
      if (auxBoard[i] === 'X'){
        counterAux++;
      }else {
        this.location = i;
      }
    }
    if (counterAux != 2) {
      this.location = -1;
    }
  }

  this.checkCol = function(col){
    var counterAux = 0;
    var auxBoard = this.board;
    for (var i = col; i <= 6+col; i+=3) {
      if (auxBoard[i] === 'X'){
        counterAux++;
      }else {
        this.location = i;
      }
    }
    if (counterAux != 2) {
      this.location = -1;
    }
  }

  this.checkDiagonalLeft = function(){
    var counterAux = 0;
    var auxBoard = this.board;
    //(auxBoard[0] != this.emptyChar && auxBoard[0] === auxBoard[4] && auxBoard[4] === auxBoard[8])
    for (var i = 0; i <= 8; i+=4) {
      if (auxBoard[i] === 'X'){
        counterAux++;7
      }else {
        this.location = i;
      }
    }
    if (counterAux != 2) {
      this.location = -1;
    }
  }

  this.checkDiagonalright = function(){
    var counterAux = 0;
    var auxBoard = this.board;
    //(auxBoard[0] != this.emptyChar && auxBoard[0] === auxBoard[4] && auxBoard[4] === auxBoard[8])
    for (var i = 2; i <= 6; i+=2) {
      if (auxBoard[i] === 'X'){
        counterAux++;7
      }else {
        this.location = i;
      }
    }
    if (counterAux != 2) {
      this.location = -1;
    }
  }

}
