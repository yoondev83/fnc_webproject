function joinInfoCheck(){
    var idRegExpres = /^[a-zA-Z0-9]{4,12}$/;
    var pwRegExpres = /^[a-zA-Z0-9]{6,18}$/;
    // var emailRegExpress = /%^[a-zA-Z0-9*[@]{1}][a-zA-Z0-9][.]{1}[a-zA-Z0-9]{1,4}$/;
    var emailRegExpress = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    var nameKorRegExpress  = /^[가-힣]{2,4}$/;  
    var phoneRegExpress = /[0-9]{11}$/;


    if(!idRegExpres.test(document.join_form.id.value)){
        alert("아이디는 영문과 숫자 조합으로 4-12자리로 입력해야 합니다.");
        join_form.id.focus();
        return false;
    }


    if(!pwRegExpres.test(document.join_form.password.value)){
        alert("비밀번호는 최소 6자 이상 최대 18자 입니다.");
        join_form.pw.focus();
        return false;
    }

    if(document.join_form.password.value != document.join_form.pw_check.value){
        alert("비밀번호가 일치하지 않습니다.");
        join_form.pw.focus();
        return false;
    }

    
    if(!nameKorRegExpress.test(document.join_form.name.value)){
        alert("이름이 옳바르지 않습니다.");
        join_form.name.focus();
        return false;
    }
    if(!emailRegExpress.test(document.join_form.email.value)){
        alert("이메일 양식이 옳바르지 않습니다.");
        join_form.email.focus();
        return false;
        
    }
    if(document.join_form.email.value.length==0){
        alert("이메일은 입력 부탁드립니다.");
        join_form.email.focus();
        return false;
        
    }

    if(!phoneRegExpress.test(document.join_form.phone.value)){
        alert("-없이 핸드폰 번호 숫자만 입력 부탁드립니다.");
        join_form.phone.focus();
        return false;
    }

    document.join_form.submit();
}