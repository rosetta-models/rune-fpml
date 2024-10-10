package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralProfile;
import fpml.confirmation.validation.CollateralProfileTypeFormatValidator;
import fpml.confirmation.validation.CollateralProfileValidator;
import fpml.confirmation.validation.exists.CollateralProfileOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CollateralProfile.class)
public class CollateralProfileMeta implements RosettaMetaData<CollateralProfile> {

	@Override
	public List<Validator<? super CollateralProfile>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralProfile, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralProfile> validator() {
		return new CollateralProfileValidator();
	}

	@Override
	public Validator<? super CollateralProfile> typeFormatValidator() {
		return new CollateralProfileTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralProfile, Set<String>> onlyExistsValidator() {
		return new CollateralProfileOnlyExistsValidator();
	}
}
