function list(){
    $.ajax({
        type:'get', //방식
        url:'/ajax/memberList2',// 요청 url
        success:function(res){ // 성공
            const rs=res;// 서버에서 전송

            let tag="";
            rs.forEach(function(el){
                tag+="<tr>";
                    tag+="<td>"+el.id+"</td>";
                    tag+="<td>"+el.userName+"</td>";
                tag+="</tr>";
                //$('#list').append(tag);
            });
            $('#list tbody').html(tag);
        },
        error:function(){
            console.log('실패');
        }
    })
}
$('#ajaxBtn').on('click',function(){
    list();
});