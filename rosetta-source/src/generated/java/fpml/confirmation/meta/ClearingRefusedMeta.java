package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingRefused;
import fpml.confirmation.validation.ClearingRefusedTypeFormatValidator;
import fpml.confirmation.validation.ClearingRefusedValidator;
import fpml.confirmation.validation.exists.ClearingRefusedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingRefused.class)
public class ClearingRefusedMeta implements RosettaMetaData<ClearingRefused> {

	@Override
	public List<Validator<? super ClearingRefused>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingRefused, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingRefused> validator() {
		return new ClearingRefusedValidator();
	}

	@Override
	public Validator<? super ClearingRefused> typeFormatValidator() {
		return new ClearingRefusedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingRefused, Set<String>> onlyExistsValidator() {
		return new ClearingRefusedOnlyExistsValidator();
	}
}
