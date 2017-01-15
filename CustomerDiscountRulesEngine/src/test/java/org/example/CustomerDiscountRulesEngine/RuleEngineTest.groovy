package org.example.CustomerDiscountRulesEngine
import org.example.CustomerDiscountRulesEngine.Engine.RuleSet
import org.example.CustomerDiscountRulesEngine.Engine.RulesEngine
import org.example.CustomerDiscountRulesEngine.Utility.RuleUtility
import org.example.CustomerDiscountRulesEngine.model.Customer
import org.junit.Test;
class RuleEngineTest {

	@Test
	void testForTwentyPercentDiscount(){
	
		def ruleUtility = new RuleUtility()
		
		def customer = new Customer(id:"cust1",discount:0,amountSpend:100,balance:0)
		println "Before:" + customer.dump()
		def ruleset = new RuleSet()
		ruleUtility.addRuleFromExcel(ruleset)
		
		def engine = new RulesEngine()
		engine.run(ruleset,customer)
		println "After:" + customer.dump()
			
	}
	
	@Test
	void testForThirtyPercentDiscount(){
	
		def ruleUtility = new RuleUtility()
		
		def customer = new Customer(id:"cust1",discount:0,amountSpend:1000,balance:0)
		println "Before:" + customer.dump()
		def ruleset = new RuleSet()
		ruleUtility.addRuleFromExcel(ruleset)
		
		def engine = new RulesEngine()
		engine.run(ruleset,customer)
		println "After:" + customer.dump()
			
	}
}
