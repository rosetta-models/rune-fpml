package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingStructureIndexModel;
import fpml.confirmation.validation.PricingStructureIndexModelTypeFormatValidator;
import fpml.confirmation.validation.PricingStructureIndexModelValidator;
import fpml.confirmation.validation.exists.PricingStructureIndexModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PricingStructureIndexModel.class)
public class PricingStructureIndexModelMeta implements RosettaMetaData<PricingStructureIndexModel> {

	@Override
	public List<Validator<? super PricingStructureIndexModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PricingStructureIndexModel>create(fpml.confirmation.validation.datarule.PricingStructureIndexModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingStructureIndexModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingStructureIndexModel> validator() {
		return new PricingStructureIndexModelValidator();
	}

	@Override
	public Validator<? super PricingStructureIndexModel> typeFormatValidator() {
		return new PricingStructureIndexModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructureIndexModel, Set<String>> onlyExistsValidator() {
		return new PricingStructureIndexModelOnlyExistsValidator();
	}
}
