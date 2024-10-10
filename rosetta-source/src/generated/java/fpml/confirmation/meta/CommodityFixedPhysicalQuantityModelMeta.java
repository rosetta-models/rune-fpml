package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.validation.CommodityFixedPhysicalQuantityModelTypeFormatValidator;
import fpml.confirmation.validation.CommodityFixedPhysicalQuantityModelValidator;
import fpml.confirmation.validation.exists.CommodityFixedPhysicalQuantityModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityFixedPhysicalQuantityModel.class)
public class CommodityFixedPhysicalQuantityModelMeta implements RosettaMetaData<CommodityFixedPhysicalQuantityModel> {

	@Override
	public List<Validator<? super CommodityFixedPhysicalQuantityModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityFixedPhysicalQuantityModel>create(fpml.confirmation.validation.datarule.CommodityFixedPhysicalQuantityModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedPhysicalQuantityModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityFixedPhysicalQuantityModel> validator() {
		return new CommodityFixedPhysicalQuantityModelValidator();
	}

	@Override
	public Validator<? super CommodityFixedPhysicalQuantityModel> typeFormatValidator() {
		return new CommodityFixedPhysicalQuantityModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedPhysicalQuantityModel, Set<String>> onlyExistsValidator() {
		return new CommodityFixedPhysicalQuantityModelOnlyExistsValidator();
	}
}
