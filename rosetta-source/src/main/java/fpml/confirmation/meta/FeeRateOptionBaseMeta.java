package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeRateOptionBase;
import fpml.confirmation.validation.FeeRateOptionBaseTypeFormatValidator;
import fpml.confirmation.validation.FeeRateOptionBaseValidator;
import fpml.confirmation.validation.exists.FeeRateOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FeeRateOptionBase.class)
public class FeeRateOptionBaseMeta implements RosettaMetaData<FeeRateOptionBase> {

	@Override
	public List<Validator<? super FeeRateOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FeeRateOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeeRateOptionBase> validator() {
		return new FeeRateOptionBaseValidator();
	}

	@Override
	public Validator<? super FeeRateOptionBase> typeFormatValidator() {
		return new FeeRateOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeRateOptionBase, Set<String>> onlyExistsValidator() {
		return new FeeRateOptionBaseOnlyExistsValidator();
	}
}
