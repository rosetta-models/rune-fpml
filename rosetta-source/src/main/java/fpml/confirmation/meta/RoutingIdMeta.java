package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RoutingId;
import fpml.confirmation.validation.RoutingIdTypeFormatValidator;
import fpml.confirmation.validation.RoutingIdValidator;
import fpml.confirmation.validation.exists.RoutingIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RoutingId.class)
public class RoutingIdMeta implements RosettaMetaData<RoutingId> {

	@Override
	public List<Validator<? super RoutingId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RoutingId> validator() {
		return new RoutingIdValidator();
	}

	@Override
	public Validator<? super RoutingId> typeFormatValidator() {
		return new RoutingIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingId, Set<String>> onlyExistsValidator() {
		return new RoutingIdOnlyExistsValidator();
	}
}
