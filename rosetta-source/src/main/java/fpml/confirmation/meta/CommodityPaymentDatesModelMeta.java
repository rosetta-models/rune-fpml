package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.validation.CommodityPaymentDatesModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityPaymentDatesModelValidator;
import fpml.confirmation.validation.exists.CommodityPaymentDatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPaymentDatesModel.class)
public class CommodityPaymentDatesModelMeta implements RosettaMetaData<CommodityPaymentDatesModel> {

	@Override
	public List<Validator<? super CommodityPaymentDatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPaymentDatesModel>create(fpml.confirmation.validation.datarule.CommodityPaymentDatesModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPaymentDatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPaymentDatesModel> validator() {
		return new CommodityPaymentDatesModelValidator();
	}

	@Override
	public Validator<? super CommodityPaymentDatesModel> typeFormatValidator() {
		return new CommodityPaymentDatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPaymentDatesModel, Set<String>> onlyExistsValidator() {
		return new CommodityPaymentDatesModelOnlyExistsValidator();
	}
}
