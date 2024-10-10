package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrioritizedRateSourceModel;
import fpml.confirmation.validation.PrioritizedRateSourceModelTypeFormatValidator;
import fpml.confirmation.validation.PrioritizedRateSourceModelValidator;
import fpml.confirmation.validation.exists.PrioritizedRateSourceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PrioritizedRateSourceModel.class)
public class PrioritizedRateSourceModelMeta implements RosettaMetaData<PrioritizedRateSourceModel> {

	@Override
	public List<Validator<? super PrioritizedRateSourceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrioritizedRateSourceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrioritizedRateSourceModel> validator() {
		return new PrioritizedRateSourceModelValidator();
	}

	@Override
	public Validator<? super PrioritizedRateSourceModel> typeFormatValidator() {
		return new PrioritizedRateSourceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrioritizedRateSourceModel, Set<String>> onlyExistsValidator() {
		return new PrioritizedRateSourceModelOnlyExistsValidator();
	}
}
