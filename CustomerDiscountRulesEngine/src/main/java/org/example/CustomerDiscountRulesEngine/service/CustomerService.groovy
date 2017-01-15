package org.example.CustomerDiscountRulesEngine.service

import org.example.CustomerDiscountRulesEngine.model.Customer;

class CustomerService {


	float getTotalBalance(Customer customer){

		// finalCost= cost - ((cost/100)*20)
		return (customer.getAmountSpend() - ((customer.getAmountSpend()/100)*customer.getDiscount()))
	}

	void applyDiscount(Customer customer){

		customer.setBalance(customer.getAmountSpend() - ((customer.getAmountSpend()/100)*customer.getDiscount()))
	}
}
