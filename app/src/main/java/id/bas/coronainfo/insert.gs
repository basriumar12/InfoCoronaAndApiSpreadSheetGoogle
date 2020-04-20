function doPost(e) {
  var ss = SpreadsheetApp.openById("1EvpbuSl7rXFiD1th3Rru5PqHcHrk7AS0Y5L3LT8yZtw");
  var sheetName = e.parameter.sheetName;
  var sheet = ss.getSheetByName(sheetName);

  var action = e.parameter.action;

  switch (action){

    case "register":
      return register(e, sheet);
      break;

        case "id":
      return id(e, sheet);
      break;




  }
}


function register(request, sheet){

  var positif = request.parameter.positif;
  var meninggal = request.parameter.meninggal;
  var sembuh = request.parameter.sembuh;
  var flag = 0;

      sheet.appendRow([sheet.getLastRow(),positif,meninggal,sembuh]);


  if (flag == 0){
    var hasil = "sukses";
  }

  var output = JSON.stringify(
    {
      "hasil" : hasil
    }
  );

  return ContentService.createTextOutput(output).setMimeType(ContentService.MimeType.JSON);
}

function id(request, sheet){
  var no = request.parameter.no;

  var flag = 0;
  var positif = "";
  var meninggal ="";
  var sembuh ="";

  for (var row=1; row<=sheet.getLastRow();row++){
    var noS = sheet.getRange(row, 1).getValue();
    var positiff = sheet.getRange(row, 2).getValue();


    if (no == noS){
      flag = 1;
           positif = positiff;
       meninggal = sheet.getRange(row, 3).getValue();
      sembuh = sheet.getRange(row, 4).getValue();


    }
  }

  if (flag == 0){
    var hasil = "gagal";
  }else{
    var hasil = "sukses";
  }

  var output = JSON.stringify(
    {
      "hasil" : hasil,
      "positif" : positif,
            "meninggal" : meninggal,
      "sembuh" : sembuh,



    }
  );

  return ContentService.createTextOutput(output).setMimeType(ContentService.MimeType.JSON);
}

