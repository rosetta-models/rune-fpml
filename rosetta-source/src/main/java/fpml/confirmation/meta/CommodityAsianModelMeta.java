package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityAsianModel;
import fpml.confirmation.validation.CommodityAsianModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityAsianModelValidator;
import fpml.confirmation.validation.exists.CommodityAsianModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityAsianModel.class)
public class CommodityAsianModelMeta implements RosettaMetaData<CommodityAsianModel> {

	@Override
	public List<Validator<? super CommodityAsianModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityAsianModel>create(fpml.confirmation.validation.datarule.CommodityAsianModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityAsianModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityAsianModel> validator() {
		return new CommodityAsianModelValidator();
	}

	@Override
	public Validator<? super CommodityAsianModel> typeFormatValidator() {
		return new CommodityAsianModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityAsianModel, Set<String>> onlyExistsValidator() {
		return new CommodityAsianModelOnlyExistsValidator();
	}
}
