package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EnvironmentalProductComplaincePeriod;
import fpml.confirmation.validation.EnvironmentalProductComplaincePeriodTypeFormatValidator;
import fpml.confirmation.validation.EnvironmentalProductComplaincePeriodValidator;
import fpml.confirmation.validation.exists.EnvironmentalProductComplaincePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EnvironmentalProductComplaincePeriod.class)
public class EnvironmentalProductComplaincePeriodMeta implements RosettaMetaData<EnvironmentalProductComplaincePeriod> {

	@Override
	public List<Validator<? super EnvironmentalProductComplaincePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalProductComplaincePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EnvironmentalProductComplaincePeriod> validator() {
		return new EnvironmentalProductComplaincePeriodValidator();
	}

	@Override
	public Validator<? super EnvironmentalProductComplaincePeriod> typeFormatValidator() {
		return new EnvironmentalProductComplaincePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalProductComplaincePeriod, Set<String>> onlyExistsValidator() {
		return new EnvironmentalProductComplaincePeriodOnlyExistsValidator();
	}
}
