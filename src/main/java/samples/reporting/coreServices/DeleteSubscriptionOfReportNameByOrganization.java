package samples.reporting.coreServices;

import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.ReportSubscriptionsApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;

public class DeleteSubscriptionOfReportNameByOrganization {
	
	
	private static String reportName = "Dexa";
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;
	
	public static void main(String args[]) throws Exception {
		process(reportName);
	}
    
	public static void process(String reportName) throws Exception {
	
	try {
		/* Read Merchant details. */
		merchantProp = Configuration.getMerchantDetails();
		MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
		ApiClient.merchantConfig = merchantConfig;	
		
		ReportSubscriptionsApi reportSubscriptionsApi=new ReportSubscriptionsApi();
		reportSubscriptionsApi.deleteSubscription(reportName);
		
		responseCode = ApiClient.responseCode;
		status = ApiClient.status;
		System.out.println("ResponseCode :" +responseCode);
		System.out.println("ResponseMessage :" +status);
		System.out.println(ApiClient.responseBody);
	
	} catch (ApiException e) {
		
		e.printStackTrace();
	}
  }

}
