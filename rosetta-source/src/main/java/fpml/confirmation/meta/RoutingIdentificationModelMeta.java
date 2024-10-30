package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RoutingIdentificationModel;
import fpml.confirmation.validation.RoutingIdentificationModelTypeFormatValidator;
import fpml.confirmation.validation.RoutingIdentificationModelValidator;
import fpml.confirmation.validation.exists.RoutingIdentificationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RoutingIdentificationModel.class)
public class RoutingIdentificationModelMeta implements RosettaMetaData<RoutingIdentificationModel> {

	@Override
	public List<Validator<? super RoutingIdentificationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RoutingIdentificationModel>create(fpml.confirmation.validation.datarule.RoutingIdentificationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RoutingIdentificationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RoutingIdentificationModel> validator() {
		return new RoutingIdentificationModelValidator();
	}

	@Override
	public Validator<? super RoutingIdentificationModel> typeFormatValidator() {
		return new RoutingIdentificationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RoutingIdentificationModel, Set<String>> onlyExistsValidator() {
		return new RoutingIdentificationModelOnlyExistsValidator();
	}
}
