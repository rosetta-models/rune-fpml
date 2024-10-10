package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalOptionModel;
import fpml.confirmation.validation.CommodityPhysicalOptionModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalOptionModelValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalOptionModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPhysicalOptionModel.class)
public class CommodityPhysicalOptionModelMeta implements RosettaMetaData<CommodityPhysicalOptionModel> {

	@Override
	public List<Validator<? super CommodityPhysicalOptionModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPhysicalOptionModel>create(fpml.confirmation.validation.datarule.CommodityPhysicalOptionModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalOptionModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalOptionModel> validator() {
		return new CommodityPhysicalOptionModelValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalOptionModel> typeFormatValidator() {
		return new CommodityPhysicalOptionModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalOptionModel, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalOptionModelOnlyExistsValidator();
	}
}
