package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.validation.DerivativeCalculationProcedureTypeFormatValidator;
import fpml.confirmation.validation.DerivativeCalculationProcedureValidator;
import fpml.confirmation.validation.exists.DerivativeCalculationProcedureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DerivativeCalculationProcedure.class)
public class DerivativeCalculationProcedureMeta implements RosettaMetaData<DerivativeCalculationProcedure> {

	@Override
	public List<Validator<? super DerivativeCalculationProcedure>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DerivativeCalculationProcedure, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DerivativeCalculationProcedure> validator() {
		return new DerivativeCalculationProcedureValidator();
	}

	@Override
	public Validator<? super DerivativeCalculationProcedure> typeFormatValidator() {
		return new DerivativeCalculationProcedureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DerivativeCalculationProcedure, Set<String>> onlyExistsValidator() {
		return new DerivativeCalculationProcedureOnlyExistsValidator();
	}
}
