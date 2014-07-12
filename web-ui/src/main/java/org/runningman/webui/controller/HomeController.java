package org.runningman.webui.controller;

import org.runningman.webui.model.MonitorData;
import org.runningman.webui.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private MonitorService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("monitors", service.getAll());
		return "home";
	}
	
	@RequestMapping(value = "/monitor/{id}", method = RequestMethod.GET)
	public String getMonitor(@PathVariable("id") String id, Model model) {
		MonitorData data = service.getMonitor(id);
		model.addAttribute("monitor", data);
		return "detail";
	}
	
}
