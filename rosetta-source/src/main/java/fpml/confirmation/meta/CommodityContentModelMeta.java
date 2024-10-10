package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.validation.CommodityContentModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityContentModelValidator;
import fpml.confirmation.validation.exists.CommodityContentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityContentModel.class)
public class CommodityContentModelMeta implements RosettaMetaData<CommodityContentModel> {

	@Override
	public List<Validator<? super CommodityContentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityContentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityContentModel> validator() {
		return new CommodityContentModelValidator();
	}

	@Override
	public Validator<? super CommodityContentModel> typeFormatValidator() {
		return new CommodityContentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityContentModel, Set<String>> onlyExistsValidator() {
		return new CommodityContentModelOnlyExistsValidator();
	}
}
