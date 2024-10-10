package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCoalCompositionModel;
import fpml.confirmation.validation.CommodityCoalCompositionModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityCoalCompositionModelValidator;
import fpml.confirmation.validation.exists.CommodityCoalCompositionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityCoalCompositionModel.class)
public class CommodityCoalCompositionModelMeta implements RosettaMetaData<CommodityCoalCompositionModel> {

	@Override
	public List<Validator<? super CommodityCoalCompositionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityCoalCompositionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityCoalCompositionModel> validator() {
		return new CommodityCoalCompositionModelValidator();
	}

	@Override
	public Validator<? super CommodityCoalCompositionModel> typeFormatValidator() {
		return new CommodityCoalCompositionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityCoalCompositionModel, Set<String>> onlyExistsValidator() {
		return new CommodityCoalCompositionModelOnlyExistsValidator();
	}
}
