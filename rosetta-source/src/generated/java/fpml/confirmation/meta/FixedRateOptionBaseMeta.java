package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateOptionBase;
import fpml.confirmation.validation.FixedRateOptionBaseTypeFormatValidator;
import fpml.confirmation.validation.FixedRateOptionBaseValidator;
import fpml.confirmation.validation.exists.FixedRateOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedRateOptionBase.class)
public class FixedRateOptionBaseMeta implements RosettaMetaData<FixedRateOptionBase> {

	@Override
	public List<Validator<? super FixedRateOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRateOptionBase> validator() {
		return new FixedRateOptionBaseValidator();
	}

	@Override
	public Validator<? super FixedRateOptionBase> typeFormatValidator() {
		return new FixedRateOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateOptionBase, Set<String>> onlyExistsValidator() {
		return new FixedRateOptionBaseOnlyExistsValidator();
	}
}
