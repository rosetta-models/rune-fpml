package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Clearing;
import fpml.confirmation.validation.ClearingTypeFormatValidator;
import fpml.confirmation.validation.ClearingValidator;
import fpml.confirmation.validation.exists.ClearingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Clearing.class)
public class ClearingMeta implements RosettaMetaData<Clearing> {

	@Override
	public List<Validator<? super Clearing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Clearing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Clearing> validator() {
		return new ClearingValidator();
	}

	@Override
	public Validator<? super Clearing> typeFormatValidator() {
		return new ClearingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Clearing, Set<String>> onlyExistsValidator() {
		return new ClearingOnlyExistsValidator();
	}
}
