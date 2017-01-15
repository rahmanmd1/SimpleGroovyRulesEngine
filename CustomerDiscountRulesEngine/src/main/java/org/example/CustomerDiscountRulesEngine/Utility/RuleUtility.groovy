package org.example.CustomerDiscountRulesEngine.Utility

import org.codehaus.groovy.scriptom.ActiveXObject
import org.example.CustomerDiscountRulesEngine.Engine.Rule


class RuleUtility {


	def addRuleFromExcel(ruleset){

		ActiveXObject x = new ActiveXObject('Excel.Application')

		def filename = "H:/GitHubrepositories/GroovyCodes/discountrules.xlsx"
		// Start excel
		def excel = new ActiveXObject('Excel.Application')
		def workbook = excel.Workbooks.Open(new File(filename).canonicalPath)
		def sheet = workbook.ActiveSheet

		// Create rule
		def rule = new Rule()

		// Read conditions
		['A2', 'A3'].each{
			rule.conditions << Eval.me("{ ${sheet.Range(it).Value}}")
		}

		// Read actions
		['B2', 'B3'].each{
			rule.actions << Eval.me("{ ${sheet.Range(it).Value}}")
		}

		
		// Close excel
		workbook.Close()
		excel.Quit()

		ruleset.rules<<rule
	}



}

