let count = 0;
$("#fileAdd").click(function () {
  if (count < 5) {
    let add = "<div>";
    add = add + '<input type="file" name="files"/>';
    add =
      add +
      '<button class="del btn btn-outline-danger me-2" type="button">X</button>';
    add = add + "</div>";
    $("#files").append(add);
    count++;
  } else {
    alert("최대 5개만 가능합니다.");
  }
});

// $("#files").click(function (event) {
//   if (event.target.classList[0] == "del") {
//     console.log("delete");
//   }
// });

$("#files").on("click", ".del", function () {
  $(this).parent().remove();
  count--;
});

$(".deleteFile").click(function () {
  //DB,Hdd에 파일삭제
  let check = confirm("삭제됩니다.");
  if (check) {
    //속성값보내기
    let fileNum = $(this).attr("data-file-num");
    console.log("Before Result This : ", $("this"));
    const btn = $(this);
    $.ajax({
      type: "POST",
      url: "delete",
      data: {
        fileNum: fileNum,
      },
      success: function (result) {
        alert("삭제 성공");
        $(btn).parent().remove();
        window.location.reload();
      },
    });
  }
});
