package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.validation.ComputedDerivativeModelTypeFormatValidator;
import fpml.confirmation.validation.ComputedDerivativeModelValidator;
import fpml.confirmation.validation.exists.ComputedDerivativeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ComputedDerivativeModel.class)
public class ComputedDerivativeModelMeta implements RosettaMetaData<ComputedDerivativeModel> {

	@Override
	public List<Validator<? super ComputedDerivativeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ComputedDerivativeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ComputedDerivativeModel> validator() {
		return new ComputedDerivativeModelValidator();
	}

	@Override
	public Validator<? super ComputedDerivativeModel> typeFormatValidator() {
		return new ComputedDerivativeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ComputedDerivativeModel, Set<String>> onlyExistsValidator() {
		return new ComputedDerivativeModelOnlyExistsValidator();
	}
}
