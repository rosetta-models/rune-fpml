package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcRateChange;
import fpml.confirmation.validation.LcRateChangeTypeFormatValidator;
import fpml.confirmation.validation.LcRateChangeValidator;
import fpml.confirmation.validation.exists.LcRateChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcRateChange.class)
public class LcRateChangeMeta implements RosettaMetaData<LcRateChange> {

	@Override
	public List<Validator<? super LcRateChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcRateChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcRateChange> validator() {
		return new LcRateChangeValidator();
	}

	@Override
	public Validator<? super LcRateChange> typeFormatValidator() {
		return new LcRateChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcRateChange, Set<String>> onlyExistsValidator() {
		return new LcRateChangeOnlyExistsValidator();
	}
}
