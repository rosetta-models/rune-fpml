package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Rate;
import fpml.confirmation.validation.RateTypeFormatValidator;
import fpml.confirmation.validation.RateValidator;
import fpml.confirmation.validation.exists.RateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Rate.class)
public class RateMeta implements RosettaMetaData<Rate> {

	@Override
	public List<Validator<? super Rate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Rate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Rate> validator() {
		return new RateValidator();
	}

	@Override
	public Validator<? super Rate> typeFormatValidator() {
		return new RateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Rate, Set<String>> onlyExistsValidator() {
		return new RateOnlyExistsValidator();
	}
}
