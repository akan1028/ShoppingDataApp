package com.example.demo.app.shopping;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.app.Shopping;
import com.example.demo.service.ShoppingService;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
	
	private final ShoppingService shoppingService;
	
	@Autowired
	public ShoppingController(ShoppingService  shoppingService) {
		this.shoppingService = shoppingService ;
	}
	
	@GetMapping //データベースからリストを取ってきて表示
	public String index(Model model, DeleteForm deleteForm) {
		List<Shopping> list = shoppingService.getAll();
		
		model.addAttribute("shoppingList", list);
		model.addAttribute("title", "買い物リスト");
		return "shopping/index_boot";
	}
	@GetMapping("/form") //初期入力フォーム
	public String form(ShoppingForm shoppingForm, Model model) {
		model.addAttribute("title", "買い物メモフォーム");
		model.addAttribute("memo", "メモしてください");
		
		return "shopping/form_boot";
	}
	
	@PostMapping("/form")  //入力フォームからinputを押したときの処理
	public String formpost(@Validated ShoppingForm shoppingForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {  //エラーを吐いた場合
			model.addAttribute("title","買い物メモフォーム");
			return "shopping/form_boot";
		}
		// entityのshoppingを初期化してフォームに入っていた値と自動生成されたDateをいれる
		    Shopping shopping = new Shopping();
		    shopping.setName(shoppingForm.getName());
		    shopping.setCount(shoppingForm.getCount());
		    shopping.setPrice(shoppingForm.getPrice());
		    shopping.setPriceadd(shoppingForm.getPrice()*shoppingForm.getCount());
		    shopping.setLocation(shoppingForm.getLocation());
		    shopping.setDate(new Date());
		
		    // shopingServiceクラスのsave(
		    shoppingService.save(shopping);
		    redirectAttributes.addFlashAttribute("title","買い物リスト");
		    redirectAttributes.addFlashAttribute("complete","メモしました");
		    return "redirect:/shopping";
	}
	
	@PostMapping("/delete")
	public String deleteindex(Model model, @RequestParam(name = "delete")int id) {
		 
		shoppingService.delete(id);
		 List<Shopping> list = shoppingService.getAll();
		 
		 model.addAttribute("shoppingList", list);
		 model.addAttribute("title", "買い物リスト");
		 model.addAttribute("delete", "deleted");
		 return "shopping/index_boot";
	}
	
	
}
