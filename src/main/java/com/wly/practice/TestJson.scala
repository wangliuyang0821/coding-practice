package com.wly.practice


import java.util.UUID
import com.alibaba.fastjson.{JSON, JSONObject}

object TestJson {
  def main(args: Array[String]): Unit = {
    val json =
      """
        |{
        |   "DataSource":"c4c",
        |   "ObjectName":"visit",
        |   "RowCount":1,
        |   "RowData":{
        |      "visitEOS":[
        |         {
        |            "displayId":"7785",
        |            "id":"0AF6152FC55D1EDBBF8318D4AF2F71A5",
        |            "salesRep":"8000000900",
        |            "visitLists":[
        |               {
        |                  "id":"0AF6152FC55D1EDBBF8318D4AF2F71A5",
        |                  "visitPlans":[
        |                     {
        |                        "customerId":"20040",
        |                        "distributionChannel":"01",
        |                        "division":"",
        |                        "endDateTime":"2022-01-01T10:00:00.000",
        |                        "endDatetimeZoneCode":"BRZLWE",
        |                        "id":"0AF6152FC55D1EDBBF8318D4AF2F71A5",
        |                        "location":"The Electronic Store- Egelsbach / Schwarzwald Strasse 104 / 63329 Egelsbach / DE",
        |                        "mainContactId":"1000583",
        |                        "organizerId":"8000000009",
        |                        "priority":"3",
        |                        "salesOrganizationId":"US1100",
        |                        "salesTerritoryId":"15",
        |                        "startDateTime":"2022-01-01T09:30:00.000",
        |                        "startDatetimeZoneCode":"BRZLWE",
        |                        "subject":"#New Visit for 20220101",
        |                        "visitPlanType":"ZPRE",
        |                        "visitStatus":"1"
        |                     }
        |                  ]
        |               }
        |            ]
        |         }
        |      ]
        |   },
        |   "TenantID":"5003"
        |}
        |""".stripMargin
    val input = JSON.parseObject(json)

    val newColumn= input.getString("TenantID") +"_"+ input.getString("DataSource")  +"_"+ input.getString("ObjectName")
    val visitEOS = JSON.parseObject(input.getString("RowData")).getString("visitEOS")
    val visitEOSArray = JSON.parseArray(visitEOS)
    println(visitEOSArray)
    for(i <- 0 to visitEOSArray.size - 1){
      val temp = JSON.parseObject(visitEOSArray.get(i).toString)
      temp.put("uuid",UUID.randomUUID.toString)
      val visitLists = JSON.parseArray(temp.getString("visitLists"))
      for(j <- 0 to visitLists.size() - 1){
        val listTemp = JSON.parseArray(visitLists.get(j).toString)
        for(h <- 0 to listTemp.size() - 1){
          JSON.parseObject(listTemp.get(h).toString).put("",newColumn)
        }
      }
    }

    println(input)


  }
}
