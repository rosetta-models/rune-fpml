package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StrategyComponentIdentification;
import fpml.confirmation.validation.StrategyComponentIdentificationTypeFormatValidator;
import fpml.confirmation.validation.StrategyComponentIdentificationValidator;
import fpml.confirmation.validation.exists.StrategyComponentIdentificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=StrategyComponentIdentification.class)
public class StrategyComponentIdentificationMeta implements RosettaMetaData<StrategyComponentIdentification> {

	@Override
	public List<Validator<? super StrategyComponentIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StrategyComponentIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StrategyComponentIdentification> validator() {
		return new StrategyComponentIdentificationValidator();
	}

	@Override
	public Validator<? super StrategyComponentIdentification> typeFormatValidator() {
		return new StrategyComponentIdentificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StrategyComponentIdentification, Set<String>> onlyExistsValidator() {
		return new StrategyComponentIdentificationOnlyExistsValidator();
	}
}
