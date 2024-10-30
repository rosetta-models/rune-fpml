package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityForward;
import fpml.confirmation.validation.EquityForwardTypeFormatValidator;
import fpml.confirmation.validation.EquityForwardValidator;
import fpml.confirmation.validation.exists.EquityForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EquityForward.class)
public class EquityForwardMeta implements RosettaMetaData<EquityForward> {

	@Override
	public List<Validator<? super EquityForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityForward> validator() {
		return new EquityForwardValidator();
	}

	@Override
	public Validator<? super EquityForward> typeFormatValidator() {
		return new EquityForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityForward, Set<String>> onlyExistsValidator() {
		return new EquityForwardOnlyExistsValidator();
	}
}
