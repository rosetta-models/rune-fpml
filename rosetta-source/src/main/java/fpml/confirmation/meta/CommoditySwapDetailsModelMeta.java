package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommoditySwapDetailsModel;
import fpml.confirmation.validation.CommoditySwapDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.CommoditySwapDetailsModelValidator;
import fpml.confirmation.validation.exists.CommoditySwapDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommoditySwapDetailsModel.class)
public class CommoditySwapDetailsModelMeta implements RosettaMetaData<CommoditySwapDetailsModel> {

	@Override
	public List<Validator<? super CommoditySwapDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommoditySwapDetailsModel>create(fpml.confirmation.validation.datarule.CommoditySwapDetailsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommoditySwapDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommoditySwapDetailsModel> validator() {
		return new CommoditySwapDetailsModelValidator();
	}

	@Override
	public Validator<? super CommoditySwapDetailsModel> typeFormatValidator() {
		return new CommoditySwapDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwapDetailsModel, Set<String>> onlyExistsValidator() {
		return new CommoditySwapDetailsModelOnlyExistsValidator();
	}
}
