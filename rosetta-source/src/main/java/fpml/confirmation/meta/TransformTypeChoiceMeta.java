package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TransformTypeChoice;
import fpml.confirmation.validation.TransformTypeChoiceTypeFormatValidator;
import fpml.confirmation.validation.TransformTypeChoiceValidator;
import fpml.confirmation.validation.exists.TransformTypeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TransformTypeChoice.class)
public class TransformTypeChoiceMeta implements RosettaMetaData<TransformTypeChoice> {

	@Override
	public List<Validator<? super TransformTypeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransformTypeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransformTypeChoice> validator() {
		return new TransformTypeChoiceValidator();
	}

	@Override
	public Validator<? super TransformTypeChoice> typeFormatValidator() {
		return new TransformTypeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransformTypeChoice, Set<String>> onlyExistsValidator() {
		return new TransformTypeChoiceOnlyExistsValidator();
	}
}
