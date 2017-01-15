package org.example.CustomerDiscountRulesEngine.Engine

class RulesEngine {




	def run(RuleSet ruleset, Object bo){

		ruleset.rules.each{ rule ->
			def success=true
			rule.conditions.each{
				println "params " + it
				//=== If condition match
				def exitMe= false
				if(it(bo)){
					rule.actions.each{
						it(bo)
						exitMe = true

					}

				}

			}


		}


	}



}

