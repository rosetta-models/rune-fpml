package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Routing;
import fpml.confirmation.validation.RoutingTypeFormatValidator;
import fpml.confirmation.validation.RoutingValidator;
import fpml.confirmation.validation.exists.RoutingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Routing.class)
public class RoutingMeta implements RosettaMetaData<Routing> {

	@Override
	public List<Validator<? super Routing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Routing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Routing> validator() {
		return new RoutingValidator();
	}

	@Override
	public Validator<? super Routing> typeFormatValidator() {
		return new RoutingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Routing, Set<String>> onlyExistsValidator() {
		return new RoutingOnlyExistsValidator();
	}
}
