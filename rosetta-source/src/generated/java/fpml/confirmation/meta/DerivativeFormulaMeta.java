package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DerivativeFormula;
import fpml.confirmation.validation.DerivativeFormulaTypeFormatValidator;
import fpml.confirmation.validation.DerivativeFormulaValidator;
import fpml.confirmation.validation.exists.DerivativeFormulaOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeFormula.class)
public class DerivativeFormulaMeta implements RosettaMetaData<DerivativeFormula> {

	@Override
	public List<Validator<? super DerivativeFormula>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeFormula, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DerivativeFormula> validator() {
		return new DerivativeFormulaValidator();
	}

	@Override
	public Validator<? super DerivativeFormula> typeFormatValidator() {
		return new DerivativeFormulaTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeFormula, Set<String>> onlyExistsValidator() {
		return new DerivativeFormulaOnlyExistsValidator();
	}
}
