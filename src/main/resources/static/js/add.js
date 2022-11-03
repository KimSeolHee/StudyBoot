$("#all").click(function () {
  let ch = $(this).prop("checked");
  $(".check").prop("checked", ch);
});

$(".check").click(function () {
  let flag = true;
  $(".check").each(function (idx, items) {
    let ch = $(items).prop("checked");
    if (!ch) {
      flag = false;
    }
  });

  $("#all").prop("checked", flag);
});

let results = [false, false, false, false, false];

// $("#id").blur(function () {
//   let result = nullcheck($("#id").val().trim());
//   if (result == true) {
//     $("#id_text").html("");
//     let id = $("#id").val().trim();
//     const xhttp = new XMLHttpRequest();
//     xhttp.open("GET", "./idCheck?id=" + id);
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttp.send();
//     xhttp.onreadystatechange = function () {
//       if (this.readyState == 4 && this.status == 200) {
//         if (this.responseText.trim() == 0) {
//           $("#id_text").html("");
//         } else {
//           $("#id_text").html("중복된 값입니다.");
//         }
//       }
//     };
//   } else {
//     $("#id_text").html("아이디는 필수입니다.");
//   }
//   results[0] = result;
// });

//제이쿼리로 보내기
$("#id").blur(function () {
  let id = $("#id").val().trim();
  let result = nullcheck($("#id").val().trim());
  if (result == true) {
    $("#id_text").html("");
    $.get("./idCheck?id=" + id, function (data) {
      console.log("data : " + data);
      if (data == 0) {
        $("#id_text").html("");
      } else {
        $("#id_text").html("이미 사용중인 아이디입니다.");
      }
    });
  } else {
    $("#id_text").html("아이디는 필수입니다.");
  }
  results[0] = result;
});

$("#pw").blur(function () {
  let result = nullcheck($("#pw").val().trim());
  if (result == true) {
    $("#pw_text").html("");
  } else {
    $("#pw_text").html("패스워드 입력은 필수입니다.");
  }
  results[1] = result;
});

$("#pwCheck").blur(function () {
  let result = equals($("#pw").val(), $("#pwCheck").val());
  if (result == true) {
    $("#pw2_text").html("");
  } else {
    $("#pw2_text").html("패스워드가 다릅니다.");

    $("#pw").blur(function () {
      if ($("#pwCheck").val() != $("#pw").val()) {
        $("#pw2_text").html("패스워드가 다릅니다.");
      } else {
        $("#pw2_text").html("");
      }
    });
  }
  results[2] = result;
});

$("#name").blur(function () {
  let result = nullcheck($("#name").val().trim(), "#name_text", "name");
  results[3] = result;
});

$("#email").blur(function () {
  let result = nullcheck($("#email").val().trim());
  if (result == true) {
    $("#email_text").html("");
  } else {
    $("#email_text").html("이메일입력은 필수입니다.");
  }
  results[4] = result;
});

$("#s_btn").click(function () {
  if (results.includes(false)) {
    alert("필수입력은 다 해야합니다.");
  } else {
    alert("전송");
  }
  //   let c = true;
  //   $.each(results, function (idx, item) {
  //     if (!item) {
  //       alert("필수입력은 다 해야합니다.");
  //       c = false;
  //       return false;
  //     }
  //   });
  //   if (c) {
  //     $("#join_form").submit();
  //   }
});

$("#test").click(function () {
  let id = "123";
  let name = "iu";

  $.post(
    "test",
    {
      id: id,
      name: name,
    },
    function (result) {
      console.log("result", result);
      result = JSON.parse(result);
      console.log("Name : ", result.name);
    }
  );
});

$("#test2").click(function () {
  let id = "abcd";
  $.ajax({
    type: "GET",
    url: "idCheck",
    data: {
      id: id,
    },
    success: function (data) {
      console.log("Data : ", data);
    },
    error: function (xhr, status, error) {
      console.log("XHR :", xhr);
      console.log("status :", status);
      console.log("error :", error);
    },
  });
});

$("#test3").click(function () {
  let id = "1234";
  let name = "iu";
  let ar = [1, 2, 3];
  $.ajax({
    type: "POST",
    url: "test",
    traditional: true, //배열을 전송할 때 사용
    data: {
      id: id,
      name: name,
      ar: ar
    },
    success: function (result) {
      console.log(result);
    },
  });
});
let count = 3;
// $("#s1Add").click(function () {
//   let add = '<option class="abc" id="abc' + count + '">' + count + "</option>";
//   $("#s1").append(add);
//   count++;
// });

$("#s1").click(function () {
  $("#s1").empty();
});
