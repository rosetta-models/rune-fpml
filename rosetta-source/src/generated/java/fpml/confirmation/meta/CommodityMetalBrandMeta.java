package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMetalBrand;
import fpml.confirmation.validation.CommodityMetalBrandTypeFormatValidator;
import fpml.confirmation.validation.CommodityMetalBrandValidator;
import fpml.confirmation.validation.exists.CommodityMetalBrandOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityMetalBrand.class)
public class CommodityMetalBrandMeta implements RosettaMetaData<CommodityMetalBrand> {

	@Override
	public List<Validator<? super CommodityMetalBrand>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalBrand, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMetalBrand> validator() {
		return new CommodityMetalBrandValidator();
	}

	@Override
	public Validator<? super CommodityMetalBrand> typeFormatValidator() {
		return new CommodityMetalBrandTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalBrand, Set<String>> onlyExistsValidator() {
		return new CommodityMetalBrandOnlyExistsValidator();
	}
}
