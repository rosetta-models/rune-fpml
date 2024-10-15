package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StubCalculationPeriod;
import fpml.confirmation.validation.StubCalculationPeriodTypeFormatValidator;
import fpml.confirmation.validation.StubCalculationPeriodValidator;
import fpml.confirmation.validation.exists.StubCalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StubCalculationPeriod.class)
public class StubCalculationPeriodMeta implements RosettaMetaData<StubCalculationPeriod> {

	@Override
	public List<Validator<? super StubCalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.StubCalculationPeriod>create(fpml.confirmation.validation.datarule.StubCalculationPeriodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StubCalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StubCalculationPeriod> validator() {
		return new StubCalculationPeriodValidator();
	}

	@Override
	public Validator<? super StubCalculationPeriod> typeFormatValidator() {
		return new StubCalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubCalculationPeriod, Set<String>> onlyExistsValidator() {
		return new StubCalculationPeriodOnlyExistsValidator();
	}
}
