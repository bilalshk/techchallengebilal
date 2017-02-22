package bilal_service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import bilal_bean.Bean;
import bilal_dao.OathDaoCreate;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class OathCreate {
	static OathDaoCreate oath_dao = new OathDaoCreate();

	public static String hitEventUrl(String eventUrl) {
		String responseJson = "";
		try {
			DefaultOAuthConsumer e = new DefaultOAuthConsumer("bilaltechchallenge-151974", "LV6EH0Ye9DwUUOib");
			URL url = new URL(eventUrl);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.setRequestProperty("Accept", "application/json");
			e.sign(request);
			int responseCode = request.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			StringBuffer response = new StringBuffer();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			responseJson = response.toString();
			Bean bean = new Bean();
			bean = (Bean) new ObjectMapper().readValue(responseJson, Bean.class);
			oath_dao.create(bean);
		} catch (Exception var9) {
			System.out.println("Error fetching data from eventUrl - {} " + var9.getMessage());
		}
		return responseJson;
	}
}
