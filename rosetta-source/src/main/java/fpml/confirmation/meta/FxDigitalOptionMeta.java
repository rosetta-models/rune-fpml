package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDigitalOption;
import fpml.confirmation.validation.FxDigitalOptionTypeFormatValidator;
import fpml.confirmation.validation.FxDigitalOptionValidator;
import fpml.confirmation.validation.exists.FxDigitalOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxDigitalOption.class)
public class FxDigitalOptionMeta implements RosettaMetaData<FxDigitalOption> {

	@Override
	public List<Validator<? super FxDigitalOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxDigitalOption>create(fpml.confirmation.validation.datarule.FxDigitalOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxDigitalOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDigitalOption> validator() {
		return new FxDigitalOptionValidator();
	}

	@Override
	public Validator<? super FxDigitalOption> typeFormatValidator() {
		return new FxDigitalOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDigitalOption, Set<String>> onlyExistsValidator() {
		return new FxDigitalOptionOnlyExistsValidator();
	}
}
