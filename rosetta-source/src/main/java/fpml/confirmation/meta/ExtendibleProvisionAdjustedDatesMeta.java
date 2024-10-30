package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExtendibleProvisionAdjustedDates;
import fpml.confirmation.validation.ExtendibleProvisionAdjustedDatesTypeFormatValidator;
import fpml.confirmation.validation.ExtendibleProvisionAdjustedDatesValidator;
import fpml.confirmation.validation.exists.ExtendibleProvisionAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExtendibleProvisionAdjustedDates.class)
public class ExtendibleProvisionAdjustedDatesMeta implements RosettaMetaData<ExtendibleProvisionAdjustedDates> {

	@Override
	public List<Validator<? super ExtendibleProvisionAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExtendibleProvisionAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExtendibleProvisionAdjustedDates> validator() {
		return new ExtendibleProvisionAdjustedDatesValidator();
	}

	@Override
	public Validator<? super ExtendibleProvisionAdjustedDates> typeFormatValidator() {
		return new ExtendibleProvisionAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtendibleProvisionAdjustedDates, Set<String>> onlyExistsValidator() {
		return new ExtendibleProvisionAdjustedDatesOnlyExistsValidator();
	}
}
