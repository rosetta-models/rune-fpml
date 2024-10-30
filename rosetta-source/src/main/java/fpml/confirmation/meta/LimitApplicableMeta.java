package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LimitApplicable;
import fpml.confirmation.validation.LimitApplicableTypeFormatValidator;
import fpml.confirmation.validation.LimitApplicableValidator;
import fpml.confirmation.validation.exists.LimitApplicableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LimitApplicable.class)
public class LimitApplicableMeta implements RosettaMetaData<LimitApplicable> {

	@Override
	public List<Validator<? super LimitApplicable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LimitApplicable>create(fpml.confirmation.validation.datarule.LimitApplicableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LimitApplicable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LimitApplicable> validator() {
		return new LimitApplicableValidator();
	}

	@Override
	public Validator<? super LimitApplicable> typeFormatValidator() {
		return new LimitApplicableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LimitApplicable, Set<String>> onlyExistsValidator() {
		return new LimitApplicableOnlyExistsValidator();
	}
}
