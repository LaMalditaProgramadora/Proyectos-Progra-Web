package com.example.demoImage.controller;

import java.net.MalformedURLException;

import com.example.demoImage.model.Meme;
import com.example.demoImage.service.IMemeService;
import com.example.demoImage.service.IUploadFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/memes")
public class MemeController {

	@Autowired
	private IMemeService memeService;

	@Autowired
	private IUploadFileService uploadFileService;

	@GetMapping
	public String listMemes(Model model) {
		try {
			model.addAttribute("listMemes", memeService.listAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "meme/listMemes";
	}

	@GetMapping(value = "/uploads/{filename}")
	public ResponseEntity<Resource> goImage(@PathVariable String filename) {
		Resource resource = null;
		try {
			resource = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/new")
	public String newMeme(Model model) {
		model.addAttribute("meme", new Meme());
		model.addAttribute("listMemes", memeService.listAll());
		return "meme/meme";
	}

	@PostMapping("/save")
	public String saveMeme(@Validated @ModelAttribute("meme") Meme meme, BindingResult result, Model model,
			@RequestParam("file") MultipartFile image, RedirectAttributes flash, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			return "meme/meme";
		} else {
			if (!image.isEmpty()) {
				if (meme.getId() > 0 && meme.getImage() != null && meme.getImage().length() > 0) {
					uploadFileService.delete(meme.getImage());
				}
				String uniqueFileName = uploadFileService.copy(image);
				meme.setImage(uniqueFileName);
			}
			memeService.save(meme);
			status.setComplete();
		}
		return "redirect:/memes";
	}

	@RequestMapping("/update/{id}")
	public String goUpdate(@PathVariable(value = "id") int id, Model model) {
		Meme meme = memeService.listById(id);
		model.addAttribute("meme", meme);
		return "meme/meme";
	}
	
	@RequestMapping("/detail/{id}")
	public String goDetail(@PathVariable(value = "id") int id, Model model) {
		Meme meme = memeService.listById(id);
		model.addAttribute("meme", meme);
		return "meme/memeDetail";
	}

	@RequestMapping("/delete/{id}")
	public String eliminar(@PathVariable(value = "id") int id, Model model) {
		try {
			memeService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/memes";
	}
}
