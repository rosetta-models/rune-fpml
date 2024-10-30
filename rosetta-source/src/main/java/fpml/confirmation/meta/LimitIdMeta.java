package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LimitId;
import fpml.confirmation.validation.LimitIdTypeFormatValidator;
import fpml.confirmation.validation.LimitIdValidator;
import fpml.confirmation.validation.exists.LimitIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LimitId.class)
public class LimitIdMeta implements RosettaMetaData<LimitId> {

	@Override
	public List<Validator<? super LimitId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LimitId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LimitId> validator() {
		return new LimitIdValidator();
	}

	@Override
	public Validator<? super LimitId> typeFormatValidator() {
		return new LimitIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LimitId, Set<String>> onlyExistsValidator() {
		return new LimitIdOnlyExistsValidator();
	}
}
