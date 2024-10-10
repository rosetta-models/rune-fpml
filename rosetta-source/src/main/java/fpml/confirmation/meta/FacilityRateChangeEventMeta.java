package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityRateChangeEvent;
import fpml.confirmation.validation.FacilityRateChangeEventTypeFormatValidator;
import fpml.confirmation.validation.FacilityRateChangeEventValidator;
import fpml.confirmation.validation.exists.FacilityRateChangeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityRateChangeEvent.class)
public class FacilityRateChangeEventMeta implements RosettaMetaData<FacilityRateChangeEvent> {

	@Override
	public List<Validator<? super FacilityRateChangeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityRateChangeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityRateChangeEvent> validator() {
		return new FacilityRateChangeEventValidator();
	}

	@Override
	public Validator<? super FacilityRateChangeEvent> typeFormatValidator() {
		return new FacilityRateChangeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityRateChangeEvent, Set<String>> onlyExistsValidator() {
		return new FacilityRateChangeEventOnlyExistsValidator();
	}
}
