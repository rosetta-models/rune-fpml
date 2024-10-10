package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityTermination;
import fpml.confirmation.validation.FacilityTerminationTypeFormatValidator;
import fpml.confirmation.validation.FacilityTerminationValidator;
import fpml.confirmation.validation.exists.FacilityTerminationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityTermination.class)
public class FacilityTerminationMeta implements RosettaMetaData<FacilityTermination> {

	@Override
	public List<Validator<? super FacilityTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityTermination> validator() {
		return new FacilityTerminationValidator();
	}

	@Override
	public Validator<? super FacilityTermination> typeFormatValidator() {
		return new FacilityTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityTermination, Set<String>> onlyExistsValidator() {
		return new FacilityTerminationOnlyExistsValidator();
	}
}
