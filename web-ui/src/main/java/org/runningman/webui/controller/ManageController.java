package org.runningman.webui.controller;

import org.runningman.webui.model.MonitorData;
import org.runningman.webui.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	@Autowired
	private MonitorService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addView(Model model) {
		model.addAttribute("monitorData", new MonitorData());
		return "manage";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMonitor(MonitorData monitorData) {
		service.addMonitor(monitorData);
		return "redirect:/";
	}

}
