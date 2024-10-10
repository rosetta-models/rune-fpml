package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RoutingExplicitDetails;
import fpml.confirmation.validation.RoutingExplicitDetailsTypeFormatValidator;
import fpml.confirmation.validation.RoutingExplicitDetailsValidator;
import fpml.confirmation.validation.exists.RoutingExplicitDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RoutingExplicitDetails.class)
public class RoutingExplicitDetailsMeta implements RosettaMetaData<RoutingExplicitDetails> {

	@Override
	public List<Validator<? super RoutingExplicitDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingExplicitDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RoutingExplicitDetails> validator() {
		return new RoutingExplicitDetailsValidator();
	}

	@Override
	public Validator<? super RoutingExplicitDetails> typeFormatValidator() {
		return new RoutingExplicitDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingExplicitDetails, Set<String>> onlyExistsValidator() {
		return new RoutingExplicitDetailsOnlyExistsValidator();
	}
}
