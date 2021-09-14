import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/19
 * @备注:
 */
public class testJsonObject {
    public static void main(String[] args) {
        String str = "{\"msg\":\"{\\\"body\\\":{\\\"createTime\\\":1626428677580,\\\"currency\\\":\\\"CNY\\\",\\\"datachange_Lasttime\\\":1626428677580,\\\"liningPrice\\\":0.0,\\\"price\\\":0.0,\\\"productId\\\":6592008,\\\"productPriceInfoId\\\":0,\\\"startCity\\\":2,\\\"takeoffDate\\\":1626451200000,\\\"tradePrice\\\":0.0,\\\"vbkLastMsg\\\":false,\\\"vendorId\\\":0},\\\"status\\\":2}\"}";
        JSONObject json = JSON.parseObject(str);
        JSONObject res = new JSONObject();

        System.out.println(json.toString());
        JSONObject temp = json.getJSONObject("msg");
        System.out.println(temp);
        String status = temp.getString("status");
        System.out.println(status);
        JSONObject body = temp.getJSONObject("body");
        System.out.println(body);
        res.put("status",status);

        for(String s : body.keySet()){
            res.put(s.toLowerCase(),body.getString(s));
        }
        System.out.println(res);
    }
}
