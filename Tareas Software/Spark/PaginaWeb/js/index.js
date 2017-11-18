$(document).ready(function() {
var state="students";
addStudents();

$('#add').on('click',function (){
    if(state=='students'){
        location.href ="add/indexStudents.html";
    }else if(state=='trainers'){
        location.href ="add/indexTrainner.html";
    }else{
        location.href ="add/indexTransactions.html";
    }
});

$('#btn-students').on('click',function (){
    addStudents();
});

$('#btn-trainers').on('click',function (){
    addTrainers();
});

$('#btn-movements').on('click',function (){
    addMovements();
});

$('#add-student').on('click',function(e){
    e.preventDefault();
    $.ajax({
            url: 'http://localhost:8181/student',
            method: "POST",
            dataType: 'json',
            data:$('#form-student').serializeFormJSON(),
            success: function(result){
                if(result=='ok'){
                  $("#alert").html("");
                  $("#alert").append('<div class="alert alert-success"><strong>Success!  </strong>'+result+'</div>');
                  setTimeout(function(){
                      location.href ="../index.html";
                    }
                      , 1000);
                }else{
                    $("#alert").html("");
                    $("#alert").append('<div class="alert alert-danger"><strong>Danger!  </strong>'+result+'</div>');
                }
            },
            error: function(er){
                $("#alert").append('<div class="alert alert-danger"><strong>Danger!</strong>'+er+'</div>');
            }
    });
});

$('#add-trainner').on('click',function(e){
    e.preventDefault();
    $.ajax({
            url: 'http://localhost:8181/trainner',
            method: "POST",
            dataType: 'json',
            data:$('#form-trainer').serializeFormJSON(),
            success: function(result){
                if(result=='ok'){
                  $("#alert").html("");
                  $("#alert").append('<div class="alert alert-success"><strong>Success!  </strong>'+result+'</div>');
                  setTimeout(function(){
                      location.href ="../index.html";
                    }
                      , 1000);
                }else{
                    $("#alert").html("");
                    $("#alert").append('<div class="alert alert-danger"><strong>Danger!  </strong>'+result+'</div>');
                }
            },
            error: function(er){
                $("#alert").append('<div class="alert alert-danger"><strong>Danger!</strong>'+er+'</div>');
            }
    });
});

$('#add-movement').on('click',function(e){
    e.preventDefault();
    $.ajax({
            url: 'http://localhost:8181/movement',
            method: "POST",
            dataType: 'json',
            data:$('#form-movement').serializeFormJSON(),
            success: function(result){
                if(result=='ok'){
                  $("#alert").html("");
                  $("#alert").append('<div class="alert alert-success"><strong>Success!  </strong>'+result+'</div>');
                  setTimeout(function(){
                      location.href ="../index.html";
                    }
                      , 1000);
                }else{
                    $("#alert").html("");
                    $("#alert").append('<div class="alert alert-danger"><strong>Danger!  </strong>'+result+'</div>');
                }
            },
            error: function(er){
                $("#alert").append('<div class="alert alert-danger"><strong>Danger!</strong>'+er+'</div>');
            }
    });
});

    function addStudents(){
        $.ajax({
            url: 'http://localhost:8181/students',
            dataType: 'json',
            success: function(data){
              $('#table').html('');
              $('#table').append('<thead><tr> <th>Identification</th><th>Name</th><th>Phone</th> <th>email</th><th>Image</th></tr></thead><tbody>');
             var bodyTable='';
              for (var i = 0; i < data.length; i++) {
                 var element = data[i];
                 bodyTable+='<tr><th>'+element.identification+'</th><td>'+element.name+'</td><td>'+element.phone+'</td><td>'+element.eMail+'</td><td><img src="'+element.imgURL +'" alt="" class="img-responsive img-circle" ></td></tr>';
             }
             $('#table').append(bodyTable);
             $('#title').html('');
             $('#title').append('Students');
             state="students";
             $('#btn-students').addClass('active');
             $('#btn-trainers').removeClass('active');
             $('#btn-movements').removeClass('active');

            }
        });
    }

    function addTrainers(){
        $.ajax({
            url: 'http://localhost:8181/trainners',
            dataType: 'json',
            success: function(data){
              $('#table').html('');
              $('#table').append('<thead><tr> <th>Identification</th><th>Name</th><th>Phone</th> <th>email</th><th>Programs</th><th>Image</th></tr></thead><tbody>');
             var bodyTable='';
              for (var i = 0; i < data.length; i++) {
                 var element = data[i];
                 bodyTable+='<tr><th>'+element.identification+'</th><td>'+element.name+'</td><td>'+element.phone+'</td><td>'+element.eMail+'</td><td>'+element.programs+'</td><td><img src="'+element.imgURL +'" alt="" class="img-responsive img-circle" ></td></tr>';
             }
             $('#table').append(bodyTable);
             $('#title').html('');
             $('#title').append('Trainers');
             state="trainers";
             $('#btn-students').removeClass('active');
             $('#btn-trainers').addClass('active');
             $('#btn-movements').removeClass('active');

            }
        });
    }

    function addMovements(){
        $.ajax({
            url: 'http://localhost:8181/movements',
            dataType: 'json',
            success: function(data){
              $('#table').html('');
              $('#table').append('<thead><tr> <th>Id</th><th>Type</th><th>Movement date</th> <th>Value</th><th>Description</th></tr></thead><tbody>');
             var bodyTable='';
              for (var i = 0; i < data.length; i++) {
                 var element = data[i];
                 bodyTable+='<tr><th>'+element.id+'</th><td>'+element.tipo+'</td><td>'+element.movement_date+'</td><td>'+element.value+'</td><td>'+element.value +'</tr>';
             }
             $('#table').append(bodyTable);
             $('#title').html('');
             $('#title').append('Movements');
             state="movements";
             $('#btn-students').removeClass('active');
             $('#btn-trainers').removeClass('active');
             $('#btn-movements').addClass('active');
            }
        });
    }
    (function ($) {
        $.fn.serializeFormJSON = function () {

            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })(jQuery);
});
