package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import fpml.confirmation.validation.CommodityNonPeriodicPaymentDatesModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityNonPeriodicPaymentDatesModelValidator;
import fpml.confirmation.validation.exists.CommodityNonPeriodicPaymentDatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityNonPeriodicPaymentDatesModel.class)
public class CommodityNonPeriodicPaymentDatesModelMeta implements RosettaMetaData<CommodityNonPeriodicPaymentDatesModel> {

	@Override
	public List<Validator<? super CommodityNonPeriodicPaymentDatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityNonPeriodicPaymentDatesModel>create(fpml.confirmation.validation.datarule.CommodityNonPeriodicPaymentDatesModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityNonPeriodicPaymentDatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityNonPeriodicPaymentDatesModel> validator() {
		return new CommodityNonPeriodicPaymentDatesModelValidator();
	}

	@Override
	public Validator<? super CommodityNonPeriodicPaymentDatesModel> typeFormatValidator() {
		return new CommodityNonPeriodicPaymentDatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNonPeriodicPaymentDatesModel, Set<String>> onlyExistsValidator() {
		return new CommodityNonPeriodicPaymentDatesModelOnlyExistsValidator();
	}
}
