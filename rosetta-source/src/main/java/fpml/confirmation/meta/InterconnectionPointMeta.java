package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterconnectionPoint;
import fpml.confirmation.validation.InterconnectionPointTypeFormatValidator;
import fpml.confirmation.validation.InterconnectionPointValidator;
import fpml.confirmation.validation.exists.InterconnectionPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InterconnectionPoint.class)
public class InterconnectionPointMeta implements RosettaMetaData<InterconnectionPoint> {

	@Override
	public List<Validator<? super InterconnectionPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterconnectionPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterconnectionPoint> validator() {
		return new InterconnectionPointValidator();
	}

	@Override
	public Validator<? super InterconnectionPoint> typeFormatValidator() {
		return new InterconnectionPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterconnectionPoint, Set<String>> onlyExistsValidator() {
		return new InterconnectionPointOnlyExistsValidator();
	}
}
