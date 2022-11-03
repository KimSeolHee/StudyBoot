function nullcheck(data, text, kind) {
  if (data == null || data == "") {
    $(text).html(kind + "(는)은 필수입니다.");
    return false;
  } else {
    $(text).html("");
    return true;
  }
}

function equals(data, checkData) {
  if (data == checkData) {
    return true;
  } else {
    return false;
  }
}
