package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.validation.ClearanceSystemTypeFormatValidator;
import fpml.confirmation.validation.ClearanceSystemValidator;
import fpml.confirmation.validation.exists.ClearanceSystemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearanceSystem.class)
public class ClearanceSystemMeta implements RosettaMetaData<ClearanceSystem> {

	@Override
	public List<Validator<? super ClearanceSystem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearanceSystem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearanceSystem> validator() {
		return new ClearanceSystemValidator();
	}

	@Override
	public Validator<? super ClearanceSystem> typeFormatValidator() {
		return new ClearanceSystemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearanceSystem, Set<String>> onlyExistsValidator() {
		return new ClearanceSystemOnlyExistsValidator();
	}
}
