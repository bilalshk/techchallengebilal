package bilal_web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import bilal_model.SuccessData;
import bilal_service.OathCreate;

@WebServlet(name = "CreateServlet")
public class CreateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String eventUrl = request.getParameter("eventUrl");

		ObjectMapper mapper = new ObjectMapper();

		String hitUrl = OathCreate.hitEventUrl(eventUrl);

		SuccessData demo = new SuccessData();
		System.out.println("Dummy URL" + eventUrl);

		System.out.println("Hit URL" + hitUrl);

		demo.setAccountIdentifier("Appdata123");
		demo.setSuccess("true");

		String json = mapper.writeValueAsString(demo);
		out.print(json);
	}
}
