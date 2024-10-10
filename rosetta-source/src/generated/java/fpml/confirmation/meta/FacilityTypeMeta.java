package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityType;
import fpml.confirmation.validation.FacilityTypeTypeFormatValidator;
import fpml.confirmation.validation.FacilityTypeValidator;
import fpml.confirmation.validation.exists.FacilityTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityType.class)
public class FacilityTypeMeta implements RosettaMetaData<FacilityType> {

	@Override
	public List<Validator<? super FacilityType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityType> validator() {
		return new FacilityTypeValidator();
	}

	@Override
	public Validator<? super FacilityType> typeFormatValidator() {
		return new FacilityTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityType, Set<String>> onlyExistsValidator() {
		return new FacilityTypeOnlyExistsValidator();
	}
}
