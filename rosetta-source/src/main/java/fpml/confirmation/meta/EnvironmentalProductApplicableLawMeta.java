package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EnvironmentalProductApplicableLaw;
import fpml.confirmation.validation.EnvironmentalProductApplicableLawTypeFormatValidator;
import fpml.confirmation.validation.EnvironmentalProductApplicableLawValidator;
import fpml.confirmation.validation.exists.EnvironmentalProductApplicableLawOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EnvironmentalProductApplicableLaw.class)
public class EnvironmentalProductApplicableLawMeta implements RosettaMetaData<EnvironmentalProductApplicableLaw> {

	@Override
	public List<Validator<? super EnvironmentalProductApplicableLaw>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalProductApplicableLaw, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EnvironmentalProductApplicableLaw> validator() {
		return new EnvironmentalProductApplicableLawValidator();
	}

	@Override
	public Validator<? super EnvironmentalProductApplicableLaw> typeFormatValidator() {
		return new EnvironmentalProductApplicableLawTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalProductApplicableLaw, Set<String>> onlyExistsValidator() {
		return new EnvironmentalProductApplicableLawOnlyExistsValidator();
	}
}
