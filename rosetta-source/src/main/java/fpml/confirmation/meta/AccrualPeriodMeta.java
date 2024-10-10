package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.validation.AccrualPeriodTypeFormatValidator;
import fpml.confirmation.validation.AccrualPeriodValidator;
import fpml.confirmation.validation.exists.AccrualPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccrualPeriod.class)
public class AccrualPeriodMeta implements RosettaMetaData<AccrualPeriod> {

	@Override
	public List<Validator<? super AccrualPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccrualPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccrualPeriod> validator() {
		return new AccrualPeriodValidator();
	}

	@Override
	public Validator<? super AccrualPeriod> typeFormatValidator() {
		return new AccrualPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualPeriod, Set<String>> onlyExistsValidator() {
		return new AccrualPeriodOnlyExistsValidator();
	}
}
