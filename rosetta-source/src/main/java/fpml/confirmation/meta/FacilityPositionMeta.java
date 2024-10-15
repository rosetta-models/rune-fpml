package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.validation.FacilityPositionTypeFormatValidator;
import fpml.confirmation.validation.FacilityPositionValidator;
import fpml.confirmation.validation.exists.FacilityPositionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityPosition.class)
public class FacilityPositionMeta implements RosettaMetaData<FacilityPosition> {

	@Override
	public List<Validator<? super FacilityPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityPosition> validator() {
		return new FacilityPositionValidator();
	}

	@Override
	public Validator<? super FacilityPosition> typeFormatValidator() {
		return new FacilityPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityPosition, Set<String>> onlyExistsValidator() {
		return new FacilityPositionOnlyExistsValidator();
	}
}
