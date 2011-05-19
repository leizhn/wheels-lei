package com.autonavi.infra.http.server.jetty;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class JettyTestingJsonServer extends HttpServlet {

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(resource.getInputStream());
		while (scanner.hasNextLine()) {
			sb.append(scanner.nextLine());
		}
		resp.getWriter().print(sb.toString());
	}

	private Resource resource;

	public static void main(String[] args) {
		String port = args[0];
		String resource = args[1];
		String path = args[2];
		Server server = new Server(Integer.parseInt(port));
		Context context = new Context(server, "/", Context.SESSIONS);
		JettyTestingJsonServer servlet = new JettyTestingJsonServer();
		servlet.setResource(new ClassPathResource(resource));
		context.addServlet(new ServletHolder(servlet), path);
	}

	private static final long serialVersionUID = -3463994999089781273L;
}
