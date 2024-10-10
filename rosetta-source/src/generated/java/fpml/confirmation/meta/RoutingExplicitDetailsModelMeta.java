package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RoutingExplicitDetailsModel;
import fpml.confirmation.validation.RoutingExplicitDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.RoutingExplicitDetailsModelValidator;
import fpml.confirmation.validation.exists.RoutingExplicitDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RoutingExplicitDetailsModel.class)
public class RoutingExplicitDetailsModelMeta implements RosettaMetaData<RoutingExplicitDetailsModel> {

	@Override
	public List<Validator<? super RoutingExplicitDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RoutingExplicitDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RoutingExplicitDetailsModel> validator() {
		return new RoutingExplicitDetailsModelValidator();
	}

	@Override
	public Validator<? super RoutingExplicitDetailsModel> typeFormatValidator() {
		return new RoutingExplicitDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingExplicitDetailsModel, Set<String>> onlyExistsValidator() {
		return new RoutingExplicitDetailsModelOnlyExistsValidator();
	}
}
