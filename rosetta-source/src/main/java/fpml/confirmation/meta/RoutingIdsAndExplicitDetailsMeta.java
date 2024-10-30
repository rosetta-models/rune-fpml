package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RoutingIdsAndExplicitDetails;
import fpml.confirmation.validation.RoutingIdsAndExplicitDetailsTypeFormatValidator;
import fpml.confirmation.validation.RoutingIdsAndExplicitDetailsValidator;
import fpml.confirmation.validation.exists.RoutingIdsAndExplicitDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RoutingIdsAndExplicitDetails.class)
public class RoutingIdsAndExplicitDetailsMeta implements RosettaMetaData<RoutingIdsAndExplicitDetails> {

	@Override
	public List<Validator<? super RoutingIdsAndExplicitDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingIdsAndExplicitDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RoutingIdsAndExplicitDetails> validator() {
		return new RoutingIdsAndExplicitDetailsValidator();
	}

	@Override
	public Validator<? super RoutingIdsAndExplicitDetails> typeFormatValidator() {
		return new RoutingIdsAndExplicitDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingIdsAndExplicitDetails, Set<String>> onlyExistsValidator() {
		return new RoutingIdsAndExplicitDetailsOnlyExistsValidator();
	}
}
