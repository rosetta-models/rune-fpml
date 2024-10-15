package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateOptionChange;
import fpml.confirmation.validation.FixedRateOptionChangeTypeFormatValidator;
import fpml.confirmation.validation.FixedRateOptionChangeValidator;
import fpml.confirmation.validation.exists.FixedRateOptionChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedRateOptionChange.class)
public class FixedRateOptionChangeMeta implements RosettaMetaData<FixedRateOptionChange> {

	@Override
	public List<Validator<? super FixedRateOptionChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateOptionChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRateOptionChange> validator() {
		return new FixedRateOptionChangeValidator();
	}

	@Override
	public Validator<? super FixedRateOptionChange> typeFormatValidator() {
		return new FixedRateOptionChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateOptionChange, Set<String>> onlyExistsValidator() {
		return new FixedRateOptionChangeOnlyExistsValidator();
	}
}
