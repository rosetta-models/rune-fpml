package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import fpml.confirmation.validation.PricingCoordinateOrReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.PricingCoordinateOrReferenceModelValidator;
import fpml.confirmation.validation.exists.PricingCoordinateOrReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PricingCoordinateOrReferenceModel.class)
public class PricingCoordinateOrReferenceModelMeta implements RosettaMetaData<PricingCoordinateOrReferenceModel> {

	@Override
	public List<Validator<? super PricingCoordinateOrReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PricingCoordinateOrReferenceModel>create(fpml.confirmation.validation.datarule.PricingCoordinateOrReferenceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingCoordinateOrReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingCoordinateOrReferenceModel> validator() {
		return new PricingCoordinateOrReferenceModelValidator();
	}

	@Override
	public Validator<? super PricingCoordinateOrReferenceModel> typeFormatValidator() {
		return new PricingCoordinateOrReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingCoordinateOrReferenceModel, Set<String>> onlyExistsValidator() {
		return new PricingCoordinateOrReferenceModelOnlyExistsValidator();
	}
}
