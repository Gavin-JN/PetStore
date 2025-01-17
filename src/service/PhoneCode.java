//package service;
//
//import com.aliyunc.CommonRequest;
//import com.aliyuncs.CommonResponse;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.http.MethodType;
//import com.aliyuncs.profile.DefaultProfile;
//
//
//public class PhoneCode {
//    //下面sendCode是阿里云发送短信的方法
//    public static void sendCode(String phone, String code) {
//
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<AccessKeyID>", "<AccessKeySecret>");
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        request.putQueryParameter("PhoneNumbers", phone);
//        request.putQueryParameter("SignName", "<短信签名>");
//        request.putQueryParameter("TemplateCode", "<短信模板>");
//        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
//    }
//    //获得验证码的工具类,这里随机获得了随机的六位数字验证码
//    public static String getCode() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; sb.length() < 6; i++) {
//            int num = new Random().nextInt(10);
//            sb.append(num);
//        }
//        return sb.toString();
//    }
//}
