function detail(){
const data={
    "id":$('#id').val()
    };
    $.ajax({
        type:'post', //방식
        url:'/ajax/detail',// 요청 url
        data:data,
        success:function(res){ // 성공
            const rs=res;// 서버에서 전송
            console.log(typeof rs);
            if(rs==undefined||rs==null||rs==""){
                alert("조회할 데이터가 없습니다. 다시 조회해주세요.")
                $('#id').focus();
                return false;
            }
            console.log(rs);
                let tag="<tr>";
                    tag+="<td>"+rs.id+"</td>";
                    tag+="<td>"+rs.userName+"</td>";
                    tag+="<td>"+rs.userPw+"</td>";
                tag+="</tr>";
            $('#detail tbody').html(tag);
            //$('#detail tbody').append(tag); // 기존 조회내역남기고 새로 업데이트
        },
        error:function(){
            console.log('실패');
        }
    })
}
$('#ajaxBtn').on('click',function(){
    detail();
})