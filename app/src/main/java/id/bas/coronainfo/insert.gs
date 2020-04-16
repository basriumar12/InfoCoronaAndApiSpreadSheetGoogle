function doPost(e) {
  var ss = SpreadsheetApp.openById("1EvpbuSl7rXFiD1th3Rru5PqHcHrk7AS0Y5L3LT8yZtw");
  var sheetName = e.parameter.sheetName;
  var sheet = ss.getSheetByName(sheetName);

  var action = e.parameter.action;

  switch (action){

    case "register":
      return register(e, sheet);
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

