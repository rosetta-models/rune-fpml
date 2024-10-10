package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BaseRateSet;
import fpml.confirmation.validation.BaseRateSetTypeFormatValidator;
import fpml.confirmation.validation.BaseRateSetValidator;
import fpml.confirmation.validation.exists.BaseRateSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BaseRateSet.class)
public class BaseRateSetMeta implements RosettaMetaData<BaseRateSet> {

	@Override
	public List<Validator<? super BaseRateSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BaseRateSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BaseRateSet> validator() {
		return new BaseRateSetValidator();
	}

	@Override
	public Validator<? super BaseRateSet> typeFormatValidator() {
		return new BaseRateSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BaseRateSet, Set<String>> onlyExistsValidator() {
		return new BaseRateSetOnlyExistsValidator();
	}
}
