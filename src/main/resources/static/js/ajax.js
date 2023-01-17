$('#btn1').on('click',ajaxFn1);
function ajaxFn1(){
    $.ajax({
        type:'get',
        url:'/ajax/ajax1',
        success:function(res){
            console.log('성공')
            console.log('반환-> '+res);
        },
        error:function(){
            console.log('실패')
        }
    })
}
$('#btn2').on('click',ajaxFn2);
function ajaxFn2(){
    $.ajax({
        type:'post',
        url:'/ajax/ajax2',
        success:function(res){
            console.log('성공')
            console.log('반환-> '+res)
        },
        error:function(){
            console.log('실패')
        }
    })
}
$('#btn3').on('click',ajaxFn3);
function ajaxFn3(){
    const data={
        'userName':'m1',
        'userPw':'11'
        };
    $.ajax({
        type:'post',
        url:'/ajax/ajax3',
        data:data,
        success:function(res){
            console.log('성공')
            console.log('반환-> '+res)
        },
        error:function(){
            console.log('실패')
        }
    })
}
$('#btn4').on('click',ajaxFn4);
function ajaxFn4(){
    const data={
        //'id':0,
        'userName':'m1',
        'userPw':'11'
        };
    $.ajax({
        type:'post',
        url:'/ajax/ajax4',
        data:data,
        success:function(res){
            console.log('성공')
            console.log('반환-> '+res)
            console.log('번호: '+res.id);
            console.log('이름: '+res.userName);
            console.log('비밀번호: '+res.userPw);
        },
        error:function(){
            console.log('실패')
        }
    })
}
$('#joinOkBtn').on('click',joinFn);
function joinFn(){
    const data={
        'userName':$('#userName').val(), // userName의 값을 불러온다.
        'userPw':$('#userPw').val()
        };
    $.ajax({
        type:'post',
        url:'/ajax/memberJoin',
        data:data,
        success:function(res){
            if(res==1){
                alert('회원가입 성공')
            }else{
                alert('회원가입 실패')
            }
        },
        error:function(){
            console.log('실패')
        }
    })
}
$('#nameChecked').on('click',nameCheckedFn);
function nameCheckedFn(){
    const data={
        'userName':$('#userName').val() // nameChecked의 값을 불러온다.
        };
    $.ajax({
        type:'post',
        url:'/ajax/nameChecked',
        data:data,
        success:function(res){
            if(res==1){
                alert('사용가능한 이름입니다.')
            }else{
                alert('사용할 수 없는 이름입니다.')
            }
        },
        error:function(){
            console.log('실패')
        }
    })
}





