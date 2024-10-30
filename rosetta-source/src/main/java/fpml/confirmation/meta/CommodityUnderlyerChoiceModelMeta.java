package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import fpml.confirmation.validation.CommodityUnderlyerChoiceModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityUnderlyerChoiceModelValidator;
import fpml.confirmation.validation.exists.CommodityUnderlyerChoiceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityUnderlyerChoiceModel.class)
public class CommodityUnderlyerChoiceModelMeta implements RosettaMetaData<CommodityUnderlyerChoiceModel> {

	@Override
	public List<Validator<? super CommodityUnderlyerChoiceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityUnderlyerChoiceModel>create(fpml.confirmation.validation.datarule.CommodityUnderlyerChoiceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityUnderlyerChoiceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityUnderlyerChoiceModel> validator() {
		return new CommodityUnderlyerChoiceModelValidator();
	}

	@Override
	public Validator<? super CommodityUnderlyerChoiceModel> typeFormatValidator() {
		return new CommodityUnderlyerChoiceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityUnderlyerChoiceModel, Set<String>> onlyExistsValidator() {
		return new CommodityUnderlyerChoiceModelOnlyExistsValidator();
	}
}
