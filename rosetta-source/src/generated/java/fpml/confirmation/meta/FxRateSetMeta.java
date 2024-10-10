package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxRateSet;
import fpml.confirmation.validation.FxRateSetTypeFormatValidator;
import fpml.confirmation.validation.FxRateSetValidator;
import fpml.confirmation.validation.exists.FxRateSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxRateSet.class)
public class FxRateSetMeta implements RosettaMetaData<FxRateSet> {

	@Override
	public List<Validator<? super FxRateSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRateSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxRateSet> validator() {
		return new FxRateSetValidator();
	}

	@Override
	public Validator<? super FxRateSet> typeFormatValidator() {
		return new FxRateSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateSet, Set<String>> onlyExistsValidator() {
		return new FxRateSetOnlyExistsValidator();
	}
}
