package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StubFloatingRate;
import fpml.confirmation.validation.StubFloatingRateTypeFormatValidator;
import fpml.confirmation.validation.StubFloatingRateValidator;
import fpml.confirmation.validation.exists.StubFloatingRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StubFloatingRate.class)
public class StubFloatingRateMeta implements RosettaMetaData<StubFloatingRate> {

	@Override
	public List<Validator<? super StubFloatingRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StubFloatingRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StubFloatingRate> validator() {
		return new StubFloatingRateValidator();
	}

	@Override
	public Validator<? super StubFloatingRate> typeFormatValidator() {
		return new StubFloatingRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubFloatingRate, Set<String>> onlyExistsValidator() {
		return new StubFloatingRateOnlyExistsValidator();
	}
}
