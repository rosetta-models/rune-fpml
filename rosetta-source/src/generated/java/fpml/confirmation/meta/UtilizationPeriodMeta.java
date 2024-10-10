package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UtilizationPeriod;
import fpml.confirmation.validation.UtilizationPeriodTypeFormatValidator;
import fpml.confirmation.validation.UtilizationPeriodValidator;
import fpml.confirmation.validation.exists.UtilizationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UtilizationPeriod.class)
public class UtilizationPeriodMeta implements RosettaMetaData<UtilizationPeriod> {

	@Override
	public List<Validator<? super UtilizationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UtilizationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UtilizationPeriod> validator() {
		return new UtilizationPeriodValidator();
	}

	@Override
	public Validator<? super UtilizationPeriod> typeFormatValidator() {
		return new UtilizationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UtilizationPeriod, Set<String>> onlyExistsValidator() {
		return new UtilizationPeriodOnlyExistsValidator();
	}
}
