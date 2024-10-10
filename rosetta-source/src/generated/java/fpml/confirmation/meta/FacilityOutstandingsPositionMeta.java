package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.validation.FacilityOutstandingsPositionTypeFormatValidator;
import fpml.confirmation.validation.FacilityOutstandingsPositionValidator;
import fpml.confirmation.validation.exists.FacilityOutstandingsPositionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityOutstandingsPosition.class)
public class FacilityOutstandingsPositionMeta implements RosettaMetaData<FacilityOutstandingsPosition> {

	@Override
	public List<Validator<? super FacilityOutstandingsPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityOutstandingsPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityOutstandingsPosition> validator() {
		return new FacilityOutstandingsPositionValidator();
	}

	@Override
	public Validator<? super FacilityOutstandingsPosition> typeFormatValidator() {
		return new FacilityOutstandingsPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityOutstandingsPosition, Set<String>> onlyExistsValidator() {
		return new FacilityOutstandingsPositionOnlyExistsValidator();
	}
}
