package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeLegChoice;
import fpml.confirmation.validation.FeeLegChoiceTypeFormatValidator;
import fpml.confirmation.validation.FeeLegChoiceValidator;
import fpml.confirmation.validation.exists.FeeLegChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FeeLegChoice.class)
public class FeeLegChoiceMeta implements RosettaMetaData<FeeLegChoice> {

	@Override
	public List<Validator<? super FeeLegChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FeeLegChoice>create(fpml.confirmation.validation.datarule.FeeLegChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FeeLegChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeeLegChoice> validator() {
		return new FeeLegChoiceValidator();
	}

	@Override
	public Validator<? super FeeLegChoice> typeFormatValidator() {
		return new FeeLegChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeLegChoice, Set<String>> onlyExistsValidator() {
		return new FeeLegChoiceOnlyExistsValidator();
	}
}
