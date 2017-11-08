var Result = function() {

  this.showResult = function(result) {
    $('.popup-wrap').fadeIn(250);
    $('.popup-box').removeClass('transform-out').addClass('transform-in');
    $('#result').html("the result is: " + result);
  }

    $('.popup-close').click(function() {
    $('.popup-wrap').fadeOut(500);
    $('.popup-box').removeClass('transform-in').addClass('transform-out');
  });
}
