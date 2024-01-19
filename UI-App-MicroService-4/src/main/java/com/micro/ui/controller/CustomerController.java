package com.micro.ui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.micro.ui.constants.AppConstants;
import com.micro.ui.model.CustomerDTO;
import com.micro.ui.model.FriendDTO;
import com.micro.ui.model.LoginDTO;
import com.micro.ui.model.PlanDTO;
import com.micro.ui.model.RegisterDTO;

@Controller
public class CustomerController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/index")
	public String getIndexPage() {
		return "Index";
	}

	private List<PlanDTO> getPlanDTO(){
		ParameterizedTypeReference<List<PlanDTO>> typeRef= new ParameterizedTypeReference<List<PlanDTO>>() {};
		ResponseEntity<List<PlanDTO>> re= restTemplate.exchange(AppConstants.BROWSE_ALL_PLANS_URL, HttpMethod.GET,null,typeRef);
		List<PlanDTO> list=re.getBody();
		return list;
	}


	@GetMapping("/customer_registration_page")
	public String getRegistrationPage(Model model) {
		RegisterDTO customer=new RegisterDTO();
		customer.setPlanData(getPlanDTO());
		model.addAttribute("customer",customer);
		return "Registration";
	}


	@PostMapping("/add_customer")
	public String addCustomer(@ModelAttribute RegisterDTO customer,Model model)
	{
		//call- microservice customer

		boolean flag= restTemplate.postForObject(AppConstants.CUSTOMER_REGISTRATION_URL, customer, Boolean.class);
		if(flag)
		{
			String message="Customer is Successfully Registered....";
			model.addAttribute("message",message);
			return "Success";
		}
		else {
			String message="Customer is alread Registered with this phoneNumber.. try Again!!!!..";
			customer.setPlanData(getPlanDTO());
			model.addAttribute("message",message);
			return "Registration";

		}
	}

	@GetMapping(value="/customer_login_page")
	public String getCustomerLoginPage()
	{
		return "Login";
	}


	@PostMapping(value="/login_customer")
	public String loginCustomer(@RequestParam Long phoneNo,@RequestParam String password,Model model, HttpServletRequest request ) {


		LoginDTO login=new LoginDTO();
		login.setPhoneNumber(phoneNo);
		login.setPassword(password);

		boolean flag=restTemplate.postForObject(AppConstants.CUSTOMER_LOGIN_URL,login,Boolean.class);
		if(flag) {
			HttpSession session =request.getSession();
			session.setAttribute("phoneNumber", phoneNo);

			String firstName = restTemplate.getForObject(AppConstants.CUSTOMER_NAME_URL, String.class,phoneNo );
			session.setAttribute(firstName, firstName);
			return "DashBoard1";
		}
		else {
			model.addAttribute("message","Bad Credentials");
			return "Login";
		}
	}
	@GetMapping("/profile")
	public String getCustomerProfile(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Long phoneNumber=(Long)session.getAttribute("phoneNumber");
		CustomerDTO custProfile=restTemplate.getForObject(AppConstants.CUSTOMER_PROFILE_URL, CustomerDTO.class, phoneNumber);
		model.addAttribute("customer_profile",custProfile);

		return "CustomerProfile";
	}

	@GetMapping("/plans")
	public String getAllPlans(Model model) {
		List<PlanDTO> psList=getPlanDTO();
		model.addAttribute("plansList",psList);
		return "ShowPlans";
	}

	@GetMapping("/addfriend")
	public  String  addFriendPage() {
		return "AddContact";
	}

	@GetMapping("/addContact")
	public String addFriendContact(Model model, HttpServletRequest request,@RequestParam Long friendNumber) {

		HttpSession session=request.getSession();
		Long phoneNo=(Long)session.getAttribute("phoneNumber");

		FriendDTO friend=new FriendDTO();
		friend.setFriendNumber(friendNumber);
		friend.setPhoneNumber(phoneNo);
		String message = restTemplate.postForObject(AppConstants.ADD_FRIEND_CONTACT_URL, friend, String.class);
		model.addAttribute("message", message);
		return "FriendAdded";
	}

	@GetMapping(value="/dash_board")
	public String getCustomerDashBoard()
	{
		return "DashBoard1";
	}


}

