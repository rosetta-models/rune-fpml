package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Sensitivity;
import fpml.confirmation.validation.SensitivityTypeFormatValidator;
import fpml.confirmation.validation.SensitivityValidator;
import fpml.confirmation.validation.exists.SensitivityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Sensitivity.class)
public class SensitivityMeta implements RosettaMetaData<Sensitivity> {

	@Override
	public List<Validator<? super Sensitivity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Sensitivity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Sensitivity> validator() {
		return new SensitivityValidator();
	}

	@Override
	public Validator<? super Sensitivity> typeFormatValidator() {
		return new SensitivityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Sensitivity, Set<String>> onlyExistsValidator() {
		return new SensitivityOnlyExistsValidator();
	}
}
