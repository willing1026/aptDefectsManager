let main = {
    init: function() {
        let _this = this;
        
        /*내용등록 modal 창*/
        $('#btn-defects-save').on('click', function() {
            _this.save();
        });
        
        $('.btn-update').on('click', function(event) {
            _this.updateModal(event);
        });
        
        $('#btn-defects-update').on('click', function() {
//           _this.update();
            main.update();
        });
        
        $('.btn-delete').on('click', function() {
            _this.delete(event);
        })
        
        /*내용 수정 modal창*/
        /*$('#updateDefectsModal').on('show.bs.modal', function(event) {
            _this.updateModal(event);
        });*/
    },
    
    save: function() {
        let saveData= {
            aptCd: $('#aptCd').val(),
            roomType: $('#roomType').val(),
            content: $('#content').val(),
            userId: 'abc@gmail.com'
        };
        
        $.ajax({
            url: '/defects',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(saveData),
            success: function() {
                alert('등록완료');
                location.reload();
            },
            error: function(e) {
                alert('등록오류');
            }
        }).always(function() {
            location.reload();
        });
    },
    
    updateModal: function(event) {
        let button = $(event.target);
        let tr = button.parent().parent();
        let td = tr.children();
        
        console.log("클릭한 row의 모든 데이터 : " + tr.text());
        
        let no = td.eq(0).text();
        let aptCd = td.eq(1).text();
        let roomType = td.eq(2).text();
        let content = td.eq(3).text();
        
        let modal = $('#updateDefectsModal');
        modal.find('.modal-body input[id="no"]').val(no);
        modal.find('.modal-body input[id="aptCd2"]').val(aptCd);
        modal.find('.modal-body input[id="roomType2"]').val(roomType);
        modal.find('.modal-body textarea[id="content2"]').val(content);
    },
    
    update: function() {
        let updateData= {
            aptCd: $('#aptCd2').val(),
            roomType: $('#roomType2').val(),
            content: $('#content2').val()
        };
        
        console.log("aptCd : " + updateData.aptCd);
        console.log("no : " + $('#no').val());
        
        let url = "/defects/" + $('#no').val();
        
        $.ajax({
            url: url,
            type: 'PUT',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(updateData),
            success: function() {
                alert("수정완료")
            },
            error: function(e) {
                alert('등록오류');
            }
        }).always(function() {
            location.reload();
        });
    },
    
    delete: function(event) {
        let button2 = $(event.target);
        let tr2 = button2.parent().parent();
        let td2 = tr2.children();
        let no2 = td2.eq(0).text();
        let url2 = "/defects/"+no2;

        
        console.log("delete no : " + no2);
        
        $.ajax({
            url: url2,
            type: 'DELETE',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: no2,
            success: function() {
                alert('성공');
            },
            error: function(e) {
                alert('오류');
            }
        }).always(function() {
            location.reload();
        });
        
        
    }
    

    /* 미사용 - modal에 데이터를 띄우는 방법중 한가지 */
//    updateModal: function(event, td) {
        /*let button = $(event.relatedTarget);*/
        /*let no= button.data('whatever');*/
        
        /*let no = $('#btn-defects-update').val();*/
//        let no = $("button[name=btn-defects-update]").val();
//        let url = "/defects/" + no;
//        
//        console.log("no : " + no);
 
/*        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: no,
            success: function(data) {
                console.log(data);
                alert(data.aptCd);

                 this를 인식하지 못했었어,, this를 event.target 수정하니까 잘 됨
                여기서 this가 가리키는게 modal 이 아닌거 같다.
                
                + ajax안쪽으로 옮김 / 처리순서가 ajax가 가장 늦어서 불러온 값을 넣지 못함
                  DB에서 값을 먼저 불러오기 위해서 이렇게 처리
                  
                  이미 main페이지에서 list를 갖고 있을건데, thymeleaf 객체를 이쪽으로 넘기는 방법을 모르겠다.
                  ->그래서 ajax로 데이터 DB에서 조회해옴
                
                let modal=$(event.target);
                modal.find('.modal-body input[id="aptCd"]').val(data.aptCd);
                modal.find('.modal-body input[id="roomType"]').val(data.roomType);
                modal.find('.modal-body textarea[id="content"]').val(data.content);
            },
            error: function(e) {
                alert('로딩오류');
            }
        })
        
        console.log("apt : " + aptCd);*/

        /* this를 인식하지 못했었어,, this를 event.target 수정하니까 잘 됨
            여기서 this가 가리키는게 modal 이 아닌거 같다.
        */
//        let aptCd = td.eq(1).text();
//        let roomType = td.eq(2).text();
//        let content = td.eq(3).text();       
//      
//        let modal=$(event.target);
//        modal.find('.modal-body input[id="aptCd"]').val(aptCd);
//        modal.find('.modal-body input[id="roomType"]').val(roomType);
//        modal.find('.modal-body textarea[id="content"]').val(content);
//    }
}

main.init();