package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditFacility;
import fpml.confirmation.validation.LetterOfCreditFacilityTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditFacilityValidator;
import fpml.confirmation.validation.exists.LetterOfCreditFacilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LetterOfCreditFacility.class)
public class LetterOfCreditFacilityMeta implements RosettaMetaData<LetterOfCreditFacility> {

	@Override
	public List<Validator<? super LetterOfCreditFacility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditFacility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCreditFacility> validator() {
		return new LetterOfCreditFacilityValidator();
	}

	@Override
	public Validator<? super LetterOfCreditFacility> typeFormatValidator() {
		return new LetterOfCreditFacilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditFacility, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditFacilityOnlyExistsValidator();
	}
}
