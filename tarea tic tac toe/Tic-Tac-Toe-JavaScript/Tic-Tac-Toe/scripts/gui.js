var Gui = function() {

  /*
   * places X or O in the specifed place in the board
   * @param i [Number] : row number (0-indexed)
   * @param j [Number] : column number (0-indexed)
   * @param symbol [String]: X or O
   */
  this.insertAt = function(indx, symbol) {
    //get board instance as an array of cells
    var board = $('.cell');
    //get clicked cell in the board
    var targetCell = $(board[indx]);
    //Check target cell has not been marked
    if (!targetCell.hasClass('occupied')) {
      //"Draw" an styled X/O to the target cell plus add 'occupied' class
      targetCell.html(symbol);
      targetCell.css({
        color: symbol == "X" ? "green" : "red"
      });
      targetCell.addClass('occupied');
    }
  }

  this.start = function() {
    $('.control').fadeOut(1000);
    setTimeout(function(){
      $('.invisible').addClass('visible');
      $('.visible').removeClass('invisible');
    }
      , 1000);
  }

  this.clearBoard = function(){
    var board = $('.cell');
    console.log(board);
    for (var i = 0; i < board.length; i++) {
      var targetCell =  $(board[i]);
      if (targetCell.hasClass('occupied')) {
        targetCell.removeClass('occupied');
        targetCell.html("");
      }
    }

    setTimeout(function(){
      $('.visible').addClass('invisible');
      $('.invisible').removeClass('visible');
    }
      , 0);
        $('.control').fadeIn(1000);
  }
}
