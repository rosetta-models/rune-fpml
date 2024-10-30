package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateOptionBase;
import fpml.confirmation.validation.FloatingRateOptionBaseTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateOptionBaseValidator;
import fpml.confirmation.validation.exists.FloatingRateOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FloatingRateOptionBase.class)
public class FloatingRateOptionBaseMeta implements RosettaMetaData<FloatingRateOptionBase> {

	@Override
	public List<Validator<? super FloatingRateOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateOptionBase> validator() {
		return new FloatingRateOptionBaseValidator();
	}

	@Override
	public Validator<? super FloatingRateOptionBase> typeFormatValidator() {
		return new FloatingRateOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateOptionBase, Set<String>> onlyExistsValidator() {
		return new FloatingRateOptionBaseOnlyExistsValidator();
	}
}
