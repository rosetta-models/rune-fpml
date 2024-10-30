package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FailureToPayType;
import fpml.confirmation.validation.FailureToPayTypeTypeFormatValidator;
import fpml.confirmation.validation.FailureToPayTypeValidator;
import fpml.confirmation.validation.exists.FailureToPayTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FailureToPayType.class)
public class FailureToPayTypeMeta implements RosettaMetaData<FailureToPayType> {

	@Override
	public List<Validator<? super FailureToPayType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FailureToPayType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FailureToPayType> validator() {
		return new FailureToPayTypeValidator();
	}

	@Override
	public Validator<? super FailureToPayType> typeFormatValidator() {
		return new FailureToPayTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FailureToPayType, Set<String>> onlyExistsValidator() {
		return new FailureToPayTypeOnlyExistsValidator();
	}
}
