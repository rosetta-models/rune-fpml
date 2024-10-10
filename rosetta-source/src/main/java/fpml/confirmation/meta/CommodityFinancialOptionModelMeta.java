package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFinancialOptionModel;
import fpml.confirmation.validation.CommodityFinancialOptionModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityFinancialOptionModelValidator;
import fpml.confirmation.validation.exists.CommodityFinancialOptionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityFinancialOptionModel.class)
public class CommodityFinancialOptionModelMeta implements RosettaMetaData<CommodityFinancialOptionModel> {

	@Override
	public List<Validator<? super CommodityFinancialOptionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFinancialOptionModel>create(fpml.confirmation.validation.datarule.CommodityFinancialOptionModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFinancialOptionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFinancialOptionModel> validator() {
		return new CommodityFinancialOptionModelValidator();
	}

	@Override
	public Validator<? super CommodityFinancialOptionModel> typeFormatValidator() {
		return new CommodityFinancialOptionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFinancialOptionModel, Set<String>> onlyExistsValidator() {
		return new CommodityFinancialOptionModelOnlyExistsValidator();
	}
}
