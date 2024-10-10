package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Formula;
import fpml.confirmation.validation.FormulaTypeFormatValidator;
import fpml.confirmation.validation.FormulaValidator;
import fpml.confirmation.validation.exists.FormulaOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Formula.class)
public class FormulaMeta implements RosettaMetaData<Formula> {

	@Override
	public List<Validator<? super Formula>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Formula, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Formula> validator() {
		return new FormulaValidator();
	}

	@Override
	public Validator<? super Formula> typeFormatValidator() {
		return new FormulaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Formula, Set<String>> onlyExistsValidator() {
		return new FormulaOnlyExistsValidator();
	}
}
